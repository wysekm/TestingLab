package pl.edu.agh.internetshop;

public class Shipment {

    private boolean shipped;
    private Address sender;
    private Address recipient;

    public Shipment(Address sender, Address recipient) {
        this.sender = sender;
        this.recipient = recipient;
        shipped = false;
    }

    public Address getSender() { return sender; }

    public Address getRecipient() { return recipient; }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }
}
