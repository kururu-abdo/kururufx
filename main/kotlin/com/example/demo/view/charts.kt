package com.example.demo.view

import javafx.animation.Interpolator
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.PieChart
import javafx.scene.effect.DropShadow
import javafx.scene.input.KeyCode
import javafx.scene.paint.Color
import javafx.scene.shape.ArcType
import javafx.scene.shape.Rectangle
import javafx.scene.shape.SVGPath
import javafx.scene.shape.SVGPathBuilder
import javafx.util.Duration
import tornadofx.*
import tornadofx.controlsfx.bindAutoCompletion
import java.time.LocalDate

class charts : View("My View") {
    var nms= mutableListOf<String>()

var name=SimpleStringProperty()
    var age=SimpleStringProperty()
    override val root = vbox {

textfield (name){
    isEditable=false
}
        textfield(age) {
          isEditable=false
        }

        var s=SimpleStringProperty()
        var s2=SimpleObjectProperty<LocalDate>()
        button("edit information"){
            action{

                dialog {
                    form{
                        fieldset("information") {
                            field("name") { textfield(s) {
bindAutoCompletion(suggestions = nms.distinct())
                                setOnKeyPressed {
                                    if(it.code==KeyCode.ENTER)
                                        nms.add(this@textfield.text.trim())
                                }
                            } }
                        }
                        field ("age"){datepicker(s2) {

                        }
                        }
                    }
                    buttonbar {
                        button("submit").setOnAction {
                            name.value=s.value.toString()
                            age.value=s2.value.toString()
                            close()
                        }
                    }
                }
            }
        }

}









private fun autoCompletions():Collection<String>{
    return nms
}



}
