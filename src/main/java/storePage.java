/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.project4.utils.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.ListIterator; 
/**
 *
 * @author Kati
 */

@WebServlet(urlPatterns = {"/storePage"})
public class storePage extends HttpServlet {
    String URL = Database.URL;
    String USERNAME = Database.USERNAME;
    String PASSWORD = Database.PASSWORD;
    LinkedList<String> history = new LinkedList<String>();

    Connection connection = null;
    PreparedStatement selectProduct = null;
    PreparedStatement selectHistory = null;
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
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            selectProduct = connection.prepareStatement("SELECT * FROM items");
            
            HttpSession session = request.getSession();
            String var = (String) session.getAttribute("myId");
            if (!(var == null) && !history.contains(var)){
                if(history.size() == 5){
                    history.pollLast();
                }
                history.addFirst(var);
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response); 
            
            ResultSet products= selectProduct.executeQuery();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("</head>");
            out.println(    "<link href=\"css/store.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
                "<link href=\"css/index.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
                "</head>"+
                "<body>" +
                "<div class=\"main\">" +
                "<div class=\"row\">");
            while ( products.next()) {
                out.println("<div class=\"column\">" +
                "<div class=\"content\" id=\"" + products.getString("id") + "\" onclick=\"sendData('"+ products.getString("id") + "')\">" +
                "<img src=\""+products.getString("picture")+"\" style=\"width:100%\">" +
                " <h4>"+products.getString("name")+"</h4>" +
                "<p><b>$"+products.getInt("price")+"</b></p>" +
                "<div class=\"texts\">" +
                "<p><b>Type: </b>" + products.getString("type") + "&nbsp&nbsp&nbsp<b>Color: </b>" + products.getString("color") + "</p>" +
                "</div>" +
                "</div>" +
                "</div>");
            }

            out.println("</div>" + 
                    "</div>");
                        if (history.size() > 0){
                out.println("<b><font size = '6.25'>&nbsp Recently Viewed: </font></b>");
                out.println("<br></br>");
            }
            ListIterator list_Iter = history.listIterator(0);
            while(list_Iter.hasNext()){
                String name = (String) list_Iter.next();
                out.println("&nbsp&nbsp&nbsp&nbsp&nbsp" + name);
                out.println("<br></br>");
            }
            out.println("</body>" + "</html>");
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
            Logger.getLogger(storePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(storePage.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(storePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(storePage.class.getName()).log(Level.SEVERE, null, ex);
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
