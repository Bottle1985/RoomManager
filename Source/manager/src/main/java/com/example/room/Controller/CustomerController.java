package com.example.room.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import com.example.room.App;
import com.example.room.Model.CustomerModel;
import com.example.room.Model.RoomModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.text.Text;

public class CustomerController implements Initializable{
@FXML
    private TableView<CustomerModel> tableCustomer;
    @FXML
    private TableColumn<CustomerModel, String> colIdCustomer;
    @FXML
    private TableColumn<CustomerModel, String> colName;
    @FXML
    private TableColumn<CustomerModel, String> colCCCD;
    @FXML
    private TableColumn<CustomerModel, String> colPhoneNumber;
    @FXML
    private TableColumn<CustomerModel, String> colEmail;

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle){
        colIdCustomer.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getIdCustomer()));
        colName.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getName()));
        colCCCD.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getCCCD()));
        colPhoneNumber.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getPhoneNumber()));
        colEmail.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getEmail()));
        tableCustomer.setItems(getCustomerData());

    }
    private ObservableList<CustomerModel> getCustomerData() {
        // Tạo một danh sách các đối tượng Phong
        ObservableList<CustomerModel> customerModel = FXCollections.observableArrayList();

        // Thêm các dữ liệu mẫu vào danh sách
        customerModel.add(new CustomerModel("asd", "qwe", "123", "90880",""));
        customerModel.add(new CustomerModel("sdzxc", "qwe", "234", "809809","" ));
        customerModel.add(new CustomerModel("zxczxc", "qwe", "45345", "8908908", ""));

        return customerModel;
    }
}