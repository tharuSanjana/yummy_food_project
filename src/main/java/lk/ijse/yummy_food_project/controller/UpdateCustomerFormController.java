package lk.ijse.yummy_food_project.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import lk.ijse.yummy_food_project.DAO.BoFactory;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.CustomerDAOImpl;
import lk.ijse.yummy_food_project.bo.Custom.CustomerBO;
import lk.ijse.yummy_food_project.bo.Custom.PaymentBO;
import lk.ijse.yummy_food_project.dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;


public class UpdateCustomerFormController {
    @FXML
    private ComboBox<String> cmbCusId;

    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox<String> cmbUserId;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;
    //CustomerDAOImpl customerDAO  = new CustomerDAOImpl();
    CustomerBO customerBO = (CustomerBO) BoFactory.boFactory().getBoTypes(BoFactory.BOTypes.CUSTOMER);


    public void initialize() {
        populateComboBox();
        populateComboBoxUser();
    }
    @FXML
    void cancelButtonOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.showAndWait().ifPresent(response -> {
            if (response == javafx.scene.control.ButtonType.OK) {

                closeForm();
            } else {

            }
        });
    }


    private void closeForm() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }


    @FXML
    void cmbCusIdOnAction(ActionEvent event) {
        String cusId = cmbCusId.getValue();
        try{
            CustomerDto cusDto = customerBO.searchCustomerId(cusId);
            txtName.setText(cusDto.getName());
            txtAddress.setText(cusDto.getAddress());
            txtTel.setText(cusDto.getTel());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void populateComboBox() {

        List<String> dataFromDB = customerBO.getCmbCustomerId();
        ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
        cmbCusId.setItems(observableData);
    }

    @FXML
    void cmbUserIdOnAction(ActionEvent event) {

    }

    @FXML
    void okButtonOnAction(ActionEvent event) {
        String id = cmbCusId.getValue();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();
        String userId = cmbUserId.getValue();

        var dto = new CustomerDto(id, name, address, tel, userId);
        try {
            boolean flag = customerBO.updateCustomer(dto);
            if (flag) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    private void clearFields() {
       // cmbCusId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtTel.setText("");
        // cmbUserId.setItems("");
    }

    public void populateComboBoxUser() {

        try {
            List<String> dataFromDB = customerBO.getCmbUserId();
            ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
            cmbUserId.setItems(observableData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
