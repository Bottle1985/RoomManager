module com.example.room {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.room to javafx.fxml;
    exports com.example.room;
}
