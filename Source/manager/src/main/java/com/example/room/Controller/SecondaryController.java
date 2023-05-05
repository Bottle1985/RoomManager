package com.example.room.Controller;

import java.io.IOException;

import com.example.room.App;

import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}