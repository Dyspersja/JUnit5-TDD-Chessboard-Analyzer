package com.dyspersja.view.welcomescreen;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class WelcomeScreenService {

    public boolean validateHeightInput(TextField heightTextField) {
        return validateTextFieldInput(heightTextField, 5, 40);
    }

    public boolean validateWidthInput(TextField widthTextField) {
        return validateTextFieldInput(widthTextField, 5, 70);
    }

    public void initializeHeightTextField(TextField heightTextField) {
        heightTextField.setTextFormatter(getNumberTextFormatter());
        heightTextField.setText("12");
    }

    public void initializeWidthTextField(TextField widthTextField) {
        widthTextField.setTextFormatter(getNumberTextFormatter());
        widthTextField.setText("10");
    }

    private TextFormatter<?> getNumberTextFormatter() {
        return new TextFormatter<>(newText ->
                newText.getControlNewText().matches("[0-9]{0,2}")
                        ? newText
                        : null
        );
    }

    private boolean validateTextFieldInput(TextField textField, int min, int max) {
        try {
            int number = Integer.parseInt(textField.getText());
            return number >= min && number <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
