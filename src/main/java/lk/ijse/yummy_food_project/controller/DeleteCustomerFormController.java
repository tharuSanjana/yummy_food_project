package lk.ijse.yummy_food_project.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteCustomerFormController {
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

    }

    @FXML
    void cmbUserIdOnAction(ActionEvent event) {

    }

    @FXML
    void okButtonOnAction(ActionEvent event) {

    }
}
