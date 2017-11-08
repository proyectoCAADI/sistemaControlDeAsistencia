/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Tests.UnitTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.PureClasses.Calculadora.Calculadora;

/**
 *
 * @author frodo
 */
public class PruebaJunit1 {
    
    @Test
    public void ProbarSuma (){
        int a = 3, b = 3;
        int resultadoTentativo = Calculadora.sumar(a,b);
        int resultadoReal      = a+b;
        
        //ejecutar prueba unitaria
        assertEquals(resultadoReal, resultadoTentativo);
        
    }
    
    public PruebaJunit1() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
