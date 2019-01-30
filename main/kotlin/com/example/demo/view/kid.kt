package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Alert
import tornadofx.*
import tornadofx.getValue
import tornadofx.setValue

object CustomerListRequest : FXEvent(EventBus.RunOn.BackgroundThread)
class kid : View("My View") {
    override val root = vbox {
        button("Load customers").action {
            fire(CustomerListRequest)
        }


        tableview<Customer> {
            column("Name", Customer::nameProperty).prefWidth(50)
            subscribe<CustomerListEvent> { event ->
                items.setAll(event.customers)
            }
        }
    }
    init {
        subscribe<CustomerListRequest> {
            fun loadCustomers(): List<Customer> = listOf(Customer("Ali"), Customer("Mohammed"), Customer("Kaka"))
            val customers = loadCustomers()
            fire(CustomerListEvent(customers))

        }
    }
}




class Customer(var name:String) {
    val nameProperty = SimpleStringProperty(name)
}

class CustomerListEvent(val customers: List<Customer>) : FXEvent()


object MyEvent : FXEvent()
class MyView : View() {
    override val root = stackpane {
        paddingAll = 100
        button("Fire!").action {
            fire(MyEvent)
        }
    }
            init {
                subscribe<MyEvent>(times = 2) {
                    alert(Alert.AlertType.INFORMATION, "Event received!", "This message should only appear twice.")
                }
            }
}