/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandProcessorTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import com.rebubble.calculator.cart.CommandProcessor;
import com.rebubble.calculator.cart.*;
import com.rebubble.calculator.exceptions.CalculatorException;
import java.io.FileNotFoundException;
import java.util.Iterator;
public class CartItemTest {
    Price p;
    Cart cart;
    CartItem ci;
    CommandProcessor processor;
    
    @Before
    public void initialise() throws CalculatorException {
        processor = new CommandProcessor();
    }
    @Test
    public void testCartItem() throws CalculatorException {
        processor.executeCommand("SET cart-11356.json,base-prices.json");
        cart = processor.getCart();
        cart.parseCartItemObject();
        cart.caculateCart();
        assertEquals(cart.getCartItem().size(), 1);
        Iterator iterator = cart.getCartItem().iterator();
        while(iterator.hasNext()) {
            ArrayList al = (ArrayList)iterator.next();
            CartItem ci = (CartItem) al.get(0);
            assertEquals(ci.getProductType(), "hoodie");
            assertEquals(ci.getColour(), "dark");
            assertEquals(Long.toString(ci.getTotal()), "11356");
            assertEquals(ci.getSize(), "xl");
            assertEquals(Long.toString(ci.getQuantity()), "2");
        }
        processor.executeCommand("exit");
    }
 
    
    @Test
    public void testCartItemOne() throws CalculatorException {
        processor.executeCommand("SET cart-9500.json,base-prices.json");
        cart = processor.getCart();
        cart.parseCartItemObject();
        cart.caculateCart();
        assertEquals(cart.getCartItem().size(), 1);
        Iterator iterator = cart.getCartItem().iterator();
        while(iterator.hasNext()) {
            ArrayList al = (ArrayList)iterator.next();
            CartItem ci = (CartItem) al.get(0);
            assertEquals(ci.getProductType(), "hoodie");
            assertEquals(ci.getColour(), "white");
            assertEquals(ci.getSize(), "small");
            assertEquals(ci.getPrintLocation(), "front");
            assertEquals(Long.toString(ci.getQuantity()), "1");
            
            CartItem ci1 = (CartItem) al.get(1);
            assertEquals(ci1.getProductType(), "hoodie");
            assertEquals(ci1.getColour(), "dark");
            assertEquals(ci1.getSize(), "small");
            assertEquals(ci1.getPrintLocation(), "front");
            assertEquals(Long.toString(ci.getQuantity()), "1");
        }
        processor.executeCommand("exit");
    }
    
    @Test
    public void testCartItemTwo() throws CalculatorException {
        processor.executeCommand("SET cart-9363.json,base-prices.json");
        cart = processor.getCart();
        cart.parseCartItemObject();
        cart.caculateCart();
        Iterator iterator = cart.getCartItem().iterator();
        while(iterator.hasNext()) {
            ArrayList al = (ArrayList)iterator.next();
            CartItem ci = (CartItem) al.get(0);
            assertEquals(ci.getProductType(), "hoodie");
            assertEquals(ci.getColour(), "dark");
            assertEquals(ci.getSize(), "xl");
            assertEquals(ci.getPrintLocation(), "back");
            assertEquals(Long.toString(ci.getQuantity()), "2");
            assertEquals(Long.toString(ci.getMarkup()), "30");
        }
        
        processor.executeCommand("exit");
    }
    
    @Test
    public void testCartItemThree() throws CalculatorException {
        processor.executeCommand("SET cart-4560.json,base-prices.json");
        cart = processor.getCart();
        cart.parseCartItemObject();
        cart.caculateCart();
        Iterator iterator = cart.getCartItem().iterator();
        while(iterator.hasNext()) {
            ArrayList al = (ArrayList)iterator.next();
            CartItem ci = (CartItem) al.get(0);
            assertEquals(ci.getProductType(), "hoodie");
            assertEquals(ci.getColour(), "dark");
            assertEquals(ci.getSize(), "small");
            assertEquals(ci.getPrintLocation(), "front");
            assertEquals(Long.toString(ci.getQuantity()), "2");
            assertEquals(Long.toString(ci.getMarkup()), "20");
            
            CartItem ci1 = (CartItem) al.get(1);
            assertEquals(ci1.getProductType(), "sticker");
            assertEquals(ci1.getSize(), "small");
            assertEquals(Long.toString(ci1.getQuantity()), "1");
            assertEquals(Long.toString(ci1.getMarkup()), "10");

        }
        processor.executeCommand("exit");
    }
}
