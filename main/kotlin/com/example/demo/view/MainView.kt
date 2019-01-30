package com.example.demo.view

import com.example.demo.app.Styles
import com.sun.javafx.scene.control.skin.TableViewSkin
import com.sun.javafx.scene.control.skin.TreeTableViewSkin
import de.jensd.fx.fontawesome.AwesomeIcon
import de.jensd.fx.glyphs.GlyphsBuilder
import de.jensd.fx.glyphs.GlyphsStack
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconName
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconName.*
import javafx.application.Platform
import javafx.beans.Observable
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.value.ObservableValue
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.input.KeyCode
import javafx.scene.layout.Background
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import javafx.scene.shape.Circle
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.scene.text.Text
import javafx.stage.FileChooser
import javafx.util.Duration
import org.controlsfx.control.Notifications
import org.controlsfx.control.PopOver
import tornadofx.*
import tornadofx.FX.Companion.icon
import tornadofx.controlsfx.*
import java.io.FileInputStream
import java.time.LocalDate
import java.util.*
import javax.swing.Icon

data class memo(var name: String,var city: String)
class cm : View() {
    var v=GlyphsStack.create().add(GlyphsBuilder.create(FontAwesomeIcon::class.java)
            .icon(FontAwesomeIconName.WIFI)
            .build()
    )
    var v2=GlyphsStack.create().add(GlyphsBuilder.create(FontAwesomeIcon::class.java)
            .icon(FontAwesomeIconName.APPLE)
            .build()
    )

var memes=listOf(memo("Aadeel fadoul","Maiami"), memo("kathrine","bermongham"),memo("marcos","sys")).observable()
    override val root=squeezebox {
        multiselect=false
        fold("persons", closeable = false) {
tableview(memes) {
    smartResize()
    this.resizeColumnsToFitContent(this.columns)
    column("name",memo::name)
    column("city",memo::city).prefWidth(100.0)
    rowExpander {
        this.expanded=true

        this.style{
            backgroundColor+=Color.DARKGOLDENROD
        }
        tableview (memes){
            column("city",memo::city).prefWidth(100.0)

        }
    }
}

        }
        fold("link") {

            hyperlink("Doc") {
                setOnAction {
                    hostServices.showDocument("www.youtube.com")
                }
            }
        }
    }


}




var vx=GlyphsStack.create().add(GlyphsBuilder.create(FontAwesomeIcon::class.java)
        .icon(FontAwesomeIconName.TWITTER)
        .build()
)
var fbicon=GlyphsStack.create().add(GlyphsBuilder.create(FontAwesomeIcon::class.java)
.icon(FontAwesomeIconName.FACEBOOK)
.build()
)
var b=GlyphsStack.create().add(GlyphsBuilder.create(FontAwesomeIcon::class.java)
        .icon(FontAwesomeIconName.YOUTUBE)
        .size("45")
        .build()
)
class file:View("file chooser"){
    var txtf:TextField by singleAssign()
    val ef=arrayOf(FileChooser.ExtensionFilter("document files(*.png,*.txt)","*.png","*.txt" ))
    override val root =hbox{
button("open file"){
    action {
        var op= chooseFile("choose one",ef,FileChooserMode.Single)
        if(op.isNotEmpty()){
            txtf.text="${op.first().name}"
        }
    }
}
txtf=textfield {
    isEditable = false
}

    }
}
class slide:View("slides"){
    override val root=slideshow {


        slide(cm::class,ViewTransition.NewsFlash(.5.seconds))
        slide(choice::class,ViewTransition.Metro(.3.seconds))
        slide(file::class,ViewTransition.Flip(.5.seconds))
        slide(cook::class,ViewTransition.Explode(.6.seconds))
    }
}

class choice: View("kururu") {
var per= listOf(person2("Adam","las vigas", listOf(54653,757687,979808090))).observable()
    init {
        icon= b
    }

    var ic = icons()
    override val root =hbox{

        listview<String> {
            items.add("Arsenal")
            items.add("Barcelona")


selectionModel.selectionMode=SelectionMode.MULTIPLE

            setOnDragDetected {
                var str=selectionModel.selectedItems

                alert(type=Alert.AlertType.INFORMATION, content = str.toString(),header="Hello" )
            }
        }



listSelectionView<String> {
sourceItems.addAll("Manhatten","berkamp","henry","Ropert pereies","roperto manchini","Samoel omtiti")

}
}



        }
data class person2(var name:String, var city:String,var phones:List<Int>?)

class combo:View("test combobox"){

    var obj= listOf(loc("southern kurdfan",listOf("kadugli", "Abu-jubeyha","talodi","daling")),loc("khartoum",listOf("khartoum","bahri","karrari"))).observable()

var stt= listOf(states.kh.name,states.gaz.name)

    override val root=vbox{
       combobox <states>{

       }

combobox (values = obj.map { it.state }.distinct().map { loc(it,null) }){

}

    }
}
data class loc(var state:String,var locs:List<String>?)

data class st(var name:String)

enum class states(name: String,loc:List<String>){
    kh("الخرطوم", listOf("hfgj","ghvchkvj")),gaz("الجزيرة", listOf("hfgj","ghvchkvj")),sin("سنار", listOf("hfgj","ghvchkvj")),bn("النيل الازرق", listOf("hfgj","ghvchkvj")),wn("النيل الابيض", listOf("hfgj","ghvchkvj")),kas("كسلا", listOf("hfgj","ghvchkvj"))
}



class cook:View("examples") {
var contr= Locale.getISOCountries().map { Locale("",it) }
    val glo=contr.mapEach { displayCountry }
    var sel=SimpleStringProperty(glo.first())

    var names = mutableListOf<String>("mark van bomel", "denis berkamp","عبدالرحيم حسن","زهراء علي")
    var country = SimpleStringProperty()
    var ic = icons()
    override val root = vbox {
        tabpane {
            tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
            tab("customer registeration") {
                form {
                    this.alignment=Pos.TOP_LEFT
                    fieldset("basic info", icon = ic.fbicon) {
                        hbox {
                            hboxConstraints {
                                HAND_ALT_RIGHT
                            }
                            field("first name") {
                                textfield {
                                    bindAutoCompletion(suggestions = names)


                                    popover() {
                                        style {
                                            backgroundColor += Color.CHOCOLATE
                                        }
                                        label("gffgigkj")
                                        {
                                            style {
                                                textFill = Color.CYAN
                                            }
                                        }
                                    }
                                    setOnMouseMoved {
                                        showPopover()
                                    }


                                }
                            }
                            field("last name") {
                                textfield {


                                }
                            }
                        }
                        field("birth date") { datepicker { value = LocalDate.now() } }
                        field("country") {
                            combobox(sel,glo){
makeAutocompletable()
                            }
                        }
                        field("city") {
                            textfield {
                                useMaxSize=false
                            }
                        }
                    }
                    fieldset("Aditional info", icon = ic.fb) {

                        field("company") {
                            textfield {
                                useMaxSize=false

                            }
                        }
                        field("trade registration") {
                            textfield {
                                useMaxSize=false

                            }
                        }
                    }
                    buttonbar {
                        ButtonBar.BUTTON_ORDER_MAC_OS

                        button("create user") {
                            action {
                                Notifications.create()
                                        .text("Congratulations!")
                                        .position(Pos.TOP_RIGHT)
                                        .hideAfter(Duration(5000.0))
                                        .graphic(ic.fb2)

                                        .show()

                            }
                        }
                        button("clear") {


                        }

                    }

                }
            }
            tab("sales") {
                menubar {
                    menu("products") { }

                    menu("prices") {}

                    menu("others") { }
                }
            }

            tab("News") {
                webview {
                    prefWidth = 470.0
                    engine.userAgent = userAgentStylesheet
                    engine.load("https://www.youtube.com/user/MrEdvinsyse/videos")
                }
            }
            tab("about us") {
                textarea {

                   style {
                        backgroundColor += Color.AQUA
                       font= Font.font("Comic Sans MS")
                    }
                        text = """    عبدالرحيم حسن كرورو قرو
                            |ولاية جنوب كردفان
                            |محلية قدير
                            |وحدة أم دحيليب الإدارية
                            |قرية أم دحيليب
                            |
                            |جامعة السودان للعلوم ة التكنولوجيا
                            |نظم المعلومات الإدارية
        """.trimMargin()

                        isEditable = false

                }
            }
        }


    }
}
