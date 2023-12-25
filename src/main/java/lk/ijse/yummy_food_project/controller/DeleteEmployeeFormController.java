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
import lk.ijse.yummy_food_project.DAO.EmployeeDAOImpl;
import lk.ijse.yummy_food_project.dto.EmployeeDto;
import lk.ijse.yummy_food_project.model.CustomerModel;
import lk.ijse.yummy_food_project.model.EmployeeModel;

import java.sql.SQLException;
import java.util.List;

public class DeleteEmployeeFormController {
    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox<String> cmbEmpId;

    @FXML
    private ComboBox<String> cmbUserId;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtTy;
private EmployeeModel empModel = new EmployeeModel();
private CustomerModel cusModel = new CustomerModel();
CustomerDAOImpl customerDAO = new CustomerDAOImpl();
EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
    public void initialize() {
        populateComboBoxEmpId();
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
    void cmbEmpIdOnAction(ActionEvent event) {
        String empId =  cmbEmpId.getValue();
        try{
            EmployeeDto empDto = employeeDAO.searchEmpId(empId);
            txtName.setText(empDto.getName());
            txtAddress.setText(empDto.getAddress());
            txtTel.setText(empDto.getTel());
            txtTy.setText(empDto.getType());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearFields() {
        txtName.setText("");
        txtAddress.setText("");
        txtTel.setText("");
        txtTy.setText("");

    }

    @FXML
    void cmbUserIdOnAction(ActionEvent event) {

    }

    @FXML
    void okButtonOnAction(ActionEvent event) {
        String id = cmbEmpId.getValue();
        try {
            boolean flag = employeeDAO.deleteEmployee(id);
            if (flag) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    public void populateComboBoxEmpId() {

        List<String> dataFromDB = employeeDAO.getCmbEmpId();
        ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
        cmbEmpId.setItems(observableData);
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
