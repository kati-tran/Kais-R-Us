/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kati
 */
@WebServlet(urlPatterns = {"/checkout"})
public class checkout extends HttpServlet {
    String URL = "jdbc:mysql://localhost:3306/proj2database";
    String USERNAME = "root";
    String PASSWORD = "";

    Connection connection = null;
    PreparedStatement selectProduct = null;
    ResultSet resultSet = null;
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            List<String> list= (List<String>) session.getAttribute("list");
            if(list==null){
              list =new ArrayList<>();
            }
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\"css/confirm.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("<link href=\"css/index.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("</head>");
            out.println("<body>");

            out.println("<ul>");
            out.println("<li><a href=\"about.jsp\">About</a></li>");
            out.println("<li><a class=\"active\" href=\"checkout\">Check Out</a></li>");
            out.println("<li><a href=\"storePage\">Store</a></li>");
            out.println("<li><a>Kati Tran 33574122</a></li>");
            out.println("<li><a>Jae Yoon Oh 41812159</a></li>");
            out.println("</ul>");

            out.println("<div class=\"about-section\">");
            out.println("<h1>Kais\"R\"Us</h1>");
            out.println("</div>");        
            
            int total;
            total = 0;
            
            out.println("<div class=\"main\">"+
                    "<div class=\"confirm\">"+
                    "<h2>Shopping Cart</h2>");
            for(String outs : list){
              selectProduct = connection.prepareStatement("SELECT * FROM items WHERE id='"+ outs + "'");
              ResultSet products= selectProduct.executeQuery();
              while ( products.next()) {
                out.println("<p>"+ products.getString("name") + " &nbsp&nbsp&nbsp<b>$"+products.getInt("price")+"</b></p>");
                total += products.getInt("price");
              }
            }
            out.println("<h3>Total: $" + total + "</h3>");
            out.println("</div>");
            
            
            out.println("<div class=\"checkout\">");
                out.println("<form method=\"post\" action=\"forwardOrder\">");
                out.println("<h2>Purchase</h2>");
                out.println("<label for=\"first_name\">First Name</label>");
                out.println("<input type=\"text\" name=\"first_name\" required placeholder=\"Bob\">");
                out.println("<label for=\"last_name\">Last Name</label>");
                out.println("<input type=\"text\" name=\"last_name\" required placeholder=\"Ross\">");
                out.println("<label for=\"name\">Phone Number</label>");
                out.println("<input type=\"text\" name=\"phone\" required pattern=\"[0-9]{3}-[0-9]{3}-[0-9]{4}\" placeholder=\"123-456-7890\">");
                out.println("<label for=\"name\">Street</label>");
                out.println("<input type=\"text\" name=\"address\" required placeholder=\"123 Sesame Street\">");
                out.println("<label for=\"city\">City </label>");
                out.println("<input id=\"cityname\" type=\"text\" name=\"city\" required placeholder=\"Irvine\">");
                out.println("<label for=\"state\">State</label>");
                out.println("<input id=\"statename\" type=\"text\" name=\"state\" pattern=\"[A-Z]{2}\" required maxlength=\"2\" placeholder=\"CA\">");
                out.println("<label for=\"zip\">Zip</label>");
                out.println("<input type=\"text\" name=\"zip\" pattern=\"[0-9]{5}\" maxlength=\"5\" required placeholder=\"12345\">");
                out.println("<label for=\"ship\">Shipping Speed</label>");
                out.println("<select type=\"text\" name=\"shipping\" id=\"shipping\">");
                out.println("<option value=\"Overnight Shipping\">Overnight Shipping</option>");
                out.println("<option value=\"2day Expedited\">2-Days Expedited</option>");
                out.println("<option value=\"6-Day Ground\">6-Days Ground</option>");
                out.println("</select>");
                out.println("<h2>Credit Card</h2>");
                out.println("<label for=\"card-num\">Credit Card Number</label>");
                out.println("<input type=\"text\" name=\"cardnum\" required pattern=\"[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}\" placeholder=\"1234-5678-9123-4567\">");
                out.println("<label for=\"card-num\">Expire</label>");
                out.println("<input type=\"text\" name=\"expire\" required placeholder=\"4/21\">");
                out.println("<label for=\"card-num\">CVV</label>");
                out.println("<input type=\"text\" name=\"security\" required maxlength=\"3\" placeholder=\"123\">");
                out.println("<input type=\"submit\" value=\"Send\" style=\"padding: 20px; font-size:20px; color:white; background-color: #aaa;\">");
                out.println("</form>");
                out.println("</div>");
            
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
            session.setAttribute("total",total);
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(checkout.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(checkout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(checkout.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(checkout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
