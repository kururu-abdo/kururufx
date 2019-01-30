
package com.example.demo.view;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.ListSelectionView;

import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root=new VBox();
        ListSelectionView lsv=new ListSelectionView();
        lsv.setSourceItems(FXCollections.observableArrayList("sudan","republic democratic of kongo","kenta","tchad"));

        root.getChildren().addAll(lsv);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
