package lk.ijse.yummy_food_project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.yummy_food_project.dto.CustomerDto;
import lk.ijse.yummy_food_project.dto.tm.CustomerTm;
import lk.ijse.yummy_food_project.model.CustomerModel;


public class CustomerFormController {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<CustomerDto> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtUserId;
    @FXML
    private TableColumn<?, ?> colUserID;

    private CustomerModel cusModel = new CustomerModel();

    public void initialize() {
        setCellValueFactory();
        loadAllCustomer();
    }
    private void setCellValueFactory(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colUserID.setCellValueFactory(new PropertyValueFactory<>("userId"));
    }
    private void loadAllCustomer(){
       var model = new CustomerModel();

        ObservableList<CustomerDto> obList = FXCollections.observableArrayList();

        try{
            List<CustomerDto> dtoList = model.getAllCustomer();

            for (CustomerDto dto : dtoList){
                obList.add(
                        new CustomerTm(
                                dto.getId(),
                                dto.getName(),
                                dto.getAddress(),
                                dto.getTel(),
                                dto.getUserId()
                        )
                );
            }
           tblCustomer.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
    }
    @FXML
    void saveButtonOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();
        String userId = txtUserId.getText();

        var dto = new CustomerDto(id,name,address,tel,userId);

       try{
           boolean flag = cusModel.saveCustomer(dto);

           if(flag){
               new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
               clearFields();
           }
       } catch (SQLException e) {
           new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
       }

    }
    @FXML
    void updateButtonOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();
        String userId = txtUserId.getText();

        var dto = new CustomerDto(id,name,address,tel,userId);
        try {
            boolean flag = cusModel.updateCustomer(dto);
            if (flag){
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void deleteButtonOnAction(ActionEvent event) {
    String id = txtId.getText();

    try{
        boolean flag = cusModel.deleteCustomer(id);
        if (flag){
            new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "customer not deleted!").show();
        }

    } catch (SQLException e) {
        new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
    }
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtTel.setText("");
        txtUserId.setText("");
    }
}
