
package com.inventario;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
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
}
