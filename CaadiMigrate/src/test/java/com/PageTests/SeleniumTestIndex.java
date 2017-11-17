/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PageTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.PagesObejects.*;
import junit.framework.Assert;

/**
 *
 * @author frodo
 */
public class SeleniumTestIndex {
    
    
    
    @Test
    public void TestMenuLinksCount (){
        
        String Url = "http://localhost:8080/CaadiMigrate/";
        int linksEsperados = 5;
        
        PageObjectIndex Index = new PageObjectIndex();
        Index.OpenBrowserAndNavigate(Url);
        
        int NumEnlaces = Index.FindElementByTag("a").size();
        Assert.assertEquals(linksEsperados, NumEnlaces);
        
        Index.CloseBrowser();
    }
    
}
