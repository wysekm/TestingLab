package pl.edu.agh.internetshop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ShipmentTest {

    Address address = mock(Address.class);
    Shipment shipment;

    @Before
    public void setUp() throws Exception {
        shipment = new Shipment(address, address);
    }

    @Test
    public void testSenderAddressIsSetProperly() {
        assertSame(address, shipment.getSender());
    }

    @Test
    public void testRecipientAddressIsSetProperly() {
        assertSame(address, shipment.getRecipient());
    }

    @Test
    public void testSetShipped() throws Exception {
        assertFalse(shipment.isShipped());
        shipment.setShipped(true);
        assertTrue(shipment.isShipped());
    }
}
