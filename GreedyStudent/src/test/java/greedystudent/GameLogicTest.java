/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedystudent;

import greedystudent.domain.GameLogic;
import greedystudent.domain.Level;
import greedystudent.domain.Student;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lehtmikk
 */
public class GameLogicTest {
    
    Student c;
    GameLogic g;
    Level l;
    @Before
    public void setUp() {
        Student c = new Student(10, 10);
        Level l = new Level(600);
        GameLogic g = new GameLogic(c, l);
    }
    
    /*@Test
    public void aliveStatusT (){
        c.setY(20);
        g.aliveStatus();
        assertTrue(c.isAlive);
    }*/
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
