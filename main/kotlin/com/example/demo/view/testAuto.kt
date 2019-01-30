package com.example.demo.view
import org.junit.Assert
import org.junit.Test
import org.testfx.api.FxToolkit
import org.junit.Assert.*
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.scene.Node
import javafx.scene.control.*
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.BackgroundSize
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import javafx.scene.text.Font
import tornadofx.*
import tornadofx.controlsfx.statusbar
import tornadofx.controlsfx.right
import java.io.FileInputStream
import javax.json.JsonObject
import org.junit.Assert.*

class testAuto : View("My View",Button("op")) {

    var js="""
        [
        {"name":"abdo"
        "password":"796990"



        ]
    """.trimIndent()
private var nmtxt: TextField by singleAssign()
    var pstxt:PasswordField by singleAssign()
var model =personModel()
    override val root = form {
statusbar{

        button("Abou us") {
            background = Background(BackgroundFill(Color.CHOCOLATE, CornerRadii(2.0), Insets(5.0)))
        }



    button("Sales"){
        background=Background(BackgroundFill(Color.CHOCOLATE, CornerRadii(2.0), Insets(5.0)))

    }



}
        separator(Orientation.VERTICAL) {

        }
        statusbar {

            button("jjhkh")
        }


        fieldset {
            this.style{
                backgroundColor+=Color.CADETBLUE
                font= Font.loadFont(FileInputStream("F:\\Fonts\\LHANDW.TTF"),20.0)

            }
            field("username") {
          textfield(model.name) {
              nmtxt=this
          }.required()
            }
            field("password") {
              passwordfield(model.password) {
pstxt=this
                }.required()
            }
            button("Log in")
            {
                useMaxSize = true
                style {
                    backgroundColor += Color.GREEN

                }
                action{
                    model.commit()

                }
            }
        }
    }
    private var context=ValidationContext()


    var nmval=context.addValidator(nmtxt,nmtxt.textProperty()){
        if(it!!.length<5) error("short name , please check name") else null
    }
var psval=context.addValidator(pstxt,pstxt.textProperty()){
    if(it!!.contains("2012")  ) null else {error("invalid password ,plz check password")}
if (it!!.contains("2012")) success("great") else warning("oops")

}







}

class person{
    var name=SimpleStringProperty()
    var nmProperty by name
    var password =SimpleStringProperty()
    var pass by password
}

class personModel:  ItemViewModel<person>(){

    var name=bind(person::nmProperty)
    var password=bind(person::pass)
}
