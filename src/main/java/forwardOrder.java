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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kati
 */
@WebServlet(urlPatterns = {"/forwardOrder"})
public class forwardOrder extends HttpServlet {
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
            
            

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stmt = connection.createStatement(); 
            //out.println("INSERT INTO confirm " + "VALUES ('"+fn+"','"+ln+"','"+pn+"','"+ad+"','"+ci+"','"+st+"','"+zi+"','"+sh+"','"+ca+"','"+ex+"','"+se+"')");
            stmt.executeUpdate ("INSERT INTO confirm " + "VALUES ('"+fn+"','"+ln+"','"+pn+"','"+ad+"','"+ci+"','"+st+"','"+zi+"','"+sh+"','"+ca+"','"+ex+"','"+se+"')");
            
            RequestDispatcher rd=request.getRequestDispatcher("orderConfirm");  
            rd.forward(request, response);
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
            Logger.getLogger(forwardOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(forwardOrder.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(forwardOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(forwardOrder.class.getName()).log(Level.SEVERE, null, ex);
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
