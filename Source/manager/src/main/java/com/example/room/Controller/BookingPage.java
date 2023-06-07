package com.example.room.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.room.App;

public class BookingPage {
    @FXML
    private Button btnExit;

    @FXML
    private void returnBack(ActionEvent event) throws IOException {
        App.changeScreen(event, "secondary.fxml", 650, 500, "Room Manager");
    }

    @FXML
    private void switchToBookRoom(ActionEvent event) throws IOException {
        App.changeScreen(event, "bookroom.fxml", 900, 550, "Booking Room");
    }
    
    @FXML
    private void switchToCancelBook(ActionEvent event) throws IOException {
        App.changeScreen(event, "cancelbook.fxml", 900, 400, "Cancel Booking");
    }

    @FXML
    private void switchToCheckInRoom(ActionEvent event) throws IOException {
        App.changeScreen(event, "checkin.fxml", 900, 400, "Check In Room");
    }

    @FXML
    private void switchToCheckOutRoom(ActionEvent event) throws IOException {
        App.changeScreen(event, "checkout.fxml", 900, 400, "Check In Room");
    }

    @FXML
    public void Exit(){
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

}

