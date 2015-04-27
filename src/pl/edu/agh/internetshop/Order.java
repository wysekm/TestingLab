package pl.edu.agh.internetshop;

import java.util.UUID;


public class Order {
    private final UUID id;
    private final Product product;
    private boolean isPaid;
    private Shipment shipment;
    private ShipmentMethod shipmentMethod;
    private PaymentMethod paymentMethod;

    public Order(Product product) {
        this.product = product;
        id = UUID.randomUUID();
        isPaid = false;
    }

    public UUID getId() {
        return id;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isSent() {
        return shipment != null && shipment.isShipped();
    }

    public boolean isPaid() { return isPaid; }

    public Shipment getShipment() {
        return shipment;
    }

    public int getPrice() {
        return product.getPrice();
    }

    public int getPriceWithTaxes() {
        return (int) (1.22 * getPrice());
    }

    public Product getProduct() {
        return product;
    }

    public ShipmentMethod getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public void send() {
        boolean sentSuccesful = getShipmentMethod().send(shipment, shipment.getSender(), shipment.getRecipient());
        shipment.setShipped(sentSuccesful);
    }

    public void pay(MoneyTransfer moneyTransfer) {
        moneyTransfer.setCommittedSuccessfully(getPaymentMethod().commit(moneyTransfer));
        isPaid = moneyTransfer.isCommitedSuccessfully();
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}
