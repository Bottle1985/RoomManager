package com.example.room.Controller;

import java.io.IOException;

import com.example.room.App;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class PrimaryController {
    @FXML
    private Text actiontarget;

    @FXML
    private void handleSubmitButtonAction() throws IOException {
        actiontarget.setText("Sign in button pressed");
        App.setRoot("secondary");

    }
}
