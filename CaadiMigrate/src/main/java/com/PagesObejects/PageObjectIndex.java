/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PagesObejects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author frodo
 */
public class PageObjectIndex extends PageObjectBase{
    private List<WebElement> MenuEnlaces;

    public List<WebElement> getMenuEnlaces() {
        return MenuEnlaces;
    }

    public void setMenuEnlaces(List<WebElement> MenuEnlaces) {
        this.MenuEnlaces = MenuEnlaces;
    }

    public WebDriver getControladorNavegador() {
        return ControladorNavegador;
    }

    public void setControladorNavegador(WebDriver ControladorNavegador) {
        this.ControladorNavegador = ControladorNavegador;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }
    
    
    
    
}
