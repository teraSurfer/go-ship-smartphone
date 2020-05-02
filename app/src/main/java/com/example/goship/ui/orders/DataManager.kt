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


/************JSOP Example*********/
//https://api.cmpe282.terasurfer.com/orders?v_email=amit.vijapure@sjsu.edu
//"v_mobile": 5034343434,
//"o_address": "Pune",
//"weight": 65,
//"v_email": "amit.vijapure@sjsu.edu",
//"origin": 411057,
//"destination": 411057,
//"d_mobile": 5554343453,
//"d_address": "Banglore",
//"o_date": "2020-04-19 19:06:21.734307",
//"current_status": "Accepted",
//"o_mobile": 4646432323,
//"v_name": "Amit",
//"price": 390,
//"p_date": "10/10/2019",
//"id": 1587323181637,
//"u_email": "amit.vijapure@sjsu.edu"



