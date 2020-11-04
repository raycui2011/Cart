/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebubble.calculator.cart;

import java.util.ArrayList;
import java.util.Optional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 *
 * @author raycui
 */
public class CartItem {
  private String product_type;
  private JSONObject options;
  private long markup;
  private long quantity;
  private Product p;
  private String size;
  private String colour;
  private String printLocation;
  private long total_price = 0;
  
  public CartItem(String product_type,  long markup, JSONObject options, long q ) {
      this.product_type = product_type;
      this.markup = markup;
      this.options = options;
      this.quantity = q;
      p = new Product(product_type, options, markup);
      constructOptions(options);
  }
  
  public void setTotalPrice(long total) {
      total_price = total;
  }
  
  public long getTotal() {
      return total_price;
  }
  
  private void constructOptions(JSONObject options) {
        String colorS = (String) options.get("colour");
        String sizeS = (String) options.get("size");
        String printLocationS = (String) options.get("print-location");
        Optional<String> checkColorNull = Optional.ofNullable(colorS);   
        Optional<String> checkSizeNull = Optional.ofNullable(sizeS);
        Optional<String> printLocationNull = Optional.ofNullable(printLocationS);
        if (checkColorNull.isPresent()) {
            colour = colorS;
        }
        if (checkSizeNull.isPresent()) {
            size = sizeS;
        }
        if (printLocationNull.isPresent()) {
            printLocation = printLocationS;
        }
    }
  
  
  public Product getProduct() {
      return p;
  }
  public String getSize() {
      return size;
  }
  
  public String getColour() {
      return colour;
  }
  
  public String getPrintLocation() {
      return printLocation;
  }
  
  public JSONObject getOptions() {
      return options;
  }
  public String getProductType() {
      return product_type;
  }
  
  public long getMarkup () {
      return markup;
  }

  public long getQuantity () {
      return quantity;
  }
  
  public void printDetails() {
      System.out.println(" ************************** ");
      System.out.println(" -------------------------- ");
      System.out.println("Product Type is " + getProductType());
      System.out.println("Quantity is " + getQuantity());
      System.out.println("Size is " + getSize());
      System.out.println("Colour is " + getColour());
      System.out.println("Total price is " + getTotal());
      System.out.println(" -------------------------- ");
      System.out.println(" ************************** ");
  }
  
  @Override
  public String toString() {
      return "product_type is " + getProductType() + " Quantity is " + getQuantity()
       + "Size is ";
  }
}
