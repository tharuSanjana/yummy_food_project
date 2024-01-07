package lk.ijse.yummy_food_project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.ijse.yummy_food_project.DAO.BoFactory;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.SupplierDAOImpl;
import lk.ijse.yummy_food_project.bo.Custom.PaymentBO;
import lk.ijse.yummy_food_project.bo.Custom.SupplierBO;
import lk.ijse.yummy_food_project.dto.SupplierDto;
import lk.ijse.yummy_food_project.dto.tm.SupplierTm;
import lk.ijse.yummy_food_project.email.SendEmail;
import lk.ijse.yummy_food_project.model.SupplierModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class SupplierFormController{

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private Label lblId;

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
    private TextField txtName;

    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtEmail;
    private SupplierModel supModel = new SupplierModel();
   // SupplierDAOImpl supplierDAO = new SupplierDAOImpl();
    SupplierBO supplierBO = (SupplierBO) BoFactory.boFactory().getBoTypes(BoFactory.BOTypes.SUPPLIER);

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
    void deleteButtonOnAction(ActionEvent event) throws IOException {
       /* boolean isSupplierValid = validateSupplier();
        if (isSupplierValid) {
            String id = lblId.getText();

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
        }*/
        URL resource = this.getClass().getResource("/view/deleteSupplierform.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent load = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Update supplier");
        stage.setScene(new Scene(load));
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setResizable(false);
        stage.show();
    }


    @FXML
    void saveButtonOnAction(ActionEvent event) {
        boolean isSupplierValid = validateSupplier();
        if (isSupplierValid) {
            String id = lblId.getText();
            String name = txtName.getText();
            String tel = txtTel.getText();
            String email = txtEmail.getText();

            var dto = new SupplierDto(id, name, tel,email);

            try {
                boolean flag = supplierBO.saveSupplier(dto);

                if (flag) {
                    new Alert(Alert.AlertType.CONFIRMATION, "supplier saved!").show();
                    /*SendEmail mail = new SendEmail();
                    String[] list =new String[]{dto.getEmail()};
                    mail.sendFromGMail(list,"Saved","You are saved !!");*/
                    clearFields();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    @FXML
    void updateButtonOnAction(ActionEvent event) throws IOException {


        URL resource = this.getClass().getResource("/view/updateSupplierform.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent load = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Update supplier");
        stage.setScene(new Scene(load));
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setResizable(false);
        stage.show();
    }
    private void clearFields() {
        lblId.setText("");
        txtName.setText("");
        txtTel.setText("");

    }
    public void initialize() {
        generateSupplierId();
        setCellValueFactory();
        loadAllSupplier();
    }
    private void setCellValueFactory(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

    }
    private void loadAllSupplier(){
        //ar model = new SupplierModel();

        ObservableList<SupplierDto> obList = FXCollections.observableArrayList();

        try{
            List<SupplierDto> dtoList = supplierBO.getAllSupplier();

            for (SupplierDto dto : dtoList){
                obList.add(
                        new SupplierTm(
                                dto.getId(),
                                dto.getName(),
                                dto.getTel(),
                                dto.getEmail()

                        )
                );
            }
            tblSupplier.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private  boolean validateSupplier(){
        String id = lblId.getText();
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
    private String generateSupplierId(){
        String supId = null;
        try {
            supId = supplierBO.getGenerateSupplierId();
            lblId.setText(supId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

        return supId;
    }

}
