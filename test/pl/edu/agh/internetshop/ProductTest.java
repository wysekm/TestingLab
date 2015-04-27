package pl.edu.agh.internetshop;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;


public class ProductTest {

    @Test
    public void testCreation() throws Exception{
        String productName = "Mr. Sparkle";
        int price = 1099;
        Product product = new Product(productName, price);
        assertEquals(productName, product.getName());
        assertEquals(price, product.getPrice());
    }
}