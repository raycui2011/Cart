package com.rebubble.calculator.cart;

import com.rebubble.calculator.cart.CartItem;
import com.rebubble.calculator.cart.FileProcessor;
import com.rebubble.calculator.cart.Options;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Price {
    private String path;
    private ArrayList<PriceItem> elements = new ArrayList<PriceItem> ();
    protected FileProcessor fp = new FileProcessor();
    
    public Price(String filePath) {
        path = filePath;
        constructurePriceData();
    }
    
    public String getPath() {
        return path;
    }
    public void addElement(PriceItem a) {
        elements.add(a);
    }
    
    public ArrayList getElements() {
        return elements;
    }
    
    
    public void constructurePriceData() {
        fp.parseFile(path);
        JSONArray arr = fp.getParsedData();
        for (int i =0 ; i < arr.size(); i++) {
            JSONObject o = (JSONObject) arr.get(i);
            String product_type  =  (String) o.get("product-type");
            long base_price  =  (long) o.get("base-price");
            JSONObject options = (JSONObject) o.get("options");
            PriceItem pi = new PriceItem(product_type, options,base_price);
            addElement(pi);
        }
    }
   
    public ArrayList getPriceData() {
        return elements;
    }
    
}
