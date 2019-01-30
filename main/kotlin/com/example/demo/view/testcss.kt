package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import javafx.scene.control.ComboBox
import javafx.scene.control.SelectionMode
import javafx.scene.control.SelectionModel
import tornadofx.*
import java.io.FileInputStream

class testcss : View("test css") {
    var ic=icons()
    init {

        icon=ic.googleIcon
    }
    var comb1:ComboBox<String> by singleAssign()
    var loc2 = listOf(stat("khartoum", listOf("umbada", "bahri", "jabel awliaa")), stat("nahr al-neel", listOf("atbara"))).observable()
    var ct = loc2.map { it.name.trim() }
    var xc: ObservableList<String>? = listOf("choose city").observable()
    var str:String?="khartoum"
    var l = SimpleStringProperty()
    var s = SimpleStringProperty(ct.first())
    override val root = vbox {
       comb1= combobox(s, ct) {
            makeAutocompletable()
selectionModel.selectedItemProperty().onChange {
    str = selectionModel.selectedItem!!.toString()
}
            print(locss(str!!))
println(str)




        }





        combobox(values = xc) {

            makeAutocompletable()

comb1.selectionModel.selectedItemProperty().onChange {
   items=locss(str!!)
}



        }

    }

    fun locss(s: String):ObservableList<String>? {
        xc = when (s) {
            "khartoum"-> listOf("bahri", "kassala", "umbad").observable()
            "nahr al-neel"-> listOf("fifi", "hyigoi", "gggooiho").observable()
            else -> listOf("konakre","melborne").observable()
        }
return xc?.observable()
    }
}
    data class stat(var name:String, var local:List<String>)

