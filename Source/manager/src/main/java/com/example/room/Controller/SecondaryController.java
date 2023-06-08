package com.example.room.Controller;

import java.io.IOException;

import com.example.room.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("payment");
    }

    @FXML
    private void switchroomManagementDetail(ActionEvent event) throws IOException {
        App.changeScreen(event, "roomManagementDetail.fxml", 900, 550, "Room");
    }

    @FXML
    private void switchToBookingPage(ActionEvent event) throws IOException {
        App.changeScreen(event, "bookingpage.fxml", 650, 500, "Booking");
    }
}