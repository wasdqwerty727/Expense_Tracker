package com.example.demo15;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUp {
    @FXML
    private Button submitButton;
    @FXML
    private TextField email;
    @FXML
    private TextField name;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrongInput;
    public void getData(ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        System.out.println(name.getText());
        System.out.println(email.getText());
        System.out.println(password.getText());
        JavaDataBase.writeToDatabase(name.getText(), email.getText(), password.getText());
        wrongInput.setText("Succesfully created");
        m.changeScene("login.fxml");
    }
    public void changeToLogIn() throws IOException {
        Main m = new Main();
        m.changeScene("login.fxml");
    }
}
