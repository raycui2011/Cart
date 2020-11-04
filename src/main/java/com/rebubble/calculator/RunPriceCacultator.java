package com.rebubble.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.rebubble.calculator.cart.CommandProcessor;

public class RunPriceCacultator {
    public static void main(String[] args) {
        CommandProcessor processor = new CommandProcessor();
        while (!processor.isCommandsFinished()) {
                System.out.println("Enter a command, Valid commands are:");
                System.out.println("SET cart-11356.json|cart-9363.json|cart-4560.json|cart-9500.json,base-prices.json CALCULATE or EXIT");
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
                String commandStr;
                try {
                        commandStr = reader1.readLine();
                        if (commandStr != null) {
                            processor.executeCommand(commandStr);
                        }
                } catch (IOException e) {
                        System.out.println("IO Error:");
                        e.printStackTrace();
                }
            }
    }
}
