package lk.ijse.yummy_food_project.controller;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import lk.ijse.yummy_food_project.DAO.BoFactory;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.EmployeeDAOImpl;
import lk.ijse.yummy_food_project.bo.Custom.EmployeeBO;
import lk.ijse.yummy_food_project.dto.EmployeeDto;
import lk.ijse.yummy_food_project.dto.tm.EmployeeTm;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
public class EmployeeFormController {
    @FXML
    private TextField txtType;


    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAddress;

    @FXML
    private Label lblEmpId;


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
   // EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
    EmployeeBO employeeBO = (EmployeeBO) BoFactory.boFactory().getBoTypes(BoFactory.BOTypes.EMPLOYEE);

    // cmbUserId = new ComboBox<>();
   // private UserModel userModel = new UserModel();

    public void initialize() {
        generateEmployeeId();
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
        boolean isEmployeeValid = validateEmployee();
        if(isEmployeeValid) {
            String id = lblEmpId.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String tel = txtTel.getText();
            String type = txtType.getText();
            String userId = cmbUserId.getValue();


            var dto = new EmployeeDto(id, name, address, tel, type, userId);

            try {
                boolean flag = employeeBO.saveEmp(dto);
                if (flag) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Employee saved!").show();
                    clearFields();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }
    public void clearFields(){
        lblEmpId.setText("");
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
        //var model = new EmployeeModel();

        ObservableList<EmployeeDto>obList = FXCollections.observableArrayList();
        try{
            List<EmployeeDto>dtoList = employeeBO.getAllEmployee();
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

        try {
            List<String> dataFromDB = employeeBO.getCmbUserId();
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
   void updateButtonOnAction(ActionEvent event) throws IOException {

       URL resource = this.getClass().getResource("/view/updateEmployeeform.fxml");
       FXMLLoader fxmlLoader = new FXMLLoader(resource);
       Parent load = fxmlLoader.load();
       Stage stage = new Stage();
       stage.setTitle("Update employee");
       stage.setScene(new Scene(load));
       stage.centerOnScreen();
       stage.initModality(Modality.APPLICATION_MODAL);

       stage.setResizable(false);
       stage.show();
   }

    @FXML
    void deleteButtonOnAction(ActionEvent event) throws IOException {

        URL resource = this.getClass().getResource("/view/deleteEmployeeform.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent load = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Update employee");
        stage.setScene(new Scene(load));
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setResizable(false);
        stage.show();
    }
    private  boolean validateEmployee(){
        String id = lblEmpId.getText();
        boolean isIdValid = Pattern.matches("[E][0-9]{3,}",id);
        if (!isIdValid){
            new Alert(Alert.AlertType.ERROR,"Invalid employee id").show();
            return false;
        }

        String name = txtName.getText();
        boolean isNameValid = Pattern.matches("[A-Za-z]{5,}",name);
        if(!isNameValid){
            new Alert(Alert.AlertType.ERROR,"Invalid employee name").show();
            return  false;
        }

        String address = txtAddress.getText();
        boolean isAddressValid = Pattern.matches("[A-Za-z]{9,}",address);
        if (isAddressValid){
            new Alert(Alert.AlertType.ERROR,"Invalid address").show();
            return false;
        }

        String tel = txtTel.getText();
        boolean isTelValid = Pattern.matches("[0][7]{8}",tel);
        if(isTelValid){
            new Alert(Alert.AlertType.ERROR,"Invalid phone number").show();
            return  false;
        }

        return  true;
    }
    private String generateEmployeeId(){
        String empId = null;
        try {
            empId= employeeBO.getGenerateEmployeeId();
            lblEmpId.setText(empId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

        return empId;
    }
}
