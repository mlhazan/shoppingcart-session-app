/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;
public class KidsBookPage extends CatalogPage{
     @Override
     public void init(){
          String ids[] = {"lewis001", "alexander001", "rowling001"};
          setItems(ids);
          setTitle("All-Time Children's Fantasy Book");
     }
}
