/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedystudent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import greedystudent.domain.Level;
/**
 *
 * @author lehtmikk
 */
public class LevelTest {
    Level l;
    
    @Before
    public void setUp() {
        this.l = new Level(720);
    }
    
    @Test
    public void platformListIsNotEmpty(){
        assertTrue(l.getPlatformList()!=null);
        
    } 
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
