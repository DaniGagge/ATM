package test;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;

import code.Business_logic.Euro;
import code.Database.BankDatabase;

public class BankDatabaseTest {
    //private Account accounts[];
    private BankDatabase BD;
    @Before
    public void setUp() {
        BD = new BankDatabase(); 
    }
    @Test
    public void testAuthenticateUser() {
        assertTrue(BD.authenticateUser(12345,54321));
        assertFalse(BD.authenticateUser(12345, 66)); //account esistente ma PIN errato
    }

    @Test
    public void testCredit() {
        BD.credit(12345,new Euro(500));
        assertEquals(170000,BD.getTotalBalance(12345).getValore());
    }

    @Test
    public void testDebit() {
        BD.debit(12345,new Euro(500));
        assertEquals(70000,BD.getTotalBalance(12345).getValore());
        assertEquals(50000,BD.getAvailableBalance(12345).getValore());   
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(100000,BD.getAvailableBalance(12345).getValore());
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(120000,BD.getTotalBalance(12345).getValore());
    }
}
