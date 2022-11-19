package test;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;

import code.Business_logic.Account;
import code.Business_logic.Euro;

public class AccountTest {

    private Account a;

    @Before
    public void setUp() {
        a= new Account(12345, 54321, new Euro(1000,0), new Euro(1200,0) ); 
    }

    @Test
    public void testCredit() {
        a.credit(new Euro(300));
        assertEquals(150000,a.getTotalBalance().getValore());
    }

    @Test
    public void testDebit() {
        a.debit(new Euro(300));
        assertEquals(90000,a.getTotalBalance().getValore());
        assertEquals(70000,a.getAvailableBalance().getValore());
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(12345, a.getAccountNumber());
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(100000, a.getAvailableBalance().getValore());
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(120000, a.getTotalBalance().getValore());
    }

    @Test
    public void testValidatePIN() {
        assertTrue(a.validatePIN(54321));
        assertFalse(a.validatePIN(555));
    }
}
