<%-- 
    Document   : index
    Created on : May 21, 2020, 2:48:47 PM
    Author     : Kati
--%>

<%@page import="java.sql.*"%>
<%Class.forName("com.mysql.cj.jdbc.Driver");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project3</title>
    </head>
    <body>
        
        <h1>test!</h1>
        <%!
        public class Product {
            String URL = "jdbc:mysql://localhost:3306/proj2database";
            String USERNAME = "root";
            String PASSWORD = "";

            Connection connection = null;
            PreparedStatement selectProduct = null;
            ResultSet resultSet = null;

            public Product() {
                
                try {
                    
                    
                    
                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    selectProduct = connection.prepareStatement(
                        "SELECT * FROM items");
       
                } catch (Exception e){
                    System.out.println("connection error");
                    e.printStackTrace();
                }
            }

            public ResultSet getProducts(){

                try {
                    resultSet = selectProduct.executeQuery();
                }   catch (SQLException e){
                    e.printStackTrace();
                }
            
                return resultSet;
            }
        }
        %>
        <%
            Product product = new Product();
            ResultSet products = product.getProducts();
            products.next();
        %>
        
        <td><%= products.getString("name")%></td>
        

    </body>
</html>