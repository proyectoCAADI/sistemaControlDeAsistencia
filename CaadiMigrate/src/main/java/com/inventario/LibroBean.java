
package com.inventario;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

@Named(value = "bean")
@SessionScoped
@ManagedBean

public class LibroBean implements Serializable {

    private ArrayList<Libro> lista = new ArrayList<>();
    private String codbar;
    private String nua;
    
    public LibroBean() {  
    }

    public ArrayList<Libro> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Libro> lista) {
        this.lista = lista;
    }

    public String getCodbar() {
        return codbar;
    }

    public void setCodbar(String codbar) {
        this.codbar = codbar;
    }

    public String getNua() {
        return nua;
    }

    public void setNua(String nua) {
        this.nua = nua;
    }
    
    public void agregar() {
            Libro libro = new Libro(this.codbar);
            lista.add(libro);
    }
    
    public void borrar(Libro libro) {
		lista.remove(libro);
    }
    
    public void insertartabla() throws SQLException{
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CaadiIntegrada?zeroDateTimeBehavior=convertToNull","root","palabra1");
        String nua = getNua();
        String codigo = "";
        int idlibro = 0;
        int idvisita = 0;
        
        for(int i=0;i<lista.size();i++){
            codigo = lista.get(i).getCodbar();
            
            PreparedStatement sql1=con.prepareStatement("select id_libro from libro where cod_bar = " + codigo);
            ResultSet res1 = sql1.executeQuery();
            if ( res1.next() ){
               idlibro = res1.getInt("id_libro");
            }
            PreparedStatement sql2=con.prepareStatement("select id from visit where nua = " + nua);
            ResultSet res2 = sql2.executeQuery();
            if ( res2.next() ){
               idvisita = res2.getInt("id");
            }
            
            PreparedStatement ps=con.prepareStatement("insert into registro_libro(id_libro, id_visita) values(?,?)");
            ps.setInt(1,idlibro);
            ps.setInt(2,idvisita);
            ps.executeUpdate();
        }       
    }
    
}
