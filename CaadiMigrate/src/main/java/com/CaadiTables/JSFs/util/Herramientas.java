
package com.CaadiTables.JSFs.util;

import java.util.Map;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Herramientas {
    
    private static final String pu = "com.mycompany_CaadiMigrate_war_1.0-SNAPSHOTPU";
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
    private static final EntityManager        em  = emf.createEntityManager();
    

    public static Map<String,Object> GetHash(){  
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 
    }
    
    /** meter una clave en el hash **/
    public static void putInHash ( String key, Object objeto ){
        FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().put(key, objeto);
    }
    
    /** borrar clave del hash **/
    public static void removeFromHashByKey ( String key ){
        FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().remove(key);
    }
    
    /** conseguir objeto a partir de clave **/
    public static Object findObjectInHashByKey ( String Key ){       
        Object objetivo = FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get(Key);
        
        if( objetivo != null )
            return objetivo;
        
        return null;
    }
    
    public static Boolean containsKeyInHash ( String Key ){
        
        Boolean contencion = FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().containsKey(Key);
        
        return contencion;
    }
    
    
    public Herramientas (){
        
    }

    public static String getPu() {
        return pu;
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static EntityManager getEm() {
        return em;
    }
    
    
    
    
    
}
