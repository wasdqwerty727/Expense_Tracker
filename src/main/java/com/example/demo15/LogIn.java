package com.example.demo15;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogIn {
    @FXML
    private Button button;
    @FXML
    private TextField name;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrongInput;

    public void loginButtonClicked(ActionEvent event) throws SQLException {
        if (name.getText().isBlank() == false && password.getText().isBlank() == false){
            validLogin();
        } else {
            wrongInput.setText("Please enter username and password");
        }
    }
    public void validLogin() throws SQLException {
        JavaDataBase db = new JavaDataBase();
        Connection con = db.getConnection();
        String verifyLogin = "SELECT COUNT(1) FROM worker w WHERE name = '" + name.getText() + "' AND password = '" + password.getText() + "'";

        try{
            Statement stmt = con.createStatement();
            ResultSet queryResult = stmt.executeQuery(verifyLogin);
            while(queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    Main m = new Main();
                    m.changeScene("expense.fxml");
                } else {
                    wrongInput.setText("Invalid Logi. Please try again");
                }
            }
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void changeToSignUp() throws IOException {
        Main m = new Main();
        m.changeScene("signup.fxml");
    }
}
