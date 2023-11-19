package lk.ijse.yummy_food_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import lk.ijse.yummy_food_project.dto.FoodDto;
import lk.ijse.yummy_food_project.model.AddMenuModel;

import java.awt.*;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddMenuFormController {
    @FXML
    private TextArea txtAreaDesc;

    @FXML
    private TextField txtFoodId;

    @FXML
    private TextField txtFoodName;

    @FXML
    private TextField txtPrice;

    private AddMenuModel addMenuModel = new AddMenuModel();
    @FXML
   /* void okButtonOnAction(ActionEvent event) {
        String id = txtFoodId.getText();
        String name = txtFoodName.getText();
        double price = Double.parseDouble(txtPrice.getText());
        String des = txtAreaDesc.getText();

        var dto = new FoodDto(id,name,price,des);
if(dto.getId().isEmpty() || dto.getName().isEmpty() || dto.getPrice() == null || dto.getDesc().isEmpty()){
    new Alert(Alert.AlertType.ERROR,"Please fill all").show();
} else {
    try {
        boolean flag = addMenuModel.saveMenu(dto);
        if (flag) {
            new Alert(Alert.AlertType.CONFIRMATION, "food saved!").show();
            clearFields();
        }

    } catch (SQLException e) {
        new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
    }
}
    }*/


    void okButtonOnAction(ActionEvent event) {
        String id = txtFoodId.getText();
        String name = txtFoodName.getText();
        String priceText = txtPrice.getText();
        String des = txtAreaDesc.getText();

        if (id.isEmpty() || name.isEmpty() || priceText.isEmpty() || des.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill in all fields").show();
        } else {
            try {
                double price = Double.parseDouble(priceText);
                var dto = new FoodDto(id, name, price, des);

                boolean flag = addMenuModel.saveMenu(dto);
                if (flag) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Food saved!").show();
                    clearFields();
                }

            } catch (NumberFormatException e) {
                new Alert(Alert.AlertType.ERROR, "Invalid price format").show();
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }



    private void clearFields() {
        txtFoodName.setText("");
        txtFoodId.setText("");
        txtPrice.setText("");
        txtAreaDesc.setText("");
    }
    @FXML
    void updateButtonOnAction(ActionEvent event) {
        String id = txtFoodId.getText();
        String name = txtFoodName.getText();
        String priceText = txtPrice.getText();
        String des = txtAreaDesc.getText();

        if(id.isEmpty()||name.isEmpty()||priceText.isEmpty()||des.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please fill in all fields");
        }else {
            try {
                double price = Double.parseDouble(priceText);
                var dto = new FoodDto(id, name, price, des);

                boolean flag = addMenuModel.updateMenu(dto);
                if (flag) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Food updated!").show();
                    clearFields();
                }
            } catch (NumberFormatException e) {
                new Alert(Alert.AlertType.ERROR, "Invalid price format").show();
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            }

        }
    }
    @FXML
    void deleteButtonOnAction(ActionEvent event) {
        String id = txtFoodId.getText();
        if (id.isEmpty()) {
                new Alert(Alert.AlertType.ERROR,"Please fill in all fields!").show();
        } else {
            try {
                boolean flag = addMenuModel.deleteMenu(id);
                if (flag) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Food deleted!").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "food not deleted!").show();
            }
        }
    }
}
