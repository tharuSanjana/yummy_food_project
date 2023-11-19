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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

import javafx.stage.Modality;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.yummy_food_project.dto.FoodDto;
import lk.ijse.yummy_food_project.dto.tm.FoodTm;
import lk.ijse.yummy_food_project.model.MenuModel;


public class MenuFormController {
    @FXML
    private TableColumn<?, ?> colDes;

    @FXML
    private TableColumn<?, ?> colFoodId;

    @FXML
    private TableColumn<?, ?> colFoodName;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<FoodDto> tblMenu;



    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Dashboard Manage");
        stage.centerOnScreen();
    }

    public void addButtonOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/addMenuform.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent load = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add menu");
        stage.setScene(new Scene(load));
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setResizable(false);
        stage.show();
    }

    public void initialize(){

        setCellValueFactory();
        loadAllFood();
    }

    public void setCellValueFactory(){
        colFoodId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFoodName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDes.setCellValueFactory(new PropertyValueFactory<>("desc"));
    }

    public void loadAllFood() {
        var model = new MenuModel();

        ObservableList<FoodDto> obList = FXCollections.observableArrayList();


            try {
                List<FoodDto> dtoList = model.getAllFood();
                for (FoodDto dto : dtoList) {
                    obList.add(
                            new FoodTm(
                                    dto.getId(),
                                    dto.getName(),
                                    dto.getPrice(),
                                    dto.getDesc())
                    );
                }
                tblMenu.setItems(obList);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }



