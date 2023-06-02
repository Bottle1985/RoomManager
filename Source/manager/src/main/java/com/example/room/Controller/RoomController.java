package com.example.room.Controller;

import java.io.IOException;
import javafx.fxml.FXML;
import com.example.room.App;

public class RoomController {
    @FXML
    private void switchroomManagementDetail() throws IOException {
        App.setRoot("roomManagementDetail");
    }
}
