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
import java.util.ArrayList;
import org.json.simple.JSONObject;
public class Options {
    protected JSONObject options;
    private ArrayList<String> colour = new ArrayList();
    private ArrayList<String> size = new ArrayList();
    public void Options(JSONObject o) {
        options = o;
        constructData(options);
    }
    
    public JSONObject getOpions() {
        return options;
    }
    
    public void constructData(JSONObject options) {
       colour = (ArrayList) options.get("colour");
       size = (ArrayList) options.get("size");       
    }
    public ArrayList getSize() {
        return size;
    }
    public ArrayList getcolour() {
        return colour;
    }
}
