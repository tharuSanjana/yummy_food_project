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

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import lk.ijse.yummy_food_project.dto.EmployeeDto;
import lk.ijse.yummy_food_project.dto.tm.EmployeeTm;
import lk.ijse.yummy_food_project.model.EmployeeModel;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EmployeeFormController {
    @FXML
    private TextField txtType;


    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

  //  @FXML
    //private TextField txtUserId;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private TableView<EmployeeDto> tblEmployee;

    @FXML
    private ComboBox<String> cmbUserId = new ComboBox<>();
    private EmployeeModel empModel = new EmployeeModel();
      // cmbUserId = new ComboBox<>();
   // private UserModel userModel = new UserModel();

    public void initialize() {
        setCellValueFactory();
        loadAllEmployee();
        populateComboBox();
        //populateComboBoxEmpType();
    }

    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(anchorPane);

        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Employee Manage");
        stage.centerOnScreen();
    }
    @FXML
    void saveButtonOnAction(ActionEvent event)  {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();
        String type = txtType.getText();
        String userId =cmbUserId.getValue();


        var dto = new EmployeeDto(id,name,address,tel,type,userId);

        try{
            boolean flag = empModel.saveEmp(dto);
            if(flag){
                new Alert(Alert.AlertType.CONFIRMATION,"Employee saved!").show();
                clearFields();
            }
        }catch (SQLException e){
          new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }
    public void clearFields(){
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtTel.setText("");
       // cmbtype.setItems().clear();
        //cmbtype.getItems().clear();
        cmbUserId.getItems().clear();
    }

    public void setCellValueFactory(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
    }

    public void loadAllEmployee(){
        var model = new EmployeeModel();

        ObservableList<EmployeeDto>obList = FXCollections.observableArrayList();
        try{
            List<EmployeeDto>dtoList = model.getAllEmployee();
            for(EmployeeDto dto:dtoList){
                obList.add(
                        new EmployeeTm(
                                dto.getId(),
                                dto.getName(),
                                dto.getAddress(),
                                dto.getTel(),
                                dto.getType(),
                                dto.getUserId()
                        )
                );

            }
            tblEmployee.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void populateComboBox() {
       /* try {
            List<String> dataFromDB = empModel.getCmbUserId();
           // List<String> dataFromDB = Collections.singletonList(empModel.getCmbUserId());
            ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
            cmbUserId.setItems(observableData);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        try {
            List<String> dataFromDB = empModel.getCmbUserId();
            ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
            cmbUserId.setItems(observableData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   /* public void populateComboBoxEmpType() {
      /*  try {
            List<String> dataFromDB = empModel.getCmbEmployeeType();
            ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
            cmbtype.setItems(observableData);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
       /* try {
            List<String> dataFromDB = empModel.getCmbEmployeeType();
            ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
            cmbtype.setItems(observableData);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }*/
   @FXML
   void updateButtonOnAction(ActionEvent event) {
       String id = txtId.getText();
       String name = txtName.getText();
       String address = txtAddress.getText();
       String tel = txtTel.getText();
       String type = txtType.getText();
       String userId =cmbUserId.getValue();

       var dto = new EmployeeDto(id,name,address,tel,type,userId);
       try{
           boolean flag = empModel.updateEmployee(dto);
                if(flag){
                    new Alert(Alert.AlertType.CONFIRMATION,"Employee updated!").show();
                    clearFields();
                }

       } catch (SQLException e) {
          new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
       }
   }

    @FXML
    void deleteButtonOnAction(ActionEvent event) {
        String id = txtId.getText();
        try{
            boolean flag = empModel.deleteEmployee(id);
            if(flag){
                new Alert(Alert.AlertType.CONFIRMATION,"Employee deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

}
