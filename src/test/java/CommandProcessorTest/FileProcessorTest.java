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

@RunWith(JUnit4.class)
public class FileProcessorTest {
    Price p;
    Cart cart;
    FileProcessor fp;
 
    @Before
	public void initialise() throws CalculatorException {
	   fp = new FileProcessor();               
	}
 
 @Test
 public void testParseFile() throws Exception {
     fp.parseFile("cart-11356.json");
     assertEquals(fp.getParsedData().size(), 1);
     JSONObject o = (JSONObject) fp.getParsedData().get(0);
     assertEquals((String) o.get("product-type"), "hoodie");
     assertEquals(Long.toString((Long) o.get("artist-markup")), "30");
     assertEquals(Long.toString((Long)o.get("quantity")), "2");
     JSONObject options = (JSONObject) o.get("options");
     assertEquals((String) options.get("size"), "xl");
     assertEquals((String) options.get("colour"), "dark");
     assertEquals((String) options.get("print-location"), "back");
 }
 
 @Test
 public void testParseFileTwo() throws Exception {
     fp.parseFile("cart-4560.json");
     assertEquals(fp.getParsedData().size(), 2);
     JSONObject o = (JSONObject) fp.getParsedData().get(0);
     assertEquals((String) o.get("product-type"), "hoodie");
     assertEquals(Long.toString((Long) o.get("artist-markup")), "20");
     assertEquals(Long.toString((Long)o.get("quantity")), "2");
     JSONObject options = (JSONObject) o.get("options");
     assertEquals((String) options.get("size"), "small");
     assertEquals((String) options.get("colour"), "dark");
     assertEquals((String) options.get("print-location"), "front");
     
     JSONObject o1 = (JSONObject) fp.getParsedData().get(1);
     assertEquals((String) o1.get("product-type"), "sticker");
     assertEquals(Long.toString((Long) o1.get("artist-markup")), "10");
     assertEquals(Long.toString((Long)o1.get("quantity")), "1");
     JSONObject options1 = (JSONObject) o.get("options");
     assertEquals((String) options1.get("size"), "small");
 }
 
 @Test
 public void testParseFileThree() throws Exception {
     fp.parseFile("cart-9363.json");
     assertEquals(fp.getParsedData().size(), 1);
     JSONObject o = (JSONObject) fp.getParsedData().get(0);
     assertEquals((String) o.get("product-type"), "hoodie");
     assertEquals(Long.toString((Long) o.get("artist-markup")), "30");
     assertEquals(Long.toString((Long)o.get("quantity")), "2");
     JSONObject options = (JSONObject) o.get("options");
     assertEquals((String) options.get("size"), "xl");
     assertEquals((String) options.get("colour"), "dark");
     assertEquals((String) options.get("print-location"), "back");
 }
 
 
 @Test
 public void testParseFileFour() throws Exception {
     fp.parseFile("cart-9500.json");
     assertEquals(fp.getParsedData().size(), 2);
     JSONObject o = (JSONObject) fp.getParsedData().get(0);
     assertEquals((String) o.get("product-type"), "hoodie");
     assertEquals(Long.toString((Long) o.get("artist-markup")), "20");
     assertEquals(Long.toString((Long)o.get("quantity")), "1");
     JSONObject options = (JSONObject) o.get("options");
     assertEquals((String) options.get("size"), "small");
     assertEquals((String) options.get("colour"), "white");
     assertEquals((String) options.get("print-location"), "front");
     
     JSONObject o1 = (JSONObject) fp.getParsedData().get(1);
     assertEquals((String) o1.get("product-type"), "hoodie");
     assertEquals(Long.toString((Long) o1.get("artist-markup")), "30");
     assertEquals(Long.toString((Long)o1.get("quantity")), "1");
     JSONObject options1 = (JSONObject) o.get("options");
     assertEquals((String) options1.get("size"), "small");
     assertEquals((String) options.get("colour"), "white");
     assertEquals((String) options.get("print-location"), "front");
 }
}
