
package com.inventario;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@Named(value = "bean")
@SessionScoped
public class LibroBean implements Serializable {

    private ArrayList<Libro> lista = new ArrayList<>();
    private String codbar;
    
    public LibroBean() {
        lista.add(new Libro("98789789"));
    }

    public ArrayList<Libro> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Libro> lista) {
        this.lista = lista;
    }
    
    public void agregar(String a) {
            Libro libro = new Libro(a);
            lista.add(libro);
    }
    
}
