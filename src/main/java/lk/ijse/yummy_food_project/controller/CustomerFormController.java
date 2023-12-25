package lk.ijse.yummy_food_project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

import lk.ijse.yummy_food_project.DAO.CustomerDAOImpl;
import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.CustomerDto;
import lk.ijse.yummy_food_project.dto.UserDto;
import lk.ijse.yummy_food_project.dto.tm.CustomerTm;
import lk.ijse.yummy_food_project.model.CustomerModel;
import lk.ijse.yummy_food_project.model.EmployeeModel;
import lk.ijse.yummy_food_project.model.LoginModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class CustomerFormController {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;
    @FXML

    private Button view;

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


    private TextField txtUserId;

    @FXML
    private Label lblId;

    @FXML
    private TableColumn<?, ?> colUserID;

    @FXML
    private ComboBox<String> cmbUserId;

    @FXML
    private Label lblUserId;

    private CustomerModel cusModel = new CustomerModel();
    private EmployeeModel empModel = new EmployeeModel();
    private LoginModel loginModel = new LoginModel();
    //private UserDto userDto = new UserDto();
    CustomerDAOImpl customerDAO = new CustomerDAOImpl();

    public void initialize() {
        populateComboBox();
        generateCustomerId();
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
       //var model = new CustomerModel();

        ObservableList<CustomerDto> obList = FXCollections.observableArrayList();

        try{
            List<CustomerDto> dtoList = customerDAO.getAllCustomer();

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
        boolean isCustomerValid = validateCustomer();
        if (isCustomerValid) {
            String id = lblId.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String tel = txtTel.getText();
            String userId = cmbUserId.getValue();

            var dto = new CustomerDto(id, name, address, tel, userId);

            try {
                boolean flag = customerDAO.saveCustomer(dto);

                if (flag) {
                    new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                    clearFields();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }
    private  boolean validateCustomer(){
        String id = lblId.getText();
        boolean isIdValid = Pattern.matches("[C][0-9]{3,}",id);
        if (!isIdValid){
            new Alert(Alert.AlertType.ERROR,"Invalid customer id").show();
            return false;
        }

        String name = txtName.getText();
        boolean isNameValid = Pattern.matches("[A-Za-z]{4,}",name);
        if(!isNameValid){
            new Alert(Alert.AlertType.ERROR,"Invalid customer name").show();
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
       /* String userId = cmbUserId.getText();
        boolean isUserIdValid = Pattern.matches("[U][0][0][0-9]{4,}",userId);
        if(isUserIdValid){
            new Alert(Alert.AlertType.ERROR,"Invalid user Id").show();
            return  false;
        }*/
        return true;
    }
    @FXML
    void updateButtonOnAction(ActionEvent event) throws IOException {
        /*boolean isCustomerValid = validateCustomer();
        if (isCustomerValid) {
            String id = txtId.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String tel = txtTel.getText();
            String userId = lblUserId.getText();

            var dto = new CustomerDto(id, name, address, tel, userId);
            try {
                boolean flag = cusModel.updateCustomer(dto);
                if (flag) {
                    new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
                    clearFields();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }*/
        URL resource = this.getClass().getResource("/view/updateCustomerform.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent load = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Update customer");
        stage.setScene(new Scene(load));
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setResizable(false);
        stage.show();
    }
        @FXML
        void deleteButtonOnAction (ActionEvent event) throws IOException {
           /* boolean isCustomerValid = validateCustomer();
            if (isCustomerValid) {
                String id = txtId.getText();

                try {
                    boolean flag = cusModel.deleteCustomer(id);
                    if (flag) {
                        new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
                    } else {
                        new Alert(Alert.AlertType.CONFIRMATION, "customer not deleted!").show();
                    }

                } catch (SQLException e) {
                    new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                }
            }*/
            URL resource = this.getClass().getResource("/view/deleteCustomerform.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(resource);
            Parent load = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Delete customer");
            stage.setScene(new Scene(load));
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.setResizable(false);
            stage.show();
        }
    private void clearFields() {
        lblId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtTel.setText("");
       // cmbUserId.setItems("");
    }




    @FXML
    void viewButtonOnAction(ActionEvent event) throws JRException, SQLException {
        InputStream resourceAsStream =
                getClass().getResourceAsStream("/report/viewCustomers.jrxml");

        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport compileReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint =
                JasperFillManager.fillReport(
                        compileReport, //compiled report
                        null,
                        DbConnection.getInstance().getConnection() //database connection
                );
        JasperViewer.viewReport(jasperPrint, false);
    }

    private String generateCustomerId(){
        String cusId = null;
        try {
            cusId = customerDAO.getGenerateCustomerId();
            lblId.setText(cusId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

        return cusId;
    }


        @FXML
        void cmbUserIdOnAction(ActionEvent event) {
            String userId = cmbUserId.getValue();
            try{
                UserDto userDto = loginModel.searchUserId(userId);
                lblUserId.setText(userDto.getUser_id());

            } catch (SQLException e) {
                throw new RuntimeException(e);
        }

    }

    public void populateComboBox() {

        try {
            List<String> dataFromDB = customerDAO.getCmbUserId();
            ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
            cmbUserId.setItems(observableData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
