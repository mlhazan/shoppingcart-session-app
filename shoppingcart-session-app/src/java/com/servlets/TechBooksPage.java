package com.servlets;

/**
 *
 * @author Hasan
 */
public class TechBooksPage extends CatalogPage {

     @Override
     public void init() {
          String[] ids = {"hall001", "hall002"};
          setItems(ids);
          setTitle("All-Time Best Computer Books");
     }
}
