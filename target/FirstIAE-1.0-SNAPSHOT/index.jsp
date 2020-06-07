<%-- 
    Document   : index
    Created on : May 21, 2020, 2:48:47 PM
    Author     : Kati
--%>

<%@page import="com.entities.Item"%>
<%@page import="com.queries.ItemQueries"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project4.utils.*"%>
<%Class.forName("com.entities.Item");%>
<%Class.forName("com.queries.ItemQueries");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<html lang="en">
<head>
<meta charset="UTF-8">

</head>
<link href="css/store.css" rel="stylesheet" type="text/css">
<link href="css/index.css" rel="stylesheet" type="text/css">
<body>

	<ul>
            
	  <li><a href="about.jsp">About</a></li>
          <li><a href="checkout">Check Out</a></li>
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

			<% 
                        ArrayList<Item> products = ItemQueries.getAllItems();
                            
                        for (Item product : products) { %>
				<div class="column">
				<div class="content" id="<%= product.getId()%>" onclick="sendData('<%= product.getId()%>')">
				<img src="<%= product.getFirstPictureUrl()%>" style="width:100%">
                                <h4><%= product.getName()%></h4>
				<p><b>$<%= product.getPrice()%></b></p>
				<div class="texts">
				<p><b>Type: </b><%= product.getType()%>&nbsp&nbsp&nbsp<b>Color: </b><%= product.getColor()%></p>
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
						location.href = "rest/product/" + id_name;
					}
				} 
				  xhr.open("POST","helloWorld.do?",true);
				  xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded"); 
                                  console.log(id_name);
				  xhr.send("zip=" +id_name);
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
        </div>

</body>
</html>