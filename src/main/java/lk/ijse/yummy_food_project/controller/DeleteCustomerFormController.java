package lk.ijse.yummy_food_project.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.yummy_food_project.DAO.CustomerDAOImpl;
import lk.ijse.yummy_food_project.dto.CustomerDto;
import lk.ijse.yummy_food_project.model.CustomerModel;

import java.sql.SQLException;
import java.util.List;

public class DeleteCustomerFormController {
    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox<String> cmbCusId;

    @FXML
    private ComboBox<String> cmbUserId;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;
private CustomerModel cusModel = new CustomerModel();
CustomerDAOImpl customerDAO = new CustomerDAOImpl();

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
        String cusId =  cmbCusId.getValue();
        try{
            CustomerDto cusDto = customerDAO.searchCustomerId(cusId);
            txtName.setText(cusDto.getName());
            txtAddress.setText(cusDto.getAddress());
            txtTel.setText(cusDto.getTel());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void populateComboBox() {

        List<String> dataFromDB = customerDAO.getCmbCustomerId();
        ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
        cmbCusId.setItems(observableData);

    }

    @FXML
    void cmbUserIdOnAction(ActionEvent event) {

    }

    @FXML
    void okButtonOnAction(ActionEvent event) {
        String id = cmbCusId.getValue();

        try {
            boolean flag = customerDAO.deleteCustomer(id);
            if (flag) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "customer not deleted!").show();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    public void populateComboBoxUser() {

        try {
            List<String> dataFromDB = customerDAO.getCmbUserId();
            ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
            cmbUserId.setItems(observableData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
