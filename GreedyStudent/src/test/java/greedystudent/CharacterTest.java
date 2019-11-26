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
import greedystudent.domain.Character;

/**
 *
 * @author lehtmikk
 */
public class CharacterTest {
    
    Character c;
    
    @Before
    public void setUp() {
        Character c = new Character(2, 1);
    }
    
    @Test
    public void moveRight(){
        c.moveRight();
        assertTrue(c.movingRight);
    }
    @Test
    public void moveLeft(){
        c.moveLeft();
        assertTrue(c.movingLeft);
    }

}
