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
public class CommandProcessorTest {
    Price p;
    Cart cart;
    CommandProcessor processor;
	
	@Before
	public void initialise() throws CalculatorException {
	  processor = new CommandProcessor();               
	}

	@Test
	public void testExecuteCommandWithCalculatorNotSet() throws CalculatorException {
        try {
            processor.executeCommand("CALCULATE");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Cannot process any commands until the calculator has been SET");
        }
        
        
        
        
    }
 
 @Test
 public void testExecuteCommandWithCalculatorTwo() throws CalculatorException {
     try {
            processor.executeCommand("SET ded-test.json");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Cannot process any commands until the calculator has been SET.");
        }
 }
 
 @Test
 public void testExecuteCommandWithCalculatorThree() throws CalculatorException {
     processor.executeCommand("EXIT");
     assertTrue(processor.isCommandsFinished());
    }
 
 @Test
 public void testExecuteCommandWithCalculatorFour() throws Exception {
     
     processor.executeCommand("SET cart-11356.json");
     p = processor.getPrice();
     cart = processor.getCart();
     assertEquals(p.getPath(), "base-prices.json");
    }
}


