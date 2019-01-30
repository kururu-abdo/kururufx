package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.Scene
import javafx.scene.paint.Color
import tornadofx.*
import javax.json.JsonObject
import javax.swing.text.html.ListView

class testModel : View("My View") {
    init {
importStylesheet("/ex.css")
    }
    var cont=CustomerController()
    var ls:javafx.scene.control.ListView<cust>?=null
    var ts=TaskStatus()
override val root=vbox{
    button("load custmers")
    {
        setOnAction {
            refresh()
        }
    }
        listview<cust> {
            ls=this
            prefHeight=150.0
            style{
                backgroundColor+= Color.AZURE
            }
        }

        vbox(4.0){
            progressbar(ts.progress)
            label(ts.message)
            visibleWhen { ts.running }
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
        api.baseURI = "https://api.github.com/users/hadley/orgs"
    }
    fun loadCustomers():ObservableList<cust>
    {
        return api.get("login").list().toModel<cust>().toList().observable()
    }



}
class cust:JsonModel{
var nameProperty= FXCollections.observableArrayList<names>()
    override fun updateModel(json: JsonObject) {
        with(json)
        {
nameProperty.setAll(getJsonArray("login").toModel())
        }
    }

    override fun toJSON(json: JsonBuilder) {

        with(json){
            add("nameProperty", nameProperty.toJSON())
        }
    }



}

class names : JsonModel {


    var nameProperty=SimpleStringProperty()
    var name by nameProperty

    override fun updateModel(json: JsonObject) {
        with(json) {
            name = string("name")
        }
    }

    override fun toJSON(json: JsonBuilder) {
        with(json) {
            add("name", name)
        }
    }
}