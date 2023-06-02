package com.example.room.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.room.Model.RoomModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class RoomDetailsController implements Initializable {
    @FXML
    private Button returnButtonPayment;
    @FXML
    private TableView<RoomModel> tablePhong;
    @FXML
    private TableColumn<RoomModel, String> colMaPhong;
    @FXML
    private TableColumn<RoomModel, String> colSoPhong;
    @FXML
    private TableColumn<RoomModel, String> colLoaiPhong;
    @FXML
    private TableColumn<RoomModel, String> colTrangThai;
    @FXML
    private TableColumn<RoomModel, Double> colGiaThue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Liên kết cột với thuộc tính của đối tượng RoomModel

        colMaPhong.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMaPhong()));
        colSoPhong.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSoPhong()));
        colLoaiPhong.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLoaiPhong()));
        colTrangThai.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTrangThai()));
        colGiaThue
                .setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getGiaThue()).asObject());

        // Lấy dữ liệu từ nguồn dữ liệu (ví dụ: danh sách phòng)
        // và đặt nó vào bảng
        tablePhong.setItems(getPhongData());
    }

    private ObservableList<RoomModel> getPhongData() {
        // Tạo một danh sách các đối tượng Phong
        ObservableList<RoomModel> phongData = FXCollections.observableArrayList();

        // Thêm các dữ liệu mẫu vào danh sách
        phongData.add(new RoomModel("P001", "101", "Phòng Đơn", "Trống", 100.0));
        phongData.add(new RoomModel("P002", "102", "Phòng Đôi", "Đầy", 150.0));
        phongData.add(new RoomModel("P003", "103", "Suite", "Trống", 200.0));

        return phongData;
    }

    public void closeWindowPayment() {
        Stage stage = (Stage) returnButtonPayment.getScene().getWindow();
        stage.close();
    }

}
