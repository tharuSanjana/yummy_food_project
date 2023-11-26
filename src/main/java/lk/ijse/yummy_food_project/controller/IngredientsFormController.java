package lk.ijse.yummy_food_project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;


import javafx.stage.Stage;
import lk.ijse.yummy_food_project.dto.Ingredients1Dto;
import lk.ijse.yummy_food_project.dto.IngredientsDto;
import lk.ijse.yummy_food_project.dto.tm.IngredientsTm;
import lk.ijse.yummy_food_project.model.IngredientsModel;
import lk.ijse.yummy_food_project.model.PaymentModel;

public class IngredientsFormController {
    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TextField txtId;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<IngredientsDto> tblIngridients;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;
    @FXML
    private TableColumn<?, ?> colTotal;
    @FXML
    private Label lblNetTotal;
    @FXML
    private Label lblPaymentId;
    private PaymentModel pModel = new PaymentModel();

    private IngredientsModel ingModel = new IngredientsModel();
    private ObservableList<IngredientsTm> obList = FXCollections.observableArrayList();


    @FXML
    void saveButtonOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        double price = Double.parseDouble(txtPrice.getText());
        double qty = Double.parseDouble(txtQty.getText());
        String pId = lblPaymentId.getText();


        var dto = new Ingredients1Dto(id, name, price, qty, pId);
        // var tm = new IngredientsTm(id,name,price,qty,btn);
        try {
            // boolean flag = ingModel.saveIngredients();
            boolean flag = ingModel.saveIngredients(dto);

            if (flag) {
                new Alert(Alert.AlertType.CONFIRMATION, "Ingredients saved!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }


    @FXML
    void updateButtonOnAction(ActionEvent event) {

    }
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Dashboard Manage");
        stage.centerOnScreen();

    }


    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        //colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }


    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtPrice.setText("");
        txtQty.setText("");

    }

    public void initialize() {
        setCellValueFactory();
        generatePaymentId();
         loadAllIngredients();
        //  tableListener();
    }



    @FXML
    void addButtonOnAction(ActionEvent event) {

    }



    private String generatePaymentId () {
        String paymentId = null;
        try {
            paymentId = pModel.getGeneratePaymentId();
            lblPaymentId.setText(paymentId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

        return paymentId;
    }
    private void loadAllIngredients(){
        var model = new IngredientsModel();

        ObservableList<IngredientsDto> obList = FXCollections.observableArrayList();

        try{
            ArrayList<IngredientsDto> dtoList = model.getAllIngredients();

            for (IngredientsDto dto : dtoList){
                obList.add(
                        new IngredientsTm(
                                dto.getId(),
                                dto.getName(),
                                dto.getPrice(),
                                dto.getQty()

                        )
                );
            }
            tblIngridients.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
