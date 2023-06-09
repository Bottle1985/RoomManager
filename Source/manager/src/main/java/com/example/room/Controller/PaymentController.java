package com.example.room.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentController {

    @FXML
    private RadioButton onDeliveryButton;

    @FXML
    private RadioButton advancePaymentButton;

    @FXML
    private RadioButton upsButton;

    @FXML
    private RadioButton dhlButton;

    @FXML
    private RadioButton postButton;

    @FXML
    private RadioButton glsButton;

    @FXML
    private Button returnButtonPayment;

    @FXML
    private TextField idRoomTextField;

    @FXML
    private TextField idBookTextField;

    private ToggleGroup paymentToggle;
    private ToggleGroup deliveryToggle;

    private RadioButton selectedPaymentRadioButton;
    private RadioButton selectedDeliveryRadioButton;

    public void initialize() {
        paymentToggle = new ToggleGroup();
        deliveryToggle = new ToggleGroup();

        onDeliveryButton.setToggleGroup(paymentToggle);
        advancePaymentButton.setToggleGroup(paymentToggle);
        dhlButton.setToggleGroup(deliveryToggle);
        glsButton.setToggleGroup(deliveryToggle);
        postButton.setToggleGroup(deliveryToggle);
        upsButton.setToggleGroup(deliveryToggle);
    }

    public void proceedToOrderingConfirmation() throws IOException {
        selectedPaymentRadioButton = (RadioButton) paymentToggle.getSelectedToggle();
        selectedDeliveryRadioButton = (RadioButton) deliveryToggle.getSelectedToggle();

        if (selectedPaymentRadioButton == null || selectedDeliveryRadioButton == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Notification");
            alert.setHeaderText("Please choose a payment method");
            alert.showAndWait();
            return;
        }

        String paymentMethod = selectedPaymentRadioButton.getText();
        String deliveryMethod = selectedDeliveryRadioButton.getText();
        String idRoom = idRoomTextField.getText();
        String idBook = idBookTextField.getText();

        if (idRoom.isEmpty() || idBook.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Notification");
            alert.setHeaderText("Please fill in IdRoom and IdBook");
            alert.showAndWait();
            return;
        }

        boolean paymentSuccess = processPayment(paymentMethod);
        boolean deliverySuccess = processDelivery(deliveryMethod);

        if (paymentSuccess && deliverySuccess) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notification");
            alert.setHeaderText("Payment success");
            alert.showAndWait();


            FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) returnButtonPayment.getScene().getWindow();
            currentStage.setScene(new Scene(root));
            currentStage.setTitle("Room Manager");
            currentStage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred during the payment process");
            alert.setContentText("Please try again or contact the service staff");
            alert.showAndWait();
        }
    }

    public void closeWindowPayment() {
        Stage stage = (Stage) returnButtonPayment.getScene().getWindow();
        stage.close();
    }

    public boolean processPayment(String paymentMethod) {
        return true;
    }

    public boolean processDelivery(String deliveryMethod) {
        return true;
    }
}