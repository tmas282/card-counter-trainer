package com.tmas282.cardcountertrainer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFxMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JavaFxMain.class.getResource("card-counter-ui.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 705, 468);
        stage.setTitle("Card Counter Trainer");
        stage.setScene(scene);
        Image icon = new Image(getClass().getResource("icon.png").toString());
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}