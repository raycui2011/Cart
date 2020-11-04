/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebubble.calculator.cart;

import com.rebubble.calculator.cart.Options;
import java.util.ArrayList;
import java.util.Optional;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.JSONException;

/**
 *
 * @author raycui
 */
public class PriceItem extends Options{
    private String product_type;
    private long base_price;
    private ArrayList<String> size = new ArrayList<String>();
    private ArrayList<String> colour = new ArrayList<String>();
    
    public PriceItem (String type, JSONObject o, long price) {
        product_type= type;
        options = o;
        base_price = price;
        constructOptions(options);
    }
    
    private void constructOptions(JSONObject options) {
        JSONArray colorA = (JSONArray) options.get("colour");
        JSONArray sizeA = (JSONArray) options.get("size");
        Optional<JSONArray> checkColorNull = Optional.ofNullable(colorA);   
        Optional<JSONArray> checkSizeNull = Optional.ofNullable(sizeA);
        if (checkColorNull.isPresent()) {
            for (int i = 0; i < colorA.size(); i++) {
                colour.add((String) colorA.get(i));
            }                   
        }
        if (checkSizeNull.isPresent()) {
            for (int j = 0; j < sizeA.size(); j++) {
                size.add((String) sizeA.get(j));
            } 
        }
    }
    
    public long getPrice() {
        return base_price;
    }
    public ArrayList getSize() {
        return size;
    }
    public ArrayList getColor() {
        return colour;
    }
    
    public String getType() {
        return product_type;
    }
}
