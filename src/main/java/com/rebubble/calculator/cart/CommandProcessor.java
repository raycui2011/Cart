/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebubble.calculator.cart;

import com.rebubble.calculator.exceptions.CalculatorException;

public class CommandProcessor {
    private static final String COMMAND_SET = "SET";
    private static final String COMMAND_CALCULATE = "CALCULATE";
    private static final String COMMAND_EXIT = "EXIT";
    private Cart cart = null;
    private Price p = null;
    
    
    boolean commandsFinished = false;
    
    
    public void executeCommand(String commandStr) {
        String errorMessage = "Cannot process any commands until the calculator has been SET.";
        String[] commandSection = commandStr.split(" ", 2);
        String command = commandSection[0].toUpperCase();
        try {          
            switch (command) {
                case COMMAND_SET:
                    setCalculator(commandSection[1]);
                    break;
                 case COMMAND_CALCULATE:
                     cart.parseCartItemObject();
                     cart.caculateCart();
                     cart.printCartDetails();
                     break;
                 case COMMAND_EXIT:
                     this.commandsFinished = true;
                     break;
                 default:
                    System.out.println("Invalid command.");
                    break;
            }
        } catch (NullPointerException e) {
            System.out.println(errorMessage);
        } catch (CalculatorException ee) {
            System.out.println(ee.getMessage());
        }
    }
    public boolean isCommandsFinished() {
        return this.commandsFinished;
    }
    
    private void setCalculator(String commandStr) throws CalculatorException {
        String[] commandParams = commandStr.split(",");
        String filePath = "base-prices.json";
        if (commandParams.length < 1) {
            throw new CalculatorException("At least one parameter is required");
        }
        if (commandParams.length > 1) {
            filePath = commandParams[1];
        }
        p = new Price(filePath);
        cart = new Cart(commandParams[0], p);
    }

    
    public Price getPrice() {
        return p;
    }
    
    public Cart getCart() {
        return cart;
    }
}
