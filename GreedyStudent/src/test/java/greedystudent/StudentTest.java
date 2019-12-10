/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedystudent;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import greedystudent.domain.Student;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matcher.*;

/**
 *
 * @author lehtmikk
 */
public class StudentTest {
    
    Student student;
    
    @Before
    public void setUp() {
        this.student = new Student(100, 100);
    }
    
    @Test
    public void moveRightTest(){
        student.moveRight();
        assertTrue(student.movingRight);
    }
    @Test
    public void moveLeftTest(){
        student.moveLeft();
        assertTrue(student.movingLeft);
    }

}
