/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedystudent;

import greedystudent.domain.GameLogic;
import greedystudent.domain.Level;
import greedystudent.domain.Student;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat; 

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
        this.c = new Student(10, 10);
        this.l = new Level(600, 1);
        this.g = new GameLogic(c, l);
    }
    
    @Test
    public void aliveStatusT (){
        g.aliveStatus();
        assertThat(c.isAlive, is(true));
    }
    
    @Test
    public void updateXmovementRight(){
        c.moveRight();
        double lastX = c.getX();
        g.charMovementX();
        assertThat(c.getX(), is(lastX + 5));
    }
    @Test
    public void updateXmovementLeft(){
        c.moveLeft();
        double lastX = c.getX();
        g.charMovementX();
        assertThat(c.getX(), is(lastX - 5));
    }
    @Test
    public void coinListEmpty(){
        l.getCoinList().removeAll(l.getCoinList());
        g.checkCoins();
        assertTrue(g.allcoins);
    }
    @Test
    public void coinListHasCoins(){
        g.checkCoins();
        assertFalse(g.allcoins);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
