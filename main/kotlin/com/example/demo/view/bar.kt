package com.example.demo.view

import tornadofx.*
import tornadofx.controlsfx.statusbar
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.scene.control.Button
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import tornadofx.*
import tornadofx.controlsfx.left
import tornadofx.controlsfx.right
import tornadofx.controlsfx.statusbar

class  StatusBarView : View("Status Bar View") {

    var lss= listOf(info("Ali","coarolin"),info("Micheal cohen","Reterdam")).observable()
    override val root = vbox {
        statusbar {

            button("1") {
                background = Background(BackgroundFill(Color.ORANGE, CornerRadii(2.0), Insets(4.0)))
            }
            separator(Orientation.VERTICAL) {

            }
            button("2") {
                background = Background(BackgroundFill(Color.ORANGE, CornerRadii(2.0), Insets(4.0)))
            }
        }
        listview(lss){
cellFormat {
    graphic=cache {
        form{
            fieldset {
                field("name : ${it.name}")

                field("city: ${it.City}")
            }
        }
    }
}
        }


    }
}


 class info(var name:String,var City:String)
