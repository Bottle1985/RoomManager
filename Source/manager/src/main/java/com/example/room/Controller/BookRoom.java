package com.example.room.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.example.room.App;
import com.example.room.Model.BookRoomModel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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

public class BookRoom implements Initializable{
    @FXML
    private TableView<BookRoomModel> tableBookRoom;
    @FXML
    private TableColumn<BookRoomModel, String> colIdBook;
    @FXML
    private TableColumn<BookRoomModel, String> colIdName;
    @FXML
    private TableColumn<BookRoomModel, String> colCCCD;
    @FXML
    private TableColumn<BookRoomModel, String> colIdRoom;
    @FXML
    private TableColumn<BookRoomModel, String> colCheckInDate;
    @FXML
    private TableColumn<BookRoomModel, String> colCheckOutDate;
    @FXML
    private TableColumn<BookRoomModel, Integer> colNumber;
    @FXML
    private TableColumn<BookRoomModel, String> colStatus;
    @FXML
    private TextField txtIdBook;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtIdRoom;
    @FXML
    private TextField txtCheckInDate;
    @FXML
    private TextField txtCCCD;
    @FXML
    private TextField txtCheckOutDate;
    @FXML
    private TextField txtNumber;
    @FXML
    private Button btnExit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colIdBook.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdBook()));
        colIdName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        colCCCD.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCCCD()));
        colIdRoom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdRoom()));
        colCheckInDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCheckInDate()));
        colCheckOutDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCheckOutDate()));
        colNumber.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNumber()).asObject());
        colStatus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus()));

        tableBookRoom.setItems(getTableBookRoom());
    }

    private ObservableList<BookRoomModel> getTableBookRoom() {
        ObservableList<BookRoomModel> bookRoomData = FXCollections.observableArrayList();
        try {
            String fileName = "/RoomManager/Data/Boking.txt";
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              data = data.replaceAll(" ", "");
              String [] bookdataStrings = data.split(",");
              bookRoomData.add(new BookRoomModel(bookdataStrings[0], bookdataStrings[1],bookdataStrings[2], bookdataStrings[3], bookdataStrings[4], bookdataStrings[5], Integer.parseInt(bookdataStrings[6]), bookdataStrings[7]));
            }
            myReader.close();
            return bookRoomData;
        } catch (FileNotFoundException e) {
            System.out.println("An error file.");
            return bookRoomData;
        }
    }

    @FXML
    private void Add() throws IOException{
        BookRoomModel bookroom = new BookRoomModel();
        bookroom.setIdBook(txtIdBook.getText());
        bookroom.setName(txtName.getText());
        bookroom.setCCCD(txtCCCD.getText());
        bookroom.setIdRoom(txtIdRoom.getText());
        bookroom.setCheckInDate(txtCheckInDate.getText());
        bookroom.setCheckOutDate(txtCheckOutDate.getText());
        bookroom.setNumber(Integer.parseInt(txtNumber.getText()));
        bookroom.setStatus("success");
        tableBookRoom.getItems().add(bookroom);
        txtIdBook.clear();
        txtName.clear();
        txtCCCD.clear();
        txtCheckInDate.clear();
        txtCheckOutDate.clear();
        txtIdRoom.clear();
        txtNumber.clear();
    }
    
    @FXML
    private void returnBack(ActionEvent event) throws IOException {
       App.changeScreen(event, "bookingpage.fxml", 650, 500, "Booking");
    }
    
    @FXML
    public void Exit(){
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
}
