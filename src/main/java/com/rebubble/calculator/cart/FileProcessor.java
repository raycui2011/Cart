/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebubble.calculator.cart;

/**
 *
 * @author raycui
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class FileProcessor {
    private JSONArray parsedData;
    
   
    public void parseFile(String filePath)
    {
        JSONParser jsonParser = new JSONParser();
        File file = new File(filePath);
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                 parsedData = (JSONArray) jsonParser.parse(reader);
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                  e.printStackTrace();
             } catch (ParseException e) {
                  e.printStackTrace();
             }
        }
    }
    
    public JSONArray getParsedData() {
        //System.out.println("parsedData" + parsedData);
        return parsedData;
    }
}
