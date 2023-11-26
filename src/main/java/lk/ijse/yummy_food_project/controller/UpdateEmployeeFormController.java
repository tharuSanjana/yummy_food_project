package lk.ijse.yummy_food_project.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
public class UpdateEmployeeFormController {
    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox<?> cmbCusId;

    @FXML
    private ComboBox<?> cmbUserId;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    public void cmbUserIdOnAction(ActionEvent actionEvent) {
    }

    public void okButtonOnAction(ActionEvent actionEvent) {
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

    public void cmbCusIdOnAction(ActionEvent actionEvent) {

    }
}
