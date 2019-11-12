package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussa(){
        assertEquals(10, kortti.saldo());
    }
    
    @Test 
    public void saldonKasvatus(){
        kortti.lataaRahaa(10);
        assertEquals(20, kortti.saldo());
    }
    
    @Test
    public void rahanOttoOnnistuu(){
        kortti.otaRahaa(5);
        assertEquals(5, kortti.saldo());
    }
    
    @Test 
    public void rahanOttoEiOnnistu(){
        kortti.otaRahaa(11);
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void rahaEiRiita(){
        assertFalse(kortti.otaRahaa(12));
    }
    
    @Test 
    public void rahaRiittaa(){
        assertTrue(kortti.otaRahaa(3));
    }
    
    @Test
    public void tuloste(){
        assertEquals("saldo: 0.10", kortti.toString());
    }
}
