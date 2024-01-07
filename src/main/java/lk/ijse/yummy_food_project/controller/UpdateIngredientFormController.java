package lk.ijse.yummy_food_project.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lk.ijse.yummy_food_project.DAO.BoFactory;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.IngredientsDAOImpl;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.PaymentDAOImpl;
import lk.ijse.yummy_food_project.bo.Custom.IngredientsBO;
import lk.ijse.yummy_food_project.bo.Custom.PaymentBO;
import lk.ijse.yummy_food_project.dto.IngredientsDto;
import lk.ijse.yummy_food_project.model.IngredientsModel;
import lk.ijse.yummy_food_project.model.PaymentModel;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class UpdateIngredientFormController {

    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox<String> cmbId;


    @FXML
    private ComboBox<String> cmbPId;

    @FXML
    private Label lblDate;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    private IngredientsModel ingModel = new IngredientsModel();
    private PaymentModel pModel = new PaymentModel();
    //IngredientsDAOImpl ingredientsDAO = new IngredientsDAOImpl();
    IngredientsBO ingredientsBO = (IngredientsBO) BoFactory.boFactory().getBoTypes(BoFactory.BOTypes.INGREDIENTS);
    //PaymentDAOImpl paymentDAO = new PaymentDAOImpl();
    PaymentBO paymentBO = (PaymentBO) BoFactory.boFactory().getBoTypes(BoFactory.BOTypes.PAYMENT);

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
    void cmbIdOnAction(ActionEvent event) {
        String ingId = cmbId.getValue();

        try{

            IngredientsDto ingDto = ingredientsBO.searchIngredientId(ingId);
            System.out.println(ingDto.getName());
            txtName.setText(ingDto.getName());
            txtPrice.setText(String.valueOf(ingDto.getPrice()));
            //cmbPId.setText(ingDto.getpId());
           // System.out.println(ingDto.getpId());
            txtQty.setText(String.valueOf(ingDto.getQty()));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize() throws SQLException {
        populateComboBoxIngId();
       populateComboBoxPId();
        setDate();
    }

    @FXML
    void okButtonAction(ActionEvent event) {
       String ingId = cmbId.getValue();
       String name = txtName.getText();
       double price = Double.parseDouble(txtPrice.getText());
       double qty = Double.parseDouble(txtQty.getText());
       String pId =  cmbPId.getValue();
        LocalDate date = LocalDate.parse(lblDate.getText());

        var dto = new IngredientsDto(ingId, name,price,qty,pId);
        try {
            boolean flag = ingredientsBO.updateIngredeient(dto,date);
            if (flag) {
                new Alert(Alert.AlertType.CONFIRMATION, "supplier updated!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    private void setDate(){
        lblDate.setText(String.valueOf(LocalDate.now()));
    }
    public void populateComboBoxIngId() throws SQLException {

        List<String> dataFromDB = ingredientsBO.getCmbIngId();
        ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
        cmbId.setItems(observableData);
    }
    public void clearFields(){

        txtName.setText("");
        txtPrice.setText("");
        txtQty.setText("");

    }
    public void populateComboBoxPId() throws SQLException {

        List<String> dataFromDB = paymentBO.getCmbPId();
        ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
        cmbPId.setItems(observableData);
    }
}
