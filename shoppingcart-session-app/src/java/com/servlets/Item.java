/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

/**
 *
 * @author Hasan
 */
public class Item {

     private String itemID;
     private String shortDescription;
     private String longDescription;
     private double cost;

     public Item(String itemID, String shortDescription,
             String longDescription, double cost) {
          setItemID(itemID);
          setShortDescription(shortDescription);
          setLongDescription(longDescription);
          setCost(cost);
     }

     public String getItemID() {
          return (itemID);
     }

     protected void setItemID(String itemID) {
          this.itemID = itemID;
     }

     public String getShortDescription() {
          return (shortDescription);
     }

     protected void setShortDescription(String shortDescription) {
          this.shortDescription = shortDescription;
     }

     public String getLongDescription() {
          return (longDescription);
     }

     protected void setLongDescription(String longDescription) {
          this.longDescription = longDescription;
     }

     public double getCost() {
          return (cost);
     }

     protected void setCost(double cost) {
          this.cost = cost;
     }
}
