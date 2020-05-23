<%-- 
    Document   : about
    Created on : May 21, 2020, 5:39:51 PM
    Author     : Kati
--%>

<!DOCTYPE html>
<html>
  <head>
    <title>About Us</title>
    <link href="css/about.css" rel="stylesheet" type="text/css">
    <link href="css/index.css" rel="stylesheet" type="text/css">
  </head>
  <body>

	<ul>
	  <li><a class="active" href="about.jsp">About</a></li>
	  <li><a href="storePage">Store</a></li>
	  <li><a>Kati Tran 33574122</a></li>
          <li><a>Jae Yoon Oh 41812159</a></li>
	</ul>

    <div class="about-section">
	  <h1>About Kais"R"Us</h1>
	  <p>A dog toy store.</p>
	  <p>All toys have been tested using expert science and deduction abilities to ensure everything sold meets the upmost quality. They have been approved by numerous customers, and we hope to achieve our goal of having something for everyone for ultimate customer satisfaction.</p>
	</div>

	<h2 style="text-align:center">Bark Team</h2>
	<div class="row">

	  <div class="column">
	    <div class="card">
	      <img src="images/smug.png" alt="Kati" style="width:100%">
	      <div class="container">
	        <h2>Kati Tran</h2>
	        <p class="title">Janitor</p>
	        <p>UCInetID: katit1</p>
	        <p>StudentID: 33574122</p>
	        <p>katit1@uci.edu</p>
	        <p><button class="button">Contact (Sorry I don't like photos of me)</button></p>
	      </div>
	    </div>
	  </div>

	  <div class="column">
	    <div class="card">
	      <img src="images/kaiser.jpg" alt="Kaiser" style="width:100%">
	      <div class="container">
	        <h2>Kaiser</h2>
	        <p class="title">CEO and Founder</p>
	        <p>Entrepreneur. Fluffy. Sheds too much.</p>
	        <p>Likes new things. Materialistic.</p>
	        <p>A good boy.</p>
	        <p><button class="button" onclick="treats()">Send Treats</button></p>
	      </div>
	    </div>
	  </div>

	  <div class="column">
	    <div class="card">
	      <img src="images/smug.png" alt="Leylah" style="width:100%">
	      <div class="container">
	        <h2>Jae Yoon Oh</h2>
	        <p class="title">Co-Founder</p>
	        <p>UCInetID: jaeyo</p>
	        <p>StudentID: 41812159</p>
	        <p>jaeyo@uci.edu</p>
	        <p><button class="button" onclick="treats()">Send Treats</button></p>
	      </div>
	    </div>
	  </div>
	  <script>
	  	function treats(){
	  		alert("Treat sent!");
	  	}
	  </script>
	</div>

   <h2 style="text-align:center">Sources</h2>
   <div class="bottom-bar">
   <p>Top two rows of photos on store were found on https://barkshop.com/collections/plush-dog-toys</p>
   <p>Other photos from https://www.petco.com/shop/en/petcostore</p>
   <p>Pattern to parse phone number from https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/tel and others were just inspired by the formatting</p>
   <p>Menu bar taken from https://www.w3schools.com/css/css_navbar_horizontal.asp I just changed colors and position but this is definitely not mine.</p>
   <p>Store CSS design built on and modified by https://www.w3schools.com/howto/howto_js_portfolio_filter.asp . Taken for the clean grid spacing but I modified it for to meet the clicking requirements and fun hover/dropdown aesthetics.</p>
   <p>Team page CSS built from https://www.w3schools.com/howto/howto_css_about_page.asp I really liked the neat cards and design so I wanted to include it to look professional.</p>

   <h4 style="text-align:center">Disclaimer</h4>
   	<p>Disclaimer: One size does not fit all. Be sure to decide toys that are right for breed, size, and strength. Stay safe and have fun!</p>
   </div> 

  </body>
</html>