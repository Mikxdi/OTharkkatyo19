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
import greedystudent.domain.Student;

/**
 *
 * @author lehtmikk
 */
public class StudentTest {
    
    Student c;
    
    @Before
    public void setUp() {
        Student c = new Student(0, 0);
    }
    /*
    @Test
    public void moveRightTest(){
        c.moveRight();
        assertTrue(c.movingRight);
    }
    @Test
    public void moveLeftTest(){
        c.moveLeft();
        assertTrue(c.movingLeft);
    }*/

}
