package com.CaadiTables.JSFs;

import com.CaadiTables.Entities.Teachers;
import com.CaadiTables.JSFs.util.JsfUtil;
import com.CaadiTables.JSFs.util.PaginationHelper;
import com.CaadiTables.Beans.TeachersFacade;
import com.CaadiTables.Entities.Groups;
import com.CaadiTables.Entities.Students;
import com.CaadiTables.Entities.Visit;
import com.CaadiTables.JSFs.util.Herramientas;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@Named("teachersController")
@SessionScoped
public class TeachersController implements Serializable {

    private Teachers current;
    private DataModel items = null;
    private List<SelectItem> maestros;
    private List<SelectItem> grupos;
    @EJB
    private com.CaadiTables.Beans.TeachersFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private int idGrupoSeleccionado;
    private List<Students> ListaEstudiantesXGrupo;
 

    public TeachersController() {
    }

    public int getIdGrupoSeleccionado() {
        return idGrupoSeleccionado;
    }

    public void setIdGrupoSeleccionado(int idGrupoSeleccionado) {
        this.idGrupoSeleccionado = idGrupoSeleccionado;
    }
    
    
    // listar todos los grupos para un profesor
    public List<SelectItem> conseguirGrupos() {
        
        List<SelectItem> seleccionados = new ArrayList<SelectItem>();

        if (current.getEmployeeNumber() != null) {

            Teachers teacherActual = getFacade().find(current.getEmployeeNumber());
            current = teacherActual;

            Object[] grupos = teacherActual.getGroupsCollection().toArray();

            Integer i = new Integer(1);
            for (Object grupo : grupos) {
                Groups gn = (Groups) grupo;
                SelectItem tn = new SelectItem(i.toString(), gn.getLearningUnit() + " " + gn.getLevel());
                seleccionados.add(tn);
                i += 1;
            }
        }
        this.grupos = seleccionados;
        return seleccionados;
    }
    

    
    
    public List<SelectItem> conseguirMaestros() {
        
        // buscar todos los maestros 
        List<Teachers>      listaMaestros = getFacade().findAll();
        List<SelectItem>    listaSeleccns = new ArrayList<SelectItem>();
        
        for( Teachers teacher : listaMaestros ){          
            SelectItem nuevoTeacher = new SelectItem(teacher.getEmployeeNumber(),teacher.getName()
                    +" "+ teacher.getFirstLastName() +" "+ teacher.getSecondLastName());
            listaSeleccns.add(nuevoTeacher);           
        }
        this.maestros = listaSeleccns;
        return listaSeleccns;
    }
    
    public String sumarHoras(String nua) {

        // conseguir todas las visitas para el nua indicado
        List<Visit> visitas = Herramientas.getEm().createQuery("select e from Visit e where e.nua.nua = :nua", Visit.class).setParameter("nua", nua)
                .getResultList();
        
        long TotalHoras = 0, TotalMinutos = 0, TotalSegundos = 0;
        
        for( Visit visita : visitas ){
            Calendar CalendarioInicio = Calendar.getInstance(); 
            Calendar CalendarioFinal  = Calendar.getInstance(); 
            
            CalendarioInicio.setTime( visita.getStart() );
            CalendarioFinal.setTime(  visita.getEnd()   );
            
            long milSegundosInicio = 0, milSegundosFinal = 0, deltaHoras = 0,
                 segundos = 0, minutos = 0, horas = 0;
            
            milSegundosInicio = CalendarioInicio.getTimeInMillis();
            milSegundosFinal  = CalendarioFinal.getTimeInMillis();
            
            deltaHoras = milSegundosFinal - milSegundosInicio;
            
            segundos = Math.abs( deltaHoras / 1000 );
            minutos = Math.abs( deltaHoras / (60 * 1000) );
            horas = Math.abs( deltaHoras / (60*60 * 1000) );
            
            TotalHoras += horas;
            TotalMinutos += minutos;
            TotalSegundos += segundos;
        }
        
        return String.valueOf( TotalHoras + ":" + TotalMinutos + ":" + TotalSegundos);

    }
    
    // listar los alumnos del grupo seleccionado
    public List<Students> listarAlumnosXGrupo(){

        List<Students> estList = new ArrayList<Students>();
        
        if (idGrupoSeleccionado > 0) {
            Groups grupo = (Groups) current.getGroupsCollection().toArray()[idGrupoSeleccionado-1];
            Object[] estdns = grupo.getStudentsCollection().toArray();

            for (Object estudiante : estdns) {
                Students NuevoEstudiante = (Students) estudiante;
                estList.add(NuevoEstudiante);
            }
        }
        this.ListaEstudiantesXGrupo = estList;
        return estList;
    }
    
    
    public void crearPdf() throws FileNotFoundException, DocumentException, IOException{
        
        String NombreArchivo = current.getName()+".pdf";
        
        Groups grupoActual = (Groups)current.getGroupsCollection().toArray()[idGrupoSeleccionado-1];
        
        Document  documentoReporte = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(documentoReporte, baos);
        documentoReporte.open();
        
        // agregar datos fuera de la tabla 
        Paragraph linea1 = new Paragraph("Nombre del profesor: "+ " "+ current.getName() 
                + " "+ current.getFirstLastName() +" "+ current.getSecondLastName());
        
        // nivel del curso
        Paragraph linea2 = new Paragraph("Nombre del curso :"+ " "+ grupoActual.getLearningUnit() +" "+
                grupoActual.getLevel()  );
        
        Paragraph linea3 = new Paragraph(" Alumnos: "  );
        
        //agregar lineas al documento
        documentoReporte.add(linea1);
        documentoReporte.add(linea2);
        documentoReporte.add(linea3);
        documentoReporte.add( new Paragraph(" "));
        
        documentoReporte.add( crearTablaReporte() );
        documentoReporte.close();
        
        ExternalContext response = FacesContext.
                getCurrentInstance().getExternalContext();
        
        response.responseReset();
        response.setResponseContentType("application/pdf");
        response.setResponseContentLength(baos.size());
        response.setResponseHeader("Content-Disposition","attachment; filename ="+NombreArchivo);
        
        OutputStream output = response.getResponseOutputStream();
        baos.writeTo(output);
        output.flush();
        output.close();
  
        FacesContext.getCurrentInstance().responseComplete();
        
    }
    
    public PdfPTable crearTablaReporte (){
        
        // crear table de 3 columnas 
        PdfPTable table = new PdfPTable(3);
        
        //agregar celdas de titulo
        table.addCell("NUA");
        table.addCell("Nombre(s) y Apellidos");
        table.addCell("Horas Acumuladas");
        
        
        // recorrer la lista de studiantes 
        for( Students est : this.ListaEstudiantesXGrupo ){
            
            // agregar informacion a las celdas
            table.addCell( est.getNua() );
            table.addCell( est.getName() +" "+  est.getFirstLastName() +" "+ 
                    est.getSecondLastName());
            table.addCell( sumarHoras(est.getNua()) );
        }
        
        return table; 
    }
    
    public void GenerarPdf(){
                
        
        String nua = "143424";
        current.getEmployeeNumber();
        List<Visit> visitas = Herramientas.getEm().createQuery
        ("select e from Visit e where e.nua.nua = :nua",Visit.class).setParameter("nua", nua)
                .getResultList();
        visitas.size();
    }
    


    
    public Teachers getSelected() {
        if (current == null) {
            current = new Teachers();
            selectedItemIndex = -1;
        }
        return current;
    }

    private TeachersFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Teachers) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Teachers();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TeachersCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Teachers) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TeachersUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Teachers) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TeachersDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Teachers getTeachers(java.lang.String id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Teachers.class)
    public static class TeachersControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TeachersController controller = (TeachersController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "teachersController");
            return controller.getTeachers(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Teachers) {
                Teachers o = (Teachers) object;
                return getStringKey(o.getEmployeeNumber());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Teachers.class.getName());
            }
        }

    }

}
