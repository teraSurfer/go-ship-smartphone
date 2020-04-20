package com.example.goship.ui.orders

data class OrdersFake (val id: Long, val u_email: String, val price: String, val p_date: String) {}

//Singleton declaration of the data top populate the spinner and tables
object DataManager {
    val customerOrders = HashMap<Long, OrdersFake>()

    init {
        initializeCustomerOrders()
    }

    private fun initializeCustomerOrders() {
        var order =
            OrdersFake(5392170, "me@yahoo.com", "185.32", "04/05/2020")     //create the city
        customerOrders.set(order.id, order)                        //Add to the HashMap

        order = OrdersFake(5391811, "we@hotmail.com", "185.32", "04/05/2020")
        customerOrders.set(order.id, order)

        order =
            OrdersFake(u_email = "me@yahoo.com", id = 5391952, price =  "185.32", p_date = "04/16/2020")
        customerOrders.set(order.id, order)

        order = OrdersFake(5368363, "you@gmail.com", "185.32", "04/16/2020")
        customerOrders.set(order.id, order)

        order = OrdersFake(5393014, "me@yahoo.com","185.32", "04/20/2020")
        customerOrders.set(order.id, order)

        order = OrdersFake(5392955, "him@hotmail.com", "185.32","04/16/2020")
        customerOrders.set(order.id, order)

        order = OrdersFake(5393056, "you@gmail.com", "185.32", "04/20/2020")
        customerOrders.set(order.id, order)

        order = OrdersFake(4735017, "me@yahoo.com", "185.32", "04/18/2020")
        customerOrders.set(order.id, order)

        order = OrdersFake(5368518, "his@gmail.com", "185.32", "04/12/2020")
        customerOrders.set(order.id, order)

        order = OrdersFake(5368459, "me@hotmail.com", "185.32", "04/20/2020")
        customerOrders.set(order.id, order)
    }
}
//commits:
//  "Add navigation with safeArgs from Orders to Orders details"
//  "Add vendor and customer views in same recycler and add  API network functionality"

//{
//    "orders": [{
//    "O_Address": "Pune",
//    "Weight": 65,
//    "V_Email": "amit.vijapure@sjsu.edu",
//    "Origin": 411057,
//    "Destination": 431605,
//    "D_Mobile": 5554343453,
//    "D_Address": "Mumbai",
//    "O_Date": "2020-04-18 08:21:17.004299",
//    "Current_Status": "Accepted",
//    "O_Mobile": 4646432323,
//    "Price": 390,
//    "P_Date": "10/10/2019",
//    "ID": 1587198076923,
//    "U_Email": "amit.vijapure@sjsu.edu"
//}, {
//    "O_Address": "Delhi",
//    "Weight": 65,
//    "V_Email": "amit.vijapure@sjsu.edu",
//    "Origin": 431605,
//    "Destination": 431605,
//    "D_Mobile": 5554343453,
//    "D_Address": "Mumbai",
//    "O_Date": "2020-04-18 08:22:28.184184",
//    "Current_Status": "Accepted",
//    "O_Mobile": 4646432323,
//    "Price": 390,
//    "P_Date": "10/10/2019",
//    "ID": 1587198148109,
//    "U_Email": "amit.vijapure@sjsu.edu"
//}]
//}
//
//orders:
//get:
//summary: To get list of orders
//parameters:
//- in: query
//name: email
//required: true
//schema:
//type: object
//properties:
//    v_email:
//type: string
//u_email:
//type: string
//oneOf:
//- required: [u_email]
//- required: [v_email]
//
//description: Email of user or vendor
//
//
//responses:
//'200':
//description: Returns list of orders
//content:
//application/json:
//schema:
//type: array
//items:
//type: object
//properties:
//    id:
//type: integer
//u_email:
//type: string
//
//origin:
//type: integer
//destination:
//type: integer
//o_address:
//type: string
//d_address:
//type: string
//price:
//type: integer
//v_email:
//type: string
//v_name:
//type: string
//v_mobile:
//type: integer
//weight:
//type: integer
//o_mobile:
//type: integer
//d_mobile:
//type: integer
//o_date:
//type: string
//format: date-time
//p_date:
//type: string
//format: date
//status:
//type: string
//
//required:
//- id
//- origin
//- destination
//- o_address
//- d_address
//- price
//- v_email
//- v_name
//- v_mobile
//- weight
//- o_mobile
//- d_mobile
//- o_date
//- p_date
//- status