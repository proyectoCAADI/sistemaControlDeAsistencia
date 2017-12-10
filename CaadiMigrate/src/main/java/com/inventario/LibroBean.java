
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
import java.util.List;
import javax.faces.bean.ManagedBean;

@Named(value = "bean")
@SessionScoped
@ManagedBean

public class LibroBean implements Serializable {

    private ArrayList<Libro> lista = new ArrayList<>();
    private String codbar;
    
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
    
    public void agregar() {
            Libro libro = new Libro(this.codbar);
            lista.add(libro);
    }
    
    public void borrar(Libro libro) {
		lista.remove(libro);
    }
    
    public void insertartabla() throws SQLException{
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CaadiIntegrada?zeroDateTimeBehavior=convertToNull","root","palabra1");
        
        PreparedStatement ps=con.prepareStatement("insert into libro_registro(cod_bar, nua) values(?,810230)");
        
        for(int i=0;i<lista.size();i++){
            ps.setString(1,lista.get(i).getCodbar());
            ps.executeUpdate();
        }
    }
    
}
