package lk.ijse.yummy_food_project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.yummy_food_project.dto.CostPaymentDto;
import lk.ijse.yummy_food_project.dto.incomePaymentDto;
//import lk.ijse.yummy_food_project.dto.tm.PaymentTm;
import lk.ijse.yummy_food_project.dto.tm.CostPaymentTm;
import lk.ijse.yummy_food_project.dto.tm.IncomePaymentTm;
import lk.ijse.yummy_food_project.model.PaymentModel;


import javafx.event.ActionEvent;

public class PaymentFormController {
    @FXML
    private TableColumn<?, ?> costAmount;

    @FXML
    private TableColumn<?, ?> costDate;

    @FXML
    private TableColumn<?, ?> costPId;

    @FXML
    private TableColumn<?, ?> costSupId;

    @FXML
    private TableColumn<?, ?> costSupName;

    @FXML
    private TableColumn<?, ?> incomeAmount;

    @FXML
    private TableColumn<?, ?> incomeCusId;

    @FXML
    private TableColumn<?, ?> incomeCusName;

    @FXML
    private TableColumn<?, ?> incomeDate;

    @FXML
    private TableColumn<?, ?> incomePId;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblPaymentId;

    @FXML
    private Label lblTime;

    @FXML
    private TableView<CostPaymentDto> tblCost;

    @FXML
    private TableView<incomePaymentDto> tblIncome;

    @FXML
    private AnchorPane root;

    private ObservableList<incomePaymentDto> obList = FXCollections.observableArrayList();
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
        loadAllIncomePayment();
        loadAllCostPayment();
        setTime();

    }


    private void setCellValueFactory(){
       incomeDate.setCellValueFactory(new PropertyValueFactory<>("date"));
       incomePId.setCellValueFactory(new PropertyValueFactory<>("pId"));
       incomeCusId.setCellValueFactory(new PropertyValueFactory<>("cId"));
       incomeCusName.setCellValueFactory(new PropertyValueFactory<>("CName"));
       incomeAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
       costDate.setCellValueFactory(new PropertyValueFactory<>("date"));
       costPId.setCellValueFactory(new PropertyValueFactory<>("PId"));
       costSupId.setCellValueFactory(new PropertyValueFactory<>("sId"));
       costSupName.setCellValueFactory(new PropertyValueFactory<>("sName"));
       costAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
    }

    private void loadAllIncomePayment(){
        var model = new PaymentModel();

        ObservableList<incomePaymentDto> obList = FXCollections.observableArrayList();

        try{
            List<incomePaymentDto> dtoList = model.getAllIncomePayment();

            for (incomePaymentDto dto : dtoList){
                obList.add(
                        new IncomePaymentTm(
                               dto.getDate(),
                                dto.getPId(),
                                dto.getcId(),
                                dto.getCName(),
                                dto.getAmount()
                        )
                );
            }
            tblIncome.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadAllCostPayment(){
        var model = new PaymentModel();

        ObservableList<CostPaymentDto> obList = FXCollections.observableArrayList();

        try{
            ArrayList<CostPaymentDto> dtoList = model.getAllCostPayment();

            for (CostPaymentDto dto : dtoList){
                obList.add(
                        new CostPaymentTm(
                                dto.getDate(),
                                dto.getPId(),
                                dto.getSId(),
                                dto.getSName(),
                               dto.getAmount()
                        )
                );
            }
            tblCost.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}