package pl.edu.agh.internetshop;


public interface SurfaceMailBus extends ShipmentMethod {
    boolean send(Object shipment, Address fromWho, Address toWho);
    boolean isSent(Object shipment);
}
