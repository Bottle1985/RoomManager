package com.example.room.Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.example.room.App;

public class RoomController {
    @FXML
    private void switchToRoomManagementDetail(ActionEvent event) throws IOException {
        App.changeScreen(event, "roomManagementDetail.fxml", 900, 550, "Room Management Detail");
    }
}
