/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

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
public class KassapaateTest {
    
    Kassapaate paate;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(500);
    }
    
    @Test
    public void alkuRahat(){
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void myydytRuuat(){
        assertEquals(0, paate.edullisiaLounaitaMyyty() + paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateinenEdul(){
        paate.syoEdullisesti(240);
        assertEquals(100240, paate.kassassaRahaa());
    }
    
    @Test
    public void kateinenEdulVaihto(){
        assertEquals(60, paate.syoEdullisesti(300));
    }
    
    @Test
    public void kateinenMauk(){
        paate.syoMaukkaasti(400);
        assertEquals(100400, paate.kassassaRahaa());
    }
    
    @Test
    public void kateinenMaukVaihto(){
        assertEquals(60, paate.syoMaukkaasti(460));
    }
    
    @Test
    public void liianVahanMaukkaasti(){
        assertEquals(350, paate.syoMaukkaasti(350));
    }
    
    @Test
    public void liianVahaEdul(){
        assertEquals(200, paate.syoEdullisesti(200));
    }
    
    @Test
    public void eiKasvaEdul(){
        paate.syoEdullisesti(2);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void eiKasvaMauk(){
        paate.syoMaukkaasti(2);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void myydytMaukkaat(){
        paate.syoMaukkaasti(400);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void myydytEdulliset(){
        paate.syoEdullisesti(240);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttiEdullinen(){
        assertTrue(paate.syoEdullisesti(kortti));
    }
    
    @Test
    public void korttiEdullinenEi(){
        kortti.otaRahaa(400);
        assertFalse(paate.syoEdullisesti(kortti));
    }
    
    @Test
    public void korttiMaukas(){
        assertTrue(paate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void korttiMaukasEi(){
        kortti.otaRahaa(400);
        assertFalse(paate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void veloitusMaukas(){
        paate.syoMaukkaasti(kortti);
        assertEquals(100, kortti.saldo());
    }
    
    @Test
    public void veloitusEdullinen(){
        paate.syoEdullisesti(kortti);
        assertEquals(260, kortti.saldo());
    }
    
    @Test
    public void myydytMaukkaatKortti(){
        paate.syoMaukkaasti(kortti);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void myydytEdullisetKortti(){
        paate.syoEdullisesti(kortti);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }
     
    @Test
    public void eiKasvaEdulKortti(){
        kortti.otaRahaa(400);
        paate.syoEdullisesti(kortti);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void eiKasvaMaukKortti(){
        kortti.otaRahaa(400);
        paate.syoMaukkaasti(kortti);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void lataaRaha(){
        paate.lataaRahaaKortille(kortti, 200);
        assertEquals(700, kortti.saldo());
    }
    
    @Test
    public void lataaRahaKassa(){
        paate.lataaRahaaKortille(kortti, 200);
        assertEquals(100200, paate.kassassaRahaa());
    }
    
    @Test
    public void lataaRahaNega(){
        paate.lataaRahaaKortille(kortti, -20);
        assertEquals(100000, paate.kassassaRahaa());
    }
}
