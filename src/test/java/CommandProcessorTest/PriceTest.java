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
import com.sun.org.apache.bcel.internal.generic.LoadClass;
import java.io.FileNotFoundException;
import java.util.Iterator;
public class PriceTest {
    Price p;
    
    
    @Before
    public void initialise() throws CalculatorException {
        p = new Price("base-prices.json");
    }
    
    @Test
    public void testPrice() throws CalculatorException {
        assertEquals(p.getPath(), "base-prices.json");
        
    }
    
    @Test
    public void testPriceOne() throws CalculatorException {
        assertEquals(p.getPriceData().size(), 10);
        PriceItem pi = (PriceItem)p.getPriceData().get(0);
        ArrayList<String> size = new ArrayList<String>();
        size.add("small");
        size.add("medium");
        assertEquals(pi.getSize(), size);
        ArrayList<String> color = new ArrayList<String>();
        color.add("white");
        color.add("dark");
        assertEquals(pi.getColor(), color);
        assertEquals(Long.toString(pi.getPrice()), "3800");
        assertEquals(pi.getType(), "hoodie");
        
        PriceItem pi1 = (PriceItem)p.getPriceData().get(1);
        ArrayList<String> size1 = new ArrayList<String>();
        size1.add("large");
        assertEquals(pi1.getSize(), size1);
        ArrayList<String> color1 = new ArrayList<String>();
        color1.add("white");
        assertEquals(pi1.getColor(), color1);
        assertEquals(Long.toString(pi1.getPrice()), "3848");
        assertEquals(pi1.getType(), "hoodie");
    }
    
    @Test
    public void testPriceTwo() throws CalculatorException {
        PriceItem pi2 = (PriceItem)p.getPriceData().get(2);
        ArrayList<String> size2 = new ArrayList<String>();
        size2.add("xl");
        size2.add("2xl");
        size2.add("3xl");
        assertEquals(pi2.getSize(), size2);
        ArrayList<String> color2 = new ArrayList<String>();
        color2.add("white");
        assertEquals(pi2.getColor(), color2);
        assertEquals(Long.toString(pi2.getPrice()), "4108");
        assertEquals(pi2.getType(), "hoodie");
    }
    
    @Test
    public void testPriceThree() throws CalculatorException {
        PriceItem pi3 = (PriceItem)p.getPriceData().get(3);
        ArrayList<String> size3 = new ArrayList<String>();
        size3.add("large");

        assertEquals(pi3.getSize(), size3);
        ArrayList<String> color3 = new ArrayList<String>();
        color3.add("dark");
        assertEquals(pi3.getColor(), color3);
        assertEquals(Long.toString(pi3.getPrice()), "4212");
        assertEquals(pi3.getType(), "hoodie");
    }
    
    @Test
    public void testPriceFour() throws CalculatorException {
        PriceItem pi4 = (PriceItem)p.getPriceData().get(4);
        ArrayList<String> size4 = new ArrayList<String>();
        size4.add("xl");
        size4.add("2xl");
        size4.add("3xl");
        assertEquals(pi4.getSize(), size4);
        ArrayList<String> color4 = new ArrayList<String>();
        color4.add("dark");
        assertEquals(pi4.getColor(), color4);
        assertEquals(Long.toString(pi4.getPrice()), "4368");
        assertEquals(pi4.getType(), "hoodie");
    }
    
    @Test
    public void testPriceFive() throws CalculatorException {
        PriceItem pi5 = (PriceItem)p.getPriceData().get(5);
        assertEquals(Long.toString(pi5.getPrice()), "221");
        assertEquals(pi5.getType(), "sticker");
    }
    
    @Test
    public void testPriceSix() throws CalculatorException {
        PriceItem pi6 = (PriceItem)p.getPriceData().get(6);
        ArrayList<String> size6 = new ArrayList<String>();
        size6.add("medium");
        assertEquals(pi6.getSize(), size6);
        assertEquals(Long.toString(pi6.getPrice()), "583");
        assertEquals(pi6.getType(), "sticker");
    }
    
    @Test
    public void testPriceSeven() throws CalculatorException {
        PriceItem pi7 = (PriceItem)p.getPriceData().get(7);
        ArrayList<String> size7 = new ArrayList<String>();
        size7.add("large");
        assertEquals(pi7.getSize(), size7);
        assertEquals(Long.toString(pi7.getPrice()), "1000");
        assertEquals(pi7.getType(), "sticker");
    }
    
    @Test
    public void testPriceEight() throws CalculatorException {
        PriceItem pi8 = (PriceItem)p.getPriceData().get(8);
        ArrayList<String> size8 = new ArrayList<String>();
        size8.add("xl");
        assertEquals(pi8.getSize(), size8);
        assertEquals(Long.toString(pi8.getPrice()), "1417");
        assertEquals(pi8.getType(), "sticker");
    }
    
    @Test
    public void testPriceNine() throws CalculatorException {
        PriceItem pi9 = (PriceItem)p.getPriceData().get(9);
        assertEquals(pi9.getType(), "leggings");
        assertEquals(Long.toString(pi9.getPrice()), "5000");
    }
    
}
