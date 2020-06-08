TEAM:

Kati Tran -katit1 -33574122 -katit1@uci.edu

Jae Yoon Oh -jaeyo -41812159 -jaeyo@uci.edu

Vivian Nguyen -nguyev12 -84955920 -nguyev12@uci.edu

Austin Helmholz -ahelmhol -10314895 -ahelmhol@uci.edu

PROJECT 4 REQUIREMENTS:

REQ 1: 

- Reimplemented index.jsp as product list page to dynamically load all items

REQ 2: 

5 rest services in our project.

1. CartResource.addToDo(Cart cart)
i.    POST
ii.   http://localhost:8080/FirstIAE-master/rest/cart
iii.  Sample response with one "Thanksgiving Leftovers" added to cart.
[{"color":"Brown","descrip":"For when those big sad eyes keep lookin at you for a little bite. Now distract them with THIS! (fool-proof. very trustable. 10/10 dogs recommend) Very crunchy and smells like home. Plush.","id":"item2","name":"Thanksgiving Leftovers","picture":"images/sandwich1.jpg","picture2":"images/sandwich2.jpg","price":10,"size":"5'W x 7.5'D x 5'H","type":"Plush"}]

2. CartResource.getCartItems()
i.    GET
ii.   http://localhost:8080/FirstIAE-master/rest/cart

[{"color":"Brown","descrip":"For when those big sad eyes keep lookin at you for a little bite. Now distract them with THIS! (fool-proof. very trustable. 10/10 dogs recommend) Very crunchy and smells like home. Plush.","id":"item2","name":"Thanksgiving Leftovers","picture":"images/sandwich1.jpg","picture2":"images/sandwich2.jpg","price":10,"size":"5'W x 7.5'D x 5'H","type":"Plush"}]

3. CartResource.getCustomerInfo()
i.    GET
ii.   http://localhost:8080/FirstIAE-master/rest/cart/receipt
{"ccn":"1234-1234-1234-1234","city":"Irvine","cvv":"123","exp":"4/21","firstName":"John","lastName":"Doe","phoneNum":"123-123-1234","shippingMethod":"Overnight Shipping","state":"CA","street":"123 starbucks street","zip":"92602"}

4. OrderResource.addConfirm(Order order)
i.    POST
ii. http://localhost:8080/FirstIAE-master/rest/confirm/

(`FIRST_NAME`, `LAST_NAME`, `PHONE_NUMBER`, `STREET`, `CITY`, `STATE`, `ZIP`, `SHIPPING_SPEED`, `CCN`, `EXP`, `CVV`) VALUES
('John', 'Doe', '123-123-1234', '123 starbucks street', 'irvine', 'CA', '92602', 'Overnight Shipping', '1234-1234-1234-1234', '4/21', '123');

5. ProductResource.getProductById(id)
i.    GET
ii. http://localhost:8080/FirstIAE-master/rest/product/item1
{"color":"Green","descrip":"This is actually a crocodile. A plushy friend for your friend that contains even a squeaky ball inside! So if the toy     were to be destroyed, there's still time to play. Plush.","id":"item1","name":"See ya later, Alligator","picture":"images/croc1.png","picture2":"images/croc2.png","price":10,"size":"3.75'W x 7.5'D x 4'H","type":"Plush"}

6. CartResource.deleteTodo()
i. DELETE
ii. http://localhost:8080/FirstIAE-master/rest/cart/delete

REQ 3:

Databases implemented with Database.java to interact with rest services mentioned above. 