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
import lk.ijse.yummy_food_project.DAO.BoFactory;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.SupplierDAOImpl;
import lk.ijse.yummy_food_project.bo.Custom.EmployeeBO;
import lk.ijse.yummy_food_project.bo.Custom.SupplierBO;
import lk.ijse.yummy_food_project.dto.SupplierDto;
import lk.ijse.yummy_food_project.entity.Supplier;


import java.sql.SQLException;
import java.util.List;

public class DeleteSupplierFormController {
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

   // SupplierDAOImpl supplierDAO = new SupplierDAOImpl();
   SupplierBO supplierBO = (SupplierBO) BoFactory.boFactory().getBoTypes(BoFactory.BOTypes.SUPPLIER);



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
            Supplier sup = supplierBO.searchSupplierId(supId);
            txtName.setText(sup.getName());
            txtTel.setText(sup.getTel());
            txtEmail.setText(sup.getEmail());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void okButtonOnAction(ActionEvent event) {
        String id = cmbSupId.getValue();
        try {
            boolean flag = supplierBO.deleteSupplier(id);
            if (flag) {
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    public void populateComboBoxEmpId() throws SQLException {

        List<String> dataFromDB = supplierBO.getCmbSupId();
        ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
        cmbSupId.setItems(observableData);
    }
    private void clearFields() {
        txtName.setText("");
        txtTel.setText("");
        txtEmail.setText("");

    }
}
