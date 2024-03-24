package com.dyspersja;

import com.dyspersja.view.errorscreen.ErrorScreenProvider;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationLauncher extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/WelcomeScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Chessboard Analyzer");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IllegalStateException | IOException e) {
            ErrorScreenProvider.displayErrorWindow(e);
        }
    }

    public void launchApplication() {
        launch();
    }
}
