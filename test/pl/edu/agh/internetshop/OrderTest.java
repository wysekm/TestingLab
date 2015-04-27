package pl.edu.agh.internetshop;

import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


public class OrderTest {

    Order order;
    Product product = mock(Product.class);

    @Before
    public void setUP() {
        order = new Order(product);
    }

    @Test
    public void testSetProduct() {
        assertSame(product, order.getProduct());
    }

    @Test
    public void testSetShipment() throws Exception {
        assertNull(order.getShipment());
        Shipment shipment = mock(Shipment.class);
        order.setShipment(shipment);
        assertSame(shipment, order.getShipment());
    }

    @Test
    public void testGetPrice() throws Exception {
        int productPrice = 10000;
        when(product.getPrice()).thenReturn(productPrice);
        assertEquals(10000, order.getPrice());
    }

    @Test
    public void testGetPriceWithTaxes() throws Exception {
        int price = 200;
        when(product.getPrice()).thenReturn(price);
        assertEquals((int) (1.22 * price), order.getPriceWithTaxes());
    }

    @Test
    public void testGetShipmentMethod() {
        ShipmentMethod surface = mock(SurfaceMailBus.class);
        order.setShipmentMethod(surface);
        assertSame(surface, order.getShipmentMethod());
    }

    @Test
    public void testSending() {
        assertFalse(order.isSent());
        SurfaceMailBus surface = mock(SurfaceMailBus.class);
        Shipment shipment = mock(Shipment.class);
        Address address = mock(Address.class);
        when(shipment.getSender()).thenReturn(address);
        when(shipment.getRecipient()).thenReturn(address);
        when(surface.send(any(Object.class), any(Address.class), any(Address.class))).thenReturn(true);
        when(shipment.isShipped()).thenReturn(true);
        order.setShipmentMethod(surface);
        order.setShipment(shipment);
        order.send();
        assertTrue(order.isSent());
    }

    @Test
    public void testWhetherIdExists() throws Exception {
        assertNotNull(order.getId());
    }

    @Test
    public void testSetPaymentMethod() throws Exception {
        PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);
        order.setPaymentMethod(paymentMethod);
        assertSame(paymentMethod, order.getPaymentMethod());
    }

    @Test
    public void testPaying() throws Exception {
        assertFalse(order.isPaid());
        PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);
        when(paymentMethod.commit(any(MoneyTransfer.class))).thenReturn(true);
        order.setPaymentMethod(paymentMethod);
        MoneyTransfer moneyTransfer = mock(MoneyTransfer.class);
        when(moneyTransfer.isCommitedSuccessfully()).thenReturn(true);
        order.pay(moneyTransfer);
        assertTrue(order.isPaid());
    }
}
