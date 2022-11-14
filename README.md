# e-commerce Spring Boot Application
An API created using Spring Boot that has the following functionalities: </br>
* Add items to a cart
* List items in the cart
* Calculate total value of items in the cart after applying discounts and shipping costs.

The follwing conditions were used to calculate the total discount:
![Capture](https://user-images.githubusercontent.com/59875338/201630006-9967a0ee-ddaa-4f73-9593-daf67e75538f.PNG)



## List of API Mappings

### GET
1. Method Control for PRODUCT entity:
  * To get all products: GET /api/getAllProducts
  * To get a product by Id:GET /api/getProductById/{id}
2. Method Control for CART entity:
  * To get all the products in the cart: GET /api/cartItems
  * To get cart total: GET /api/cartTotal
  
### POST
  * To add a new product: POST /api/product/add
  * To add product to the cart: POST /api/cart/{productId}
  
### PUT
  * To update a product: PUT /api/product/{productId}

### DELETE
1. Method Control for PRODUCT entity:
  * To delete product by Id: DELETE /api/product/deleteById/{productId}
  * To delete all the products: DELETE /api/product/deleteAll
2. Method Control for CART entity:
  * To delete cart elements by product Id: DELETE /api/cart/deleteById/{productId}
  * To delete all the cart items: DELETE /api/deleteAllCartItem
  
## Dependencies used:
* Spring Web
* Spring Data JPA
* MS SQL Server Driver
* Lombok

<hr>

* Server port is running on 9990
* name of data source : myHyber

## Author
- [Shagufta Sheroz](https://github.com/shaguftashahroz1)
- [Rahul Kumar](https://github.com/rahulkumarcse102)
- [Khushi Pandey](https://github.com/Khushipandey)
