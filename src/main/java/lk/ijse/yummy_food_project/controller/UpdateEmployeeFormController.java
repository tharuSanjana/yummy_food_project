package lk.ijse.yummy_food_project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lk.ijse.yummy_food_project.DAO.BoFactory;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.CustomerDAOImpl;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.EmployeeDAOImpl;
import lk.ijse.yummy_food_project.bo.Custom.CustomerBO;
import lk.ijse.yummy_food_project.bo.Custom.EmployeeBO;
import lk.ijse.yummy_food_project.bo.Custom.PaymentBO;
import lk.ijse.yummy_food_project.dto.EmployeeDto;
import lk.ijse.yummy_food_project.model.CustomerModel;
import lk.ijse.yummy_food_project.model.EmployeeModel;

import java.sql.SQLException;
import java.util.List;

public class UpdateEmployeeFormController {
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
    //CustomerDAOImpl customerDAO  = new CustomerDAOImpl();
    CustomerBO customerBO = (CustomerBO) BoFactory.boFactory().getBoTypes(BoFactory.BOTypes.CUSTOMER);

   // EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
    EmployeeBO employeeBO = (EmployeeBO) BoFactory.boFactory().getBoTypes(BoFactory.BOTypes.EMPLOYEE);


    public void initialize() {
        populateComboBoxEmpId();
        populateComboBoxUser();
    }
    public void cmbUserIdOnAction(ActionEvent actionEvent) {
    }

    public void okButtonOnAction(ActionEvent actionEvent) {
        String id =  cmbEmpId.getValue();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();
        String type = txtTy.getText();
        String userId =  cmbUserId.getValue();

        var dto = new EmployeeDto(id, name, address, tel, type, userId);
        try {
            boolean flag = employeeBO.updateEmployee(dto);
            if (flag) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee updated!").show();
                clearFields();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    private void clearFields() {
        txtName.setText("");
        txtAddress.setText("");
        txtTel.setText("");
        txtTy.setText("");

    }

    public void cancelButtonOnAction(ActionEvent actionEvent) {
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
            EmployeeDto empDto = employeeBO.searchEmpId(empId);
            txtName.setText(empDto.getName());
            txtAddress.setText(empDto.getAddress());
            txtTel.setText(empDto.getTel());
            txtTy.setText(empDto.getType());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void populateComboBoxEmpId() {

        List<String> dataFromDB = employeeBO.getCmbEmpId();
        ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
        cmbEmpId.setItems(observableData);
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
