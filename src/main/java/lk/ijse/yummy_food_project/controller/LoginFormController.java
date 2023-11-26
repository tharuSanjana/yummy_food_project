package lk.ijse.yummy_food_project.controller;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import javafx.scene.control.Button;
import lk.ijse.yummy_food_project.dto.UserDto;
import lk.ijse.yummy_food_project.model.CustomerModel;
import lk.ijse.yummy_food_project.model.UserModel;

import javafx.scene.control.TextField;

//import static jdk.tools.jlink.internal.plugins.PluginsResourceBundle.getMessage;

public class LoginFormController {
    @FXML
    private AnchorPane root;
    @FXML
    private Button login;
    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;
    private CustomerModel cusModel = new CustomerModel();


    @FXML
    void loginButtonOnAction(ActionEvent event) throws IOException, SQLException {
        String username= txtUserName.getText();
        String pw = txtPassword.getText();
      //  String userId = txtUserId.getText();
        UserDto dto = new UserDto(username,pw);


        boolean flag=UserModel.checkUsernamePw(dto);

       // boolean flag;
        if(flag==true) {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Customer Manage");
            stage.centerOnScreen();
        }else{
            new Alert(Alert.AlertType.ERROR,"username or password incorrect").show();
        }
       //String cusId = cusModel.getUserId(pw);

    }
    @FXML
    void registrationButtonOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/registerForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Users Manage");
        stage.centerOnScreen();
    }

}




