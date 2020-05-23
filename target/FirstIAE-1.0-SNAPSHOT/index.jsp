<%-- 
    Document   : index
    Created on : May 21, 2020, 2:48:47 PM
    Author     : Kati
--%>

<%@page import="java.sql.*"%>
<%Class.forName("com.mysql.cj.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

</head>
<div id="poll">
<link href="css/store.css" rel="stylesheet" type="text/css">
<link href="css/index.css" rel="stylesheet" type="text/css">
<body>

	<ul>
	  <li><a href="about.jsp">About</a></li>
	  <li><a class="active" href="storePage">Store</a></li>
	  <li><a>Kati Tran 33574122</a></li>
          <li><a>Jae Yoon Oh 41812159</a></li>
	</ul>

    <div class="about-section">
	  <h1>Kais"R"Us</h1>
	</div>
    

	<div class="main">

	<!-- Portfolio Gallery Grid -->
		<div class="row">

			<% while ( products.next()) { %>
				<div class="column">
				<div class="content" id="<%= products.getString("id")%>" onclick="sendData('<%= products.getString("id")%>')">
				<img src="<%= products.getString("picture")%>" style="width:100%">
                                <h4><%= products.getString("name")%></h4>
				<p><b>$<%= products.getInt("price")%></b></p>
				<div class="texts">
				<p><b>Type: </b><%= products.getString("type")%>&nbsp&nbsp&nbsp<b>Color: </b><%= products.getString("color")%></p>
				</div>
				</div>
				</div>
                        <% } %>

		<script type="text/javascript">
			function sendData(id_name) {
				var xhr= new XMLHttpRequest(); 
				xhr.onreadystatechange= function () {
					if (xhr.readyState== 4 && xhr.status== 200){
						//document.getElementById("poll").innerHTML=this.responseText;
						location.href = "productDetails?zip=" + id_name;
					}
				} 
				  xhr.open("POST","helloWorld.do?",true);
				  xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded"); 
                                  console.log(id_name);
				  xhr.send("zip=" +id_name);
			}

		    function replaceIMG(elem){
		      document.getElementById("image").src = elem;
		    }

		function zipPredict(str) {
			var ci = document.getElementById("cityname").value;
			var str = document.getElementById("statename").value;

		  if (str.length == 0 && ci.length == 0) { 
		    document.getElementById("zippie").innerHTML = "";
		    return;
		  } else {
		    var xmlhttp = new XMLHttpRequest();
		    xmlhttp.onreadystatechange = function() {
		      if (this.readyState == 4 && this.status == 200) {
		        document.getElementById("zippie").innerHTML = this.responseText;
		      }
		    };
		    xmlhttp.open("GET", "readzip.php?state=" + str +"&city=" + ci, true);
		    xmlhttp.send();
		  }
		}

		</script>
	
	</div>

	<!-- END GRID -->
	</div>
</div>


</body>
</html>