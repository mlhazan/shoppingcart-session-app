
package com.servlets;
public class KidsBookPage extends CatalogPage{
     @Override
     public void init(){
          String ids[] = {"lewis001", "alexander001", "rowling001"};
          setItems(ids);
          setTitle("All-Time Children's Fantasy Book");
     }
}
