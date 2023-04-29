package com.store;

import com.store.util.Tools;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * The type Main.
 */
public class Main extends Application {

    /**
     * The constant fons.
     */
    public static Font fons =  new Font("Arial", 24);

    /**
     * Start.
     *
     * @param primaryStage the primary stage
     * @throws Exception the exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/store/ui/sample.fxml"));
        primaryStage.setTitle("Welcome to Adelaide!");
        root.setStyle(Tools.defaultStyle);

        primaryStage.setScene(new Scene(root, 600, 400));

        primaryStage.show();
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
