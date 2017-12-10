/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CaadiTables.Beans;

import com.CaadiTables.Entities.HojaTrabajo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author frodo
 */
@Stateless
public class HojaTrabajoFacade extends AbstractFacade<HojaTrabajo> {

    @PersistenceContext(unitName = "com.mycompany_CaadiMigrate_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HojaTrabajoFacade() {
        super(HojaTrabajo.class);
    }
    
}
