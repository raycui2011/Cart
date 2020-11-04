/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebubble.calculator.cart;

import java.util.List;
import java.util.Iterator;
import java.util.Set;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.Optional;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author raycui
 */
public class Cart {
    protected ArrayList<ArrayList<CartItem>> items = new ArrayList<ArrayList<CartItem>> ();
    protected Price p;
    protected FileProcessor fp = new FileProcessor();
    protected JSONArray cartData;
    
    public Cart(String filePath, Price price) {
        fp.parseFile(filePath);
        cartData = fp.getParsedData();
        p = price;
    }
    
    
    public void addCartItem( ArrayList newItem ) {  
        items.add(newItem);
    }
    
    
    public void caculateCart() {
       ArrayList<PriceItem> priceItem = this.p.getPriceData();
        
       float total = 0;
       Iterator iterator = items.iterator();
        while(iterator.hasNext()) {
            long price = 0;
            long total_price = 0;
            long sum = 0;
            ArrayList e = (ArrayList) iterator.next();
            for (int i = 0 ; i < e.size(); i++) {
               CartItem ci = (CartItem) e.get(i);
               price = this.findPrice(ci, priceItem);
               ci.getProduct().setPrice(price);
               total_price = ci.getQuantity() * (price + Math.round(price * ci.getMarkup() / 100));
               ci.setTotalPrice(total_price);
               
            }
        }
    }
    
    public long findPrice(CartItem item, ArrayList<PriceItem> priceItem) {
        long p = 0;
        for(PriceItem pi : priceItem) {
           ArrayList size = pi.getSize();
           ArrayList color = pi.getColor(); 
           JSONObject options = pi.getOpions(); 
           if (pi.getType().equals(item.getProductType())) {
              Set set = options.keySet();
              Optional<Set> checkColourNull = Optional.ofNullable(set); 
              if (checkColourNull.isPresent()) {
                  Boolean isSizeNull = size.isEmpty();
                  boolean isColorNull = color.isEmpty();
                  Optional<ArrayList> checkSizeNull = Optional.ofNullable(size); 
                  Optional<ArrayList> checkColorNull = Optional.ofNullable(color);
                   if (!isSizeNull) {
                      if (!isColorNull) {
                         if (size.contains(item.getSize()) && color.contains(item.getColour())) {
                            p = pi.getPrice();
                         } 
                      } else {
                          if (size.contains(item.getSize())) {
                               p = pi.getPrice();
                          }
                      }
                   } else {
                       if (color.contains(item.getColour())) {
                               p = pi.getPrice();
                        }
                   }
              } else {
                  p = pi.getPrice();
              }
            }
        }
        return p;
                    
 
    }
    public ArrayList getCartItem() {
        return items;
    }
   
    public void parseCartItemObject() {
        
        CartItem ci = null;
        String product_type = "";
        long markup = 0;
        long quantity = 0;
        JSONObject e = null;
        ArrayList<CartItem> list = new ArrayList<CartItem>();
        JSONParser jsonParser = new JSONParser();
        for (int i =0 ; i < cartData.size(); i++) {
            JSONObject o = (JSONObject) cartData.get(i);
            product_type  =  (String) o.get("product-type");
            markup  =  (long) o.get("artist-markup");
            quantity  =  (long) o.get("quantity");
            e = (JSONObject) o.get("options");
            ci = new CartItem(product_type, markup, e, quantity);
            list.add(ci);
        }
        addCartItem(list);
    }
    
   public void printCartDetails() {
       Iterator iterator = items.iterator();
       while(iterator.hasNext()) {
            ArrayList al = (ArrayList)iterator.next();
            long sum = 0;
            for (int i=0; i<al.size();i++) {
                CartItem ci = (CartItem) al.get(i);
                System.out.println(" ************************** ");
                System.out.println(" -------------------------- ");
                System.out.println("Product Type is " + ci.getProductType());
                System.out.println("Quantity is " + ci.getQuantity());
                System.out.println("Size is " + ci.getSize());
                System.out.println("Colour is " + ci.getColour());
                System.out.println("Print Location is " + ci.getPrintLocation());
                System.out.println("Total price is $" + formatValue(ci.getTotal()));
                sum = sum + ci.getTotal();
                System.out.println(" -------------------------- ");
                System.out.println(" ************************** ");
            }
            System.out.println(" **********Total is ************* $" + formatValue(sum));
       }
       
       
   }
   
   private String formatValue(Long v) {
       Double d  = v.doubleValue();
       String strDouble = String.format("%.3f", d/1000);
       return strDouble;
   }
   
   private String toTitle (String s) {
      String s1 = s.substring(0,1).toUpperCase();
      String sTitle = s1 + s.substring(1);
      return sTitle;
    }
}
