package lk.ijse.yummy_food_project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.yummy_food_project.dto.PaymentDto;
//import lk.ijse.yummy_food_project.dto.tm.PaymentTm;
import lk.ijse.yummy_food_project.dto.tm.PaymentTm;
import lk.ijse.yummy_food_project.dto.tm.SavePaymentTm;
import lk.ijse.yummy_food_project.model.PaymentModel;


import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;

public class PaymentFormController {
    @FXML
    private Label lblDate;

    @FXML
    private Label lblPaymentId;

    @FXML
    private Label lblTime;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<PaymentDto> tblPayment;

    @FXML
    private TextField txtAmount;

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colPiD;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colCustomerName;




    @FXML
    private Label lblCustomerId;

    @FXML
    private Label lblCustomerName;

    private ObservableList<PaymentDto> obList = FXCollections.observableArrayList();
    private PaymentModel pModel = new PaymentModel();


    private void setDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    public void setTime() {
        // lblTime.setText(String.valueOf(LocalTime.now()));
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        lblTime.setText(formattedTime);
    }
    private String generatePaymentId(){
        String paymentId = null;
        try {
            paymentId = pModel.getGeneratePaymentId();
            lblPaymentId.setText(paymentId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

        return paymentId;
    }
    @FXML
    void backOnButtonAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Supplier Manage");
        stage.centerOnScreen();
    }
    public void initialize(){
        String oId=generatePaymentId();
        lblPaymentId.setText(oId);
        setDate();
        setCellValueFactory();
       loadAllPayment();
        setTime();

    }
    @FXML
    void saveOnButtonAction(ActionEvent event) {
       /* String id = lblPaymentId.getText();
        double amount = Double.parseDouble(txtAmount.getText());
        String cusId = lblCustomerId.getText();
        String cusName = lblCustomerName.getText();
        LocalDate date = LocalDate.parse(lblDate.getText());

        //var dto = new PaymentDto(id,amount,cusId,cusName,date);
        PaymentDto savePaymentTm = new SavePaymentTm( id,amount,cusId,cusName,date);

        obList.add(savePaymentTm);

        tblPayment.setItems(obList);*/

       /* try{
            boolean flag = pModel.savePayment(dto);

            if(flag){
                new Alert(Alert.AlertType.CONFIRMATION, "payment saved!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }*/
    }
    private void clearFields() {
        lblPaymentId.setText("");
        txtAmount.setText("");
        lblDate.setText("");

    }
    private void setCellValueFactory(){
       /* colPiD.setCellValueFactory(new PropertyValueFactory<>("p_id"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("cus_id"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));*/
    }

    private void loadAllPayment(){
        /*var model = new PaymentModel();

        ObservableList<PaymentDto> obList = FXCollections.observableArrayList();

        try{
            List<PaymentDto> dtoList = model.getAllPayment();

            for (PaymentDto dto : dtoList){
                obList.add(
                        new PaymentTm(
                                dto.getId(),
                                dto.getAmount(),
                                dto.getCusId(),
                                dto.getCusName(),
                                dto.getDate()
                        )
                );
            }
            tblPayment.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }

}