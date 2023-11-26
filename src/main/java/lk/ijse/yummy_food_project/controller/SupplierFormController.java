package lk.ijse.yummy_food_project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.yummy_food_project.dto.SupplierDto;
import lk.ijse.yummy_food_project.dto.tm.SupplierTm;
import lk.ijse.yummy_food_project.model.SupplierModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class SupplierFormController{




    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableColumn<?, ?> colUserID;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<SupplierDto> tblSupplier;


    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    private SupplierModel supModel = new SupplierModel();
    @FXML
    void backButtonOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
    }

    @FXML
    void deleteButtonOnAction(ActionEvent event) {
        boolean isSupplierValid = validateSupplier();
        if (isSupplierValid) {
            String id = txtId.getText();

            try {
                boolean flag = supModel.deleteSupplier(id);
                if (flag) {
                    new Alert(Alert.AlertType.CONFIRMATION, "supplier deleted!").show();
                } else {
                    new Alert(Alert.AlertType.CONFIRMATION, "supplier not deleted!").show();
                }

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }


    @FXML
    void saveButtonOnAction(ActionEvent event) {
        boolean isSupplierValid = validateSupplier();
        if (isSupplierValid) {
            String id = txtId.getText();
            String name = txtName.getText();
            String tel = txtTel.getText();


            var dto = new SupplierDto(id, name, tel);

            try {
                boolean flag = supModel.saveSupplier(dto);

                if (flag) {
                    new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                    clearFields();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    @FXML
    void updateButtonOnAction(ActionEvent event) {
        boolean isSupplierValid = validateSupplier();
        if (isSupplierValid) {
            String id = txtId.getText();
            String name = txtName.getText();
            String tel = txtTel.getText();


            var dto = new SupplierDto(id, name, tel);
            try {
                boolean flag = supModel.updateSupplier(dto);
                if (flag) {
                    new Alert(Alert.AlertType.CONFIRMATION, "supplier updated!").show();
                    clearFields();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }
    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtTel.setText("");

    }
    public void initialize() {
        setCellValueFactory();
        loadAllSupplier();
    }
    private void setCellValueFactory(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));

    }
    private void loadAllSupplier(){
        var model = new SupplierModel();

        ObservableList<SupplierDto> obList = FXCollections.observableArrayList();

        try{
            List<SupplierDto> dtoList = model.getAllSupplier();

            for (SupplierDto dto : dtoList){
                obList.add(
                        new SupplierTm(
                                dto.getId(),
                                dto.getName(),
                                dto.getTel()

                        )
                );
            }
            tblSupplier.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private  boolean validateSupplier(){
        String id = txtId.getText();
        boolean isIdValid = Pattern.matches("[S][0-9]{3,}",id);
        if (!isIdValid){
            new Alert(Alert.AlertType.ERROR,"Invalid supplier id").show();
            return false;
        }

        String name = txtName.getText();
        boolean isNameValid = Pattern.matches("[A-Za-z]{4,}",name);
        if(!isNameValid){
            new Alert(Alert.AlertType.ERROR,"Invalid supplier name").show();
            return  false;
        }


        String tel = txtTel.getText();
        boolean isTelValid = Pattern.matches("[0][7]{8}",tel);
        if(isTelValid){
            new Alert(Alert.AlertType.ERROR,"Invalid phone number").show();
            return  false;
        }

        return true;
    }
}
