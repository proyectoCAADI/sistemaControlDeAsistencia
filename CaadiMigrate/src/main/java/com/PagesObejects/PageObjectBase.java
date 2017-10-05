/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PagesObejects;

import java.util.List;
import javafx.scene.web.WebEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
*
 * @author frodo
 */
public class PageObjectBase {
    protected WebDriver ControladorNavegador;
    protected String    Url;

    public PageObjectBase() {
        this.ControladorNavegador = new FirefoxDriver();
    }
    
    public void OpenBrowserAndNavigate ( String Url ){
        this.Url = Url;
        this.ControladorNavegador.get(this.Url);   
    }
   
    public String GetTitlePage (){
        return this.ControladorNavegador.getTitle();
    }
    
    public List<WebElement> FindElementByTag (String ElementTag){
        return this.ControladorNavegador.findElements(By.tagName(ElementTag));
    }
}


