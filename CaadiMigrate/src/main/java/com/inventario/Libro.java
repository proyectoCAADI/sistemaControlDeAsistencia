package com.inventario;

public class Libro {

    private String codbar;
 
    public Libro(){}
    
    public Libro(String codbar) {
        this.codbar = codbar;
    }

    public String getCodbar() {
        return codbar;
    }

    public void setCodbar(String codbar) {
        this.codbar = codbar;
    }
}