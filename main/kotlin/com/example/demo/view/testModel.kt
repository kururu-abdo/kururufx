package com.example.demo.view
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.ProgressIndicator
import tornadofx.*
import tornadofx.getValue
import tornadofx.setValue

class testModel : View("login"){
    var usr=user()
    var model=userModel(usr)
    var g =githup()
    override val root=form{

fieldset {
    field("name") { textfield (model.name){  } }
    field("password") {passwordfield (model.pass){  }  }

    button("login") {
useMaxSize=true
        action {
            login()
        }
    }
}

    }
fun Button.login(){
if(model.commit()){
    graphic= ProgressIndicator()

    runAsync {
        g.login(model.use)

    }ui{sucess->
        graphic=null

        if (sucess)
        alert(Alert.AlertType.INFORMATION,content = "sucess",header = "success")
else
        alert(Alert.AlertType.INFORMATION,content = "faile",header = "failed")

    }
}
}

}

class user {
    val passProperty = SimpleStringProperty()
    var pass by passProperty

    val nameProperty = SimpleStringProperty()
    var name by nameProperty
}
 class userModel(var use:user):ViewModel(){
     var name =bind{use.nameProperty}
var pass=bind{use.passProperty}

 }


class githup:Controller(){
    val api:Rest by inject()
init {
    api.baseURI="https://api.github.com"
}
    fun login(us:user):Boolean{

        api.setBasicAuth(us.nameProperty.value, us.passProperty.value)

        return api.get("user").consume().ok()
    }
}