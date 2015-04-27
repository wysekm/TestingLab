package pl.edu.agh.internetshop;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


public class MoneyTransferTest {

    BigInteger bankNr = new BigInteger("27114020040000300201355387");
    String ownerDetails = "Jan Maria Masło";
    String description = "Przelew prywatny";
    int amount = 5;
    MoneyTransfer moneyTransfer = new MoneyTransfer(bankNr, ownerDetails, description, amount);

    @Test
    public void testCreation() {
        assertEquals(bankNr, moneyTransfer.getAccNumber());
        assertEquals(ownerDetails, moneyTransfer.getOwnerDetails());
        assertEquals(description, moneyTransfer.getDescription());
        assertEquals(amount, moneyTransfer.getAmount());
    }

    @Test
    public void testCommitting() throws Exception {
        assertFalse(moneyTransfer.isCommitedSuccessfully());
        moneyTransfer.setCommittedSuccessfully(true);
        assertTrue(moneyTransfer.isCommitedSuccessfully());
    }
}