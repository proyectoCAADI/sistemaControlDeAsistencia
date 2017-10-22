package com.Tests.PageOject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By.ById;




public class PageObjetcBase {
    
    protected WebDriver ControladorNavegador;
    protected String    Url;

    public PageObjetcBase() {
        this.ControladorNavegador = new FirefoxDriver();
    }
    
    public void OpenBrowserAndNavigate ( String Url ){
        this.Url = Url;
        this.ControladorNavegador.get(this.Url);   
    }
   
    public String GetTitlePage (){
        return this.ControladorNavegador.getTitle();
    }
    
        
    
}
