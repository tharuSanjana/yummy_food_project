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
import lk.ijse.yummy_food_project.dto.CustomerDto;
import lk.ijse.yummy_food_project.dto.EmployeeDto;
import lk.ijse.yummy_food_project.dto.SupplierDto;
import lk.ijse.yummy_food_project.model.SupplierModel;

import java.sql.SQLException;
import java.util.List;

public class UpdateSupplierFormController {
    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox<String> cmbSupId;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    private SupplierModel supModel = new SupplierModel();
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
    public void initialize() throws SQLException {
        populateComboBoxEmpId();
    }
    private void closeForm() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();

    }

    @FXML
    void cmbEmpIdOnAction(ActionEvent event) {
        String supId = cmbSupId.getValue();
        try{
          SupplierDto supDto = supModel.searchSupplierId(supId);
            txtName.setText(supDto.getName());
            txtTel.setText(supDto.getTel());
            txtEmail.setText(supDto.getEmail());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void okButtonOnAction(ActionEvent event) {
        String id = cmbSupId.getValue();
        String name = txtName.getText();
        String tel = txtTel.getText();
        String email = txtEmail.getText();

        var dto = new SupplierDto(id, name, tel,email);
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
    public void populateComboBoxEmpId() throws SQLException {

        List<String> dataFromDB = supModel.getCmbSupId();
        ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
        cmbSupId.setItems(observableData);
    }
    private void clearFields() {
        txtName.setText("");
        txtTel.setText("");
        txtEmail.setText("");

    }
}
