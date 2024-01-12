package lk.ijse.yummy_food_project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;


import lk.ijse.yummy_food_project.DAO.Custom.Impl.OrderDetailDAOImpl;
import lk.ijse.yummy_food_project.DAO.QueryDAO;
import lk.ijse.yummy_food_project.dto.PlaceDto;
import lk.ijse.yummy_food_project.dto.tm.PlaceTm;


public class PlaceOderFormController {
    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colPaymentId;
    @FXML
    private TableColumn<?, ?> colDate;



    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableColumn<?, ?> colTime;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<PlaceDto> tblPlaceOrder;


    @FXML

    private Button addBtn;

    OrderDetailDAOImpl orderDetailDAO = new OrderDetailDAOImpl();
    QueryDAO queryDAO = new QueryDAO();

    @FXML
    void backOnButtonAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Ingredients Manage");
        stage.centerOnScreen();
    }
    @FXML
    void saveOnButtonAction(ActionEvent event) {

    }

    @FXML
    void addOrderButtonOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/orderForm.fxml");
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
    public void initialize() {
        setCellValueFactory();
        loadAllPlaceOrder();

    }
    private void setCellValueFactory() {
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("or_id"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colPaymentId.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
    }

    private void loadAllPlaceOrder(){

        ObservableList<PlaceDto> obList = FXCollections.observableArrayList();

        try{
            List<PlaceDto> dtoList = queryDAO.getAllPlaceOrder();

            for (PlaceDto dto : dtoList){
                obList.add(
                        new PlaceTm(
                                dto.getOr_id(),
                                dto.getCustomerId(),
                                dto.getCustomerName(),
                                dto.getPaymentId(),
                                dto.getDate(),
                                dto.getTime(),
                                dto.getAmount()
                        )
                );
            }
            tblPlaceOrder.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
