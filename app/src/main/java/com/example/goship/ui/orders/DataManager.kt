package com.example.goship.ui.orders

data class Orders (val orderId: Int, val u_email: String, val price: String, val p_date: String) {
//    override fun toString(): String {
//        return cityName
//    }
}

//Singleton declaration of the data top populate the spinner and tables
object DataManager {
    val customerOrders = HashMap<Int, Orders>()

    init {
        initializeCustomerOrders()
    }

    private fun initializeCustomerOrders() {
        var order =
            Orders(5392170, "me@yahoo.com", "185.32", "04/05/2020")     //create the city
        customerOrders.set(order.orderId, order)                        //Add to the HashMap

        order = Orders(5391811, "we@hotmail.com", "185.32", "04/05/2020")
        customerOrders.set(order.orderId, order)

        order =
            Orders(u_email = "me@yahoo.com", orderId = 5391952, price =  "185.32", p_date = "04/16/2020")
        customerOrders.set(order.orderId, order)

        order = Orders(5368363, "you@gmail.com", "185.32", "04/16/2020")
        customerOrders.set(order.orderId, order)

        order = Orders(5393014, "me@yahoo.com","185.32", "04/20/2020")
        customerOrders.set(order.orderId, order)

        order = Orders(5392955, "him@hotmail.com", "185.32","04/16/2020")
        customerOrders.set(order.orderId, order)

        order = Orders(5393056, "you@gmail.com", "185.32", "04/20/2020")
        customerOrders.set(order.orderId, order)

        order = Orders(4735017, "me@yahoo.com", "185.32", "04/18/2020")
        customerOrders.set(order.orderId, order)

        order = Orders(5368518, "his@gmail.com", "185.32", "04/12/2020")
        customerOrders.set(order.orderId, order)

        order = Orders(5368459, "me@hotmail.com", "185.32", "04/20/2020")
        customerOrders.set(order.orderId, order)
    }


}