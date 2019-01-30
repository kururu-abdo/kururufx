package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import tornadofx.*
import javax.json.JsonObject
import javax.swing.text.html.ListView

class testModel : View("My View") {
    var cont=CustomerController()
    var ls:javafx.scene.control.ListView<cust>?=null
    var ts=TaskStatus()
override val root=vbox{
    button("load custmers")
    {
        setOnAction {
         refresh()
        }

        listview<cust> {
            ls=this
        }

        vbox(4.0){
            progressbar(ts.progress)
            label(ts.message)
            visibleWhen { ts.running }
        }
    }
}

    fun refresh(){
        runAsync(ts) {
            updateProgress(.4,1.0)
            updateMessage("load customers")
            cont.loadCustomers()
        }ui{
            ls?.items=cont.loadCustomers()
        }
    }
}

class CustomerController : Controller() {
    val api: Rest by inject()
    init {
        api.baseURI = "https://api.github.com/"
    }
    fun loadCustomers():ObservableList<cust>
    {
        return api.get("user").list().toModel<cust>().observable()
    }



}
class cust:JsonModel{
var nameProperty= SimpleStringProperty()
var name by nameProperty

    override fun updateModel(json: JsonObject) {
        with(json)
        {
            name=string("name")
        }
    }

    override fun toJSON(json: JsonBuilder) {

        with(json){
            add("name", name)
        }
    }



}

