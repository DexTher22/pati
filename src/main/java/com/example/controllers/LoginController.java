package com.example.controllers;

import com.example.App;
import com.example.models.Auth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

public class LoginController {

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void onClickLoginButton(ActionEvent event) {
        if(Auth.isValid(usernameField.getText(), passwordField.getText())) {
            App.setRoot("mainScene");
            
        }else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Hibás adat!");
            alert.setContentText("A felhasználónév vagy a jelszó érvénytelen!");
            alert.setHeaderText("Azonosítási hiba!");
            alert.initOwner(App._stage);
            alert.show();
        }
    }

    



    

}
