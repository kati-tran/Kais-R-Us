/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javapapers.sample.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kati
 */
@WebServlet(urlPatterns = {"/productDetails"})


public class productDetails extends HttpServlet {
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String idname = request.getParameter("zip");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            selectProduct = connection.prepareStatement("SELECT * FROM items WHERE id='"+ idname + "'");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\"css/desc.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("<link href=\"css/index.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("</head>");
            out.println("<body>");

            out.println("<ul>");
            out.println("<li><a href=\"about.jsp\">About</a></li>");
            out.println("<li><a class=\"active\" href=\"storePage\">Store</a></li>");
            out.println("<li><a>Kati Tran 33574122</a></li>");
            out.println("<li><a>Jae Yoon Oh 41812159</a></li>");
            out.println("</ul>");

            out.println("<div class=\"about-section\">");
            out.println("<h1>Kais\"R\"Us</h1>");
            out.println("</div>");
            ResultSet products= selectProduct.executeQuery();
            while ( products.next()) {

                out.println("<h1 id=\"title\" style=\"max-width: 1000px; margin: 10px 20px;\">"+ products.getString("name")+ "</h1>");
                out.println("<div class=\"side-bar\">");
                out.println("<img src=\"" + products.getString("picture")+ "\" style=\"width:100px; border:1px solid #ddd;\" onmouseover=\"replaceIMG('"+ products.getString("picture") + "')\">");
                out.println("<img src=\"" + products.getString("picture2")+ "\" style=\"width:100px; border:1px solid #ddd;\" onmouseover=\"replaceIMG('" + products.getString("picture2") + "')\">");
                out.println("</div>");
                out.println("<div class=\"main\">");
                out.println("<div class =\"row\">");
                out.println("<div class=\"column\">");
                out.println("<div class=\"dcontent\">");
                out.println("<img id=\"image\" src=\"" + products.getString("picture") + "\" style=\"width:100%\">");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");

                out.println("<div class=\"checkout\">");
                out.println("<div class=\"writeup\">");
                out.println("<h4><u>Description</u></h4>");
                out.println("<p id=\"writing\">" + products.getString("descrip") + "</p>");
                out.println("<p><u>Price:</u> $" + products.getInt("price") + "</p>");
                out.println("<h4><u>Size</u></h4>");
                out.println("<p id=\"size\">" + products.getString("size") +"</p>");
                out.println("<form action=\"shoppingCart\" method=\"post\"> ");
                out.println("<button class=\"button\" style=\"padding: 20px; font-size:20px; margin: auto; width: 50%;\" >Add to Cart</button>");
                out.println("</form>");
                out.println("</div>");
                
                out.println("</div>");
                
                out.println("<script type=\"text/javascript\">");
                out.println(" function replaceIMG(elem){");
                out.println("document.getElementById(\"image\").src = elem;");
                out.println("}");
                out.println("</script>");
                
                HttpSession s = request.getSession(true);
                s.setAttribute("myId",products.getString("name"));
 
            }

            out.println("</body>");
            out.println("</html>");
            response.setContentType("text/html");
            //response.getWriter().write(idname);

            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productDetails.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(productDetails.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(productDetails.class.getName()).log(Level.SEVERE, null, ex);
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
