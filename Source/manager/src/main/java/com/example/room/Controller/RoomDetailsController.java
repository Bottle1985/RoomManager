package com.example.room.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.room.App;
import com.example.room.Model.RoomModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.input.MouseEvent;

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

    @FXML
    private TextField txtMaPhong;
    @FXML
    private TextField txtSoPhong;
    @FXML
    private TextField txtLoaiPhong;
    @FXML
    private TextField txtTrangThai;
    @FXML
    private TextField txtGiaThue;

    @FXML
    private Button btnExit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Liên kết cột với thuộc tính của đối tượng RoomModel

        colMaPhong.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMaPhong()));
        colSoPhong.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSoPhong()));
        colLoaiPhong.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLoaiPhong()));
        colTrangThai.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTrangThai()));
        colGiaThue.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getGiaThue()).asObject());

        // Lấy dữ liệu từ nguồn dữ liệu (ví dụ: danh sách phòng)
        // và đặt nó vào bảng
        tablePhong.setItems(getPhongData());
    }

    private ObservableList<RoomModel> getPhongData() {
        // Tạo một danh sách các đối tượng Phong
        ObservableList<RoomModel> roomModel = FXCollections.observableArrayList();

        // Thêm các dữ liệu mẫu vào danh sách
        roomModel.add(new RoomModel("P001", "101", "Phòng Đơn", "Trống", 100.0));
        roomModel.add(new RoomModel("P002", "102", "Phòng Đôi", "Đầy", 150.0));
        roomModel.add(new RoomModel("P003", "103", "Suite", "Trống", 200.0));

        return roomModel;
    }

    @FXML
    private void addRoom() throws IOException {
        String maPhong = txtMaPhong.getText();

        // Kiểm tra nếu maPhong tồn tại trong danh sách
        for (RoomModel room : tablePhong.getItems()) {
            if (room.getMaPhong().equals(maPhong)) {
                // Cập nhật thông tin của dòng đã tồn tại
                room.setSoPhong(txtSoPhong.getText());
                room.setLoaiPhong(txtLoaiPhong.getText());
                room.setTrangThai(txtTrangThai.getText());
                room.setGiaThue(Double.parseDouble(txtGiaThue.getText()));

                // Cập nhật lại hiển thị của bảng
                tablePhong.refresh();

                // Xóa nội dung trong TextField sau khi thêm/sửa dòng
                txtMaPhong.clear();
                txtSoPhong.clear();
                txtLoaiPhong.clear();
                txtGiaThue.clear();
                txtTrangThai.clear();
                return; // Kết thúc phương thức sau khi đã cập nhật dòng
            }
        }

        // Nếu không tìm thấy maPhong trong danh sách, thêm dòng mới
        RoomModel roomModel = new RoomModel();
        roomModel.setMaPhong(txtMaPhong.getText());
        roomModel.setSoPhong(txtSoPhong.getText());
        roomModel.setLoaiPhong(txtLoaiPhong.getText());
        roomModel.setTrangThai(txtTrangThai.getText());
        roomModel.setGiaThue(Double.parseDouble(txtGiaThue.getText()));
        tablePhong.getItems().add(roomModel);

        // Xóa nội dung trong TextField sau khi thêm/sửa dòng
        txtMaPhong.clear();
        txtSoPhong.clear();
        txtLoaiPhong.clear();
        txtGiaThue.clear();
        txtTrangThai.clear();
    }

    @FXML
    public void handleRowSelected(MouseEvent event) {
        // Lấy dòng được chọn
        RoomModel selectedRow = tablePhong.getSelectionModel().getSelectedItem();
        if (selectedRow != null) {
            String maPhong = selectedRow.getMaPhong();
            String soPhong = selectedRow.getSoPhong();
            String loaiPhong = selectedRow.getLoaiPhong();
            String trangThai = selectedRow.getTrangThai();
            double giaThue = selectedRow.getGiaThue();

            // Hiển thị thông tin trong các TextField
            txtMaPhong.setText(maPhong);
            txtSoPhong.setText(soPhong);
            txtLoaiPhong.setText(loaiPhong);
            txtTrangThai.setText(trangThai);
            txtGiaThue.setText(String.valueOf(giaThue));

        }
    }

    @FXML
    private void deleteRoom(ActionEvent event) throws IOException {
        tablePhong.getItems().removeAll(tablePhong.getSelectionModel().getSelectedItem());
        txtMaPhong.clear();
        txtSoPhong.clear();
        txtLoaiPhong.clear();
        txtGiaThue.clear();
        txtTrangThai.clear();
    }

    @FXML
    private void Return(ActionEvent event) throws IOException {
        App.changeScreen(event, "secondary.fxml", 650, 500, "Booking");
    }

    public void Exit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
}
