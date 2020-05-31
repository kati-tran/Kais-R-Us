<%-- 
    Document   : desc
    Created on : May 21, 2020, 5:21:35 PM
    Author     : Kati
--%>

<%@page import="java.sql.*"%>
<%@page import="com.project4.utils.*"%>
<%Class.forName("com.mysql.cj.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    public class Product {
        String URL = Database.URL;
        String USERNAME = Database.USERNAME;
        String PASSWORD = Database.PASSWORD;

        Connection connection = null;
        PreparedStatement selectProduct = null;
        ResultSet resultSet = null;

        public Product() {
                
            try {
                    
                    
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                selectProduct = connection.prepareStatement(
                    "SELECT * FROM items WHERE id='item1'");
       
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
    %>

<!DOCTYPE html>
<html>
  <head>
<link href="css/desc.css" rel="stylesheet" type="text/css">
<link href="css/index.css" rel="stylesheet" type="text/css">
</head>
  <body>

	<ul>
	  <li><a href="about.jsp">About</a></li>
	  <li><a class="active" href="index.jsp">Store</a></li>
    <li><a>Kati Tran 33574122</a></li>
	</ul>

  <div class="about-section">
    <h1>Kais"R"Us</h1>
  </div>

      
<% while ( products.next()) { %>
    <h1 id="title" style="max-width: 1000px; margin: 10px 20px;"><%= products.getString("name")%></h1>
    <div class="side-bar">
    <img src="<%= products.getString("picture")%>" style="width:100px; border:1px solid #ddd;" onmouseover="replaceIMG('<%= products.getString("picture")%>')">
    <img src="<%= products.getString("picture2")%>" style="width:100px; border:1px solid #ddd;" onmouseover="replaceIMG('<%= products.getString("picture2")%>')">
    </div>
    <div class="main">
    <div class ="row">
    <div class="column">
    <div class="dcontent">
    <img id="image" src="<%= products.getString("picture")%>" style="width:100%">
    </div>
    </div>
    </div>
    </div>
        
<% } %>


  <?php
    $zip = $_REQUEST['zip'];
    $servername= "localhost"; $username = "root"; $password = ""; 
      try { $conn = new PDO("mysql:host=$servername;dbname=proj2database", $username, $password); 
        // set the PDO error mode to exception 
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); 
      } 
      catch(PDOException$e) { 
        echo "Connection failed: " . $e->getMessage(); 
    } 
    $result = $conn->query("SELECT * FROM items WHERE id='$zip'");
    while ($row = $result->fetch(PDO::FETCH_ASSOC)) 
    {
      $itemname = $row['name'];
      $price = $row['price'];
      echo '<h1 id="title" style="max-width: 1000px; margin: 10px 20px;">'.$row['name'] .'</h1>';
      echo '<div class="side-bar">';
      echo '<img src="'.$row['picture'] .'" style="width:100px; border:1px solid #ddd;" onmouseover="replaceIMG(\''.$row['picture'] .'\')">';
      echo '<img src="'.$row['picture2'] .'" style="width:100px; border:1px solid #ddd;" onmouseover="replaceIMG(\''.$row['picture2'] .'\')">';
      echo '</div>';
      echo '<div class="main">';
      echo '<div class ="row">';
      echo '<div class="column">';
      echo '<div class="dcontent">';
      echo '<img id="image" src="'.$row['picture'] .'" style="width:100%">';
      echo '</div>';
      echo '</div>';
      echo '</div>';
      echo '</div>';
    } 
  ?>

    <div class="checkout">
    <form method="post" action="confirm.php">
      <h2>Purchase</h2>

      <label for="item_name">Item:</label>
        <input type="text" id="item_name" name="item_name" value="<?php echo $itemname;?>" readonly>

      <div class="pricer">
        <div>
          <label for="amount">Quantity (MAX 9):</label>
            <input type="number" id="number" name="amount" required pattern="[0-9]{1}" maxlength="1" value="1" >
        </div>
      </div>

      <label for="first_name">First Name</label>
        <input type="text" name="first_name" required placeholder="Bob">
      <label for="last_name">Last Name</label>
        <input type="text" name="last_name" required placeholder="Ross">


      <label for="name">Phone Number</label>
        <input type="text" name="phone" required pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" placeholder="123-456-7890">
      <label for="name">Street</label>
        <input type="text" name="address" required placeholder="123 Sesame Street">
      <label for="city">City </label>
        <input id="cityname" type="text" name="city" required placeholder="Irvine" onchange="zipPredict()">
      <label for="state">State</label>
        <input id="statename" type="text" name="state" pattern="[A-Z]{2}" required maxlength="2" placeholder="CA" onchange="zipPredict()">
      <label for="zip">Zip &nbsp&nbsp&nbsp Suggested: <span id="zippie"></label>
        <input type="text" name="zip" pattern="[0-9]{5}" maxlength="5" required placeholder="12345">

      <label for="ship">Shipping Speed</label>
        <select type="text" name="shipping" id="shipping">
          <option value="Overnight Shipping">Overnight Shipping</option>
          <option value="2day Expedited">2-Days Expedited</option>
          <option value="6-Day Ground">6-Days Ground</option>
        </select>

      <h2>Credit Card</h2>

      <label for="card-num">Credit Card Number</label>
        <input type="text" name="cardnum" required pattern="[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}" placeholder="1234-5678-9123-4567">
      <label for="card-num">Expire</label>
        <input type="text" name="expire" required placeholder="4/21">
      <label for="card-num">CVV</label>
        <input type="text" name="security" required maxlength="3" placeholder="123">

      <input type="submit" value="Send" style="padding: 20px; font-size:20px; color:white; background-color: #aaa;">

    </form>
  </div>



<% 
    while ( products.next()) { %>
    <div class="writeup">
    <h4><u>Description</u></h4>
    <p id="writing"><%= products.getString("descrip")%></p>
    <h4><u>Size</u></h4>
    <p id="size"><%= products.getString("size")%></p>
    </div>
<% } %>



  <?php
  $zip = $_REQUEST['zip'];
  $result = $conn->query("SELECT * FROM items WHERE id='$zip'");
  while ($row = $result->fetch(PDO::FETCH_ASSOC)) 
    {

      echo '<div class="writeup">';
      echo '<h4><u>Description</u></h4>';
      echo '<p id="writing">'.$row['descrip'] .'</p>';
      echo '<h4><u>Size</u></h4>';
      echo '<p id="size">'.$row['size'] .'</p>';
      echo '</div>';
    }

  $conn = null; 
  ?>

  </body>
</html>
