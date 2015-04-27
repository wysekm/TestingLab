package pl.edu.agh.internetshop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AddressTest {

    @Test
    public void testConstructor() {
        String name = "Adam Kowalski";
        String streetAndHomeNr = "ul. Wierna 6/9";
        String postalCode = "03-890";
        String city = "Warszawa";

        Address address = new Address(name, streetAndHomeNr, postalCode, city);

        assertEquals(name, address.getName());
        assertEquals(streetAndHomeNr, address.getStreetAndHomeNr());
        assertEquals(postalCode, address.getCode());
        assertEquals(city, address.getCity());
    }
}