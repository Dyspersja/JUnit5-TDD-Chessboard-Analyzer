package com.dyspersja.view.welcomescreen;

import com.dyspersja.view.errorscreen.ErrorScreenProvider;
import com.dyspersja.view.gamescreen.GameScreenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeScreenController {

    @FXML // fx:id="heightTextField"
    private TextField heightTextField;
    @FXML // fx:id="startButton"
    private Button startButton;
    @FXML // fx:id="widthTextField"
    private TextField widthTextField;

    private final WelcomeScreenService service = new WelcomeScreenService();

    @FXML
    public void initialize() {
        service.initializeHeightTextField(heightTextField);
        service.initializeWidthTextField(widthTextField);
    }

    @FXML
    void start(ActionEvent event) {
        if (!validateUserInput()) {
            displayIncorrectInputWindow();
            return;
        }

        try {
            // load game board scene from FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/GameScreen.fxml"));
            Stage stage = (Stage) startButton.getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load());

            // pass user input to gameScreenController
            GameScreenController gameScreenController = fxmlLoader.getController();
            gameScreenController.initializeGameScreenController(
                    Integer.parseInt(heightTextField.getText()),
                    Integer.parseInt(widthTextField.getText())
            );

            stage.setScene(scene);
        } catch (IllegalStateException | IOException e) {
            ErrorScreenProvider.displayErrorWindow(e);
        }
    }

    private boolean validateUserInput() {
        return  service.validateHeightInput(heightTextField) &&
                service.validateWidthInput(widthTextField);
    }

    private void displayIncorrectInputWindow(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/IncorrectInputScreen.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Incorrect Input");
            stage.setResizable(false);

            stage.setScene(scene);
            stage.showAndWait();
        } catch (IllegalStateException | IOException ignored) {}
    }

}