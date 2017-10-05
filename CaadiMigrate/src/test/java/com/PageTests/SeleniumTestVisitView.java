/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PageTests;

import com.PagesObejects.PageObjectBase;
import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author walter
 */
public class SeleniumTestVisitView {
    
    @Test
    public void testCheckData() throws Exception {
        String visitViewURL = "http://localhost:8080/CaadiMigrate/faces/visit/View.xhtml";
        PageObjectBase VisitView = new PageObjectBase();
        VisitView.OpenBrowserAndNavigate(visitViewURL);
        
        int links = VisitView.FindElementByTag("a").size();
        Assert.assertEquals(5, links);

        String title = VisitView.GetTitlePage();
        boolean correctTitle = "View".equals(title);

        VisitView.CloseBrowser();
    }
}
