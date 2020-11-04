/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebubble.calculator.cart;

import java.util.ArrayList;
import org.json.simple.JSONObject;
public class Product extends Options{
    String product_type;
    long markup;
    long price;
    
    public Product (String product_type, JSONObject o,long markup) {
        product_type = product_type;
        options = o;
        markup = markup;
    }
    
    public void setPrice (long p) {
        price = p;
    }
    
    public long getPrice() {
        return price;
    }
    
    @Override
    public String toString () {
       return product_type + "   " + markup;
    }
}