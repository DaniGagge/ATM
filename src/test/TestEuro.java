package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import code.Business_logic.Euro;

public class TestEuro {

    private Euro testEuro1;
    private Euro testEuro2;
    private Euro testEuro3;

    @Before
    public void setUp(){
        testEuro1 = new Euro(10,50);
        testEuro2 = new Euro(5,40);
        testEuro3 = new Euro(15,90);
    }

    @Test
    public void testGetValore() {
        assertEquals(1050,testEuro1.getValore());
    }

    @Test
    public void testSomma() {
        assertEquals(testEuro3.getValore(),testEuro1.somma(testEuro2).getValore());
    }

    @Test
    public void testSottrai() {
        assertEquals(testEuro2.getValore(),testEuro3.sottrai(testEuro1).getValore());
    }

    @Test
    public void testUgualeA() {
        assertTrue(testEuro1.ugualeA(testEuro1));
    }

    @Test
    public void testMinoreDi() {
        assertTrue(testEuro2.minoreDi(testEuro1));
    }

    @Test
    public void testStampa() {
        assertEquals("10.5 euro",testEuro1.stampa());
    }
}
