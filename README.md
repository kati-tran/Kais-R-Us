# Project3
 
TEAM:

Kati Tran 
-katit1
-33574122
-katit1@uci.edu

Jae Yoon Oh 
-jaeyo
-41812159
-jaeyo@uci.edu


KEY FILES:

- index.jsp: loads up the header page for the Store. Holds ajax function that sends
	the item ID to the product details page.

- storePage.java: servlet that dynamically loads up the store items taken from
	the SQL database. Also shows the last 5 things viewed when returned to.

- about.jsp: contains the information of each team member

- productDetails.java: returns the details of the item clicked and the option to add to cart.
	Stores item name in a session so that storePage.java can grab it and show it. When Add to Cart
	is clicked it triggers the servlet shoppingCart.java

- shoppingCart.java: stores all the items into a shopping cart session.

- checkout.java: When the Check Out tab is clicked, this servlet will show all the items in the shopping cart
	as well as their prices and the total price. It also has the order form that checks for bad information.
	Note: if the user is not yet ready to order, they can easily return to the store and add more items. Stores
	the total in a session.

- forwardOrder.java: When an order form is accepted, it is sent to this servlet that stores the user's order information
	into the SQL database. Then it forwards the page to orderConfirm.java

- orderConfirm.java: the order confirmation servlet. Shows all of the data and the items purchased. It also deletes the shopping
	cart session and also the total session so that the store can be used again with new information.


PROJECT 3 REQUIREMENTS:

1. index.jsp shows the html of the homepage without the items. storePage.java grabs from the database and dynamically
	renders them with index.jsp. storePage.java shows the last 5 items viewed by taking from a session that was 
	created in productDetails.java. storePage.java uses _include_ for the the index.jsp file.

2. productDetails.java gets the item id from storePage.java and grabs the appropriate data from the database. It then
	shows all of the items details onto the page. There is no order form, only the button Add to Cart that stores the item
	into a session with shoppingCart.java. 

3. checkout.java shows all the products in the shopping cart and the total price. It also contains an order form to fill out with
	 name, shipping address, phone number, credit card information, etc. Upon sending the data, forwardOrder.java submits the order 
	 for storage in the backend database. Then it forwards to the orderConfirm.java page using _forward_ to do so.