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
@WebServlet(urlPatterns = {"/orderConfirm"})
public class orderConfirm extends HttpServlet {
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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            HttpSession session = request.getSession();
            List<String> list= (List<String>) session.getAttribute("list");
            int total = (int) session.getAttribute("total");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            if(list==null){
              list =new ArrayList<>();
            }
            
            String fn =request.getParameter("first_name");
            String ln =request.getParameter("last_name");
            String pn =request.getParameter("phone");  
            String ad =request.getParameter("address");  
            String ci =request.getParameter("city");  
            String st =request.getParameter("state");  
            String zi =request.getParameter("zip");  
            String sh =request.getParameter("shipping");  
            String ca =request.getParameter("cardnum");  
            String ex =request.getParameter("expire");  
            String se =request.getParameter("security"); 
            
            
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
            
            out.println("<div class=\"main\">"+
                    "<div class=\"confirm\">"+
                    "<h2>Order Confirmation</h2>"+
                    "<h3>Shipping Details</h3>"+
                    "<h4>Shipping to:</h4>");
            out.println("<p>" + fn + ln + "</p>");
            out.println("<p>" + ad + "</p>");
            out.println("<p>" + ci + st + zi + "</p>");
            out.println("<p>" + pn + "</p>");
            out.println("<h4>Shipping Via:</h4>");
            out.println("<p>" + sh + "</p>");
            out.println("<h3>Item Details</h3>");
            out.println("<h4>Items</h4>");
            
            for(String outs : list){
              selectProduct = connection.prepareStatement("SELECT * FROM items WHERE id='"+ outs + "'");
              ResultSet products= selectProduct.executeQuery();
              while ( products.next()) {
                out.println("<p>"+ products.getString("name") + " &nbsp&nbsp&nbsp<b>$"+products.getInt("price")+"</b></p>");
              }
            }

            out.println("<p><b>Total: $" + total + "</b></p>");
            out.println("<h3>Payment Information</h3>");
            out.println("<h4>Card Information</h4>");
            out.println("<p><b>Card No.: </b> " + ca + "</p>");
            out.println("<p><b>Valid: </b> " + ex + " <b>CVV:</b> " + se + "</p>");
            out.println("</div>");
            
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");            
            
            session.removeAttribute("list");
            session.removeAttribute("total");
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(orderConfirm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(orderConfirm.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(orderConfirm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(orderConfirm.class.getName()).log(Level.SEVERE, null, ex);
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
