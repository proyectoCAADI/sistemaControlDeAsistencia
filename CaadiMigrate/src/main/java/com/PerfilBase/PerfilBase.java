/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PerfilBase;

import com.CaadiTables.Entities.Periods;
import com.CaadiTables.Entities.Students;
import com.CaadiTables.Entities.Visit;


public class PerfilBase {
    
    private Students InfoEst;
    private Visit    InfoVst;
    private Periods  InfoPrd;
    
    
    public PerfilBase (){
        
    }

    public Students getInfoEst() {
        return InfoEst;
    }

    public void setInfoEst(Students InfoEst) {
        this.InfoEst = InfoEst;
    }

    public Visit getInfoVst() {
        return InfoVst;
    }

    public void setInfoVst(Visit InfoVst) {
        this.InfoVst = InfoVst;
    }

    public Periods getInfoPrd() {
        return InfoPrd;
    }

    public void setInfoPrd(Periods InfoPrd) {
        this.InfoPrd = InfoPrd;
    }
    
    
    
}
