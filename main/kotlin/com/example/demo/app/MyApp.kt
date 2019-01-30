package com.example.demo.app

import com.example.demo.view.*
import javafx.geometry.Orientation
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.*
import java.io.FileInputStream
import com.example.demo.view.*
class MyApp: App(kid::class, Styles::class){



    override fun start(stage: Stage) {

        stage.icons+= Image(FileInputStream("F:///logo.jpg"))
        stage.height=500.0
        stage.width=700.0
        stage.isResizable=true
        stage.separator(Orientation.HORIZONTAL)
        stage.isResizable=true
        super.start(stage)

    }



}