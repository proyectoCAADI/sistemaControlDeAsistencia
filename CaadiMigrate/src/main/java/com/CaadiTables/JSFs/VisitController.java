package com.CaadiTables.JSFs;

import com.CaadiTables.Entities.Visit;
import com.CaadiTables.JSFs.util.JsfUtil;
import com.CaadiTables.JSFs.util.PaginationHelper;
import com.CaadiTables.Beans.VisitFacade;
import com.CaadiTables.Entities.Periods;
import com.CaadiTables.Entities.Students;
import com.CaadiTables.Entities.VisitPK;
import com.CaadiTables.JSFs.util.Herramientas;
import com.PerfilBase.PerfilBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;


        
@Named("visitController")
@SessionScoped
public class VisitController implements Serializable {

    private Visit current;
    private DataModel items = null;
    @EJB
    private com.CaadiTables.Beans.VisitFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private String NuaPlano;
    
    private UIComponent mensaje;

    public UIComponent getMensaje() {
        return mensaje;
    }

    public void setMensaje(UIComponent mensaje) {
        this.mensaje = mensaje;
    }
    
    public void validar(){
       
        
    }
    
    public void eliminarConectado(String NUA){
        Herramientas.removeFromHashByKey(NUA);
    }
    

    public void mostrarDialogoIngreso(){
        if( current.getNua() != null )
            RequestContext.getCurrentInstance().execute("PF('entrar').show();");
        else         
        {
            FacesContext.getCurrentInstance().addMessage("txtNUA", new FacesMessage( FacesMessage.SEVERITY_ERROR, "NUA Incorrecto o Vacio", null));   
            RequestContext.getCurrentInstance().execute("limpiarTxtNUA();"); 
        }
    }
    
    public void mostrarDialogoSalida(){
        if( current.getNua() != null && Herramientas.containsKeyInHash( current.getNua().getNua()) == true )
            RequestContext.getCurrentInstance().execute("PF('salir').show();");           
        else       
        {
            FacesContext.getCurrentInstance().addMessage("txtNUA", new FacesMessage( FacesMessage.SEVERITY_ERROR, "NUA Incorrecto o Vacio", null));
            RequestContext.getCurrentInstance().execute("limpiarTxtNUA();"); 
        }        
    }

    // regresar una lista con el contenido de los elementos del hash de sesiones
    public  List<PerfilBase> listarHashContent (){
        
        List<PerfilBase> perfiles = new ArrayList<PerfilBase>();
        
        Map<String,Object> CurrentHash = Herramientas.GetHash();
        
        for( Map.Entry<String,Object> entrada : CurrentHash.entrySet() ){
            
            try{
                PerfilBase perfil = (PerfilBase)entrada.getValue();
                perfiles.add( perfil );
            }
            catch( Exception ex ){
                continue;
            }
        }
             
        return perfiles;
    }
    
    
    public String calcularDeltaFechas ( Date fechaInicio ){
        
        Long delta = new Date().getTime() - fechaInicio.getTime()/(1000 * 60 * 60 * 24);
        return delta.toString();
        
    }
    
    public void logInAsStudent (){          
        if( current.getNua() != null ){
            
            // ver si la sesion no esta en el hash 
            if ( !Herramientas.containsKeyInHash( current.getNua().getNua()) ){
                
                // conseguir las referencias a los objetos 
                current.setPeriodId( (Periods) Herramientas.getEm().find(Periods.class,1) );
                
                // llenar la informacin de visita
                current.setStart( new Date () );
                
                // crear un nuevo perfil 
                PerfilBase nuevoPerfil = new PerfilBase ();
                nuevoPerfil.setInfoEst( current.getNua() );
                nuevoPerfil.setInfoVst( current );
                nuevoPerfil.setInfoLibro( current.getLibro() );
               
                // meter el perfil en el hash
                Herramientas.putInHash(current.getNua().getNua(), nuevoPerfil);
                
                FacesContext.getCurrentInstance().addMessage("txtNUA", new FacesMessage( FacesMessage.SEVERITY_INFO, "Puedes empezar", null));
            }
            else
                FacesContext.getCurrentInstance().addMessage("txtNUA", new FacesMessage( FacesMessage.SEVERITY_ERROR, "Ya esta registrado", null));
              
           RequestContext.getCurrentInstance().execute("limpiarTxtNUA();"); 
        }
    }
    
    public void logOutAsStudent ( String skill ){
        if( current.getNua() != null ){
            // buscar el perfil en el hash de sesiones 
            PerfilBase pb = (PerfilBase)Herramientas.findObjectInHashByKey(current.getNua().getNua()); 
        
            // llenar los valores faltantes 
            pb.getInfoVst().setEnd( new Date() );
            pb.getInfoVst().setVisitPK( new VisitPK( 0 , pb.getInfoLibro().getIdLibro() ) );
            pb.getInfoVst().setSkill(skill);
            
            // persistir el objeto
            getFacade().create( pb.getInfoVst() );
            
            FacesContext.getCurrentInstance().addMessage("txtNUA", new FacesMessage( FacesMessage.SEVERITY_INFO, "Hasta luego", null));
            
            // eliminar el perfil del hash
            Herramientas.removeFromHashByKey( pb.getInfoEst().getNua() );  
            current.getNua().setNua("");
        }
    }
    
    
    public VisitController() {
    }

    public Visit getSelected() {
        if (current == null) {
            current = new Visit();
            selectedItemIndex = -1;
        }
        return current;
    }

    private VisitFacade getFacade() {
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
        current = (Visit) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Visit();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("VisitCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Visit) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("VisitUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Visit) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("VisitDeleted"));
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

    public Visit getVisit(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Visit.class)
    public static class VisitControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VisitController controller = (VisitController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "visitController");
            return controller.getVisit(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Visit) {
                Visit o = (Visit) object;
                return getStringKey(o.getVisitPK().getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Visit.class.getName());
            }
        }

    }

    public String getNuaPlano() {
        return NuaPlano;
    }

    public void setNuaPlano(String NuaPlano) {
        this.NuaPlano = NuaPlano;
    }
    
    

}
