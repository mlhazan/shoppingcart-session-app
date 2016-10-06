package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Hasan
 */
public abstract class CatalogPage extends HttpServlet {

     private Item[] items;
     private String[] itemIDs;
     private String title;

     protected void setItems(String[] itemIDs) {
          this.itemIDs = itemIDs;
          items = new Item[itemIDs.length];
          for (int i = 0; i < itemIDs.length; i++) {
               items[i] = Catalog.getItem(itemIDs[i]);
          }
     }

     protected void setTitle(String titles) {
          this.title = titles;
     }

     public void doGet(HttpServletRequest request,
             HttpServletResponse response)
             throws ServletException, IOException {
          response.setContentType("text/html");
          if (items == null) {
               response.sendError(response.SC_NOT_FOUND,
                       "Missing Items.");
               return;
          }
          PrintWriter out = response.getWriter();
          out.println(ServletUtilities.headWithTitle(title)
                  + "<BODY BGCOLOR=\"#FDF5E6\">\n"
                  + "<H1 ALIGN=\"CENTER\">" + title + "</H1>");
          Item item;
          for (int i = 0; i < items.length; i++) {
               out.println("<HR>");
               item = items[i];
// Show error message if subclass lists item ID
// thatâ€™s not in the catalog.
               if (item == null) {
                    out.println("<FONT COLOR=\"RED\">"
                            + "Unknown item ID " + itemIDs[i]
                            + "</FONT>");
               } else {
                    out.println();
                    String formURL
                            = "/shoppingcart-session-app/OrderPage";
// Pass URLs that reference own site through encodeURL.
                    formURL = response.encodeURL(formURL);
                    out.println("<FORM ACTION=\"" + formURL + "\">\n"
                            + "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\" "
                            + " VALUE=\"" + item.getItemID() + "\">\n"
                            + "<H2>" + item.getShortDescription()
                            + " ($" + item.getCost() + ")</H2>\n"
                            + item.getLongDescription() + "\n"
                            + "<P>\n<CENTER>\n"
                            + "<INPUT TYPE=\"SUBMIT\" "
                            + "VALUE=\"Add to Shopping Cart\">\n"
                            + "</CENTER>\n<P>\n</FORM>");
               }
          }
          out.println("<HR>\n</BODY></HTML>");

     }

     /**
      * POST and GET requests handled identically.
      */
     public void doPost(HttpServletRequest request,
             HttpServletResponse response)
             throws ServletException, IOException {
          doGet(request, response);
     }
}
