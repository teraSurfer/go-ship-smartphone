package com.example.goship.ui.orders

data class CustomerOrders (val orderId: Int, val u_email: String, val status: String) {
//    override fun toString(): String {
//        return cityName
//    }
}

//Singleton declaration of the data top populate the spinner and tables
object DataManager {
    val customerOrders = HashMap<Int, CustomerOrders>()

    init {
        initializeCustomerOrders()
    }

    private fun initializeCustomerOrders() {
        var order =
            CustomerOrders(5392170, "me@yahoo.com", "closed")     //create the city
        customerOrders.set(order.orderId, order)                        //Add to the HashMap

        order = CustomerOrders(5391811, "me@yahoo.com", "in transit")
        customerOrders.set(order.orderId, order)

        order =
            CustomerOrders(u_email = "me@yahoo.com", orderId = 5391952, status= "closed")
        customerOrders.set(order.orderId, order)

        order = CustomerOrders(5368363, "me@yahoo.com", "open")
        customerOrders.set(order.orderId, order)

        order = CustomerOrders(5393014, "me@yahoo.com","delayed")
        customerOrders.set(order.orderId, order)

        order = CustomerOrders(5392955, "me@yahoo.com", "closed")
        customerOrders.set(order.orderId, order)

        order = CustomerOrders(5393056, "me@yahoo.com", "open")
        customerOrders.set(order.orderId, order)

        order = CustomerOrders(4735017, "me@yahoo.com", "in transit")
        customerOrders.set(order.orderId, order)

        order = CustomerOrders(5368518, "Los Gatos", "closed")
        customerOrders.set(order.orderId, order)

        order = CustomerOrders(5368459, "Los Banos", "in transit")
        customerOrders.set(order.orderId, order)
    }


}