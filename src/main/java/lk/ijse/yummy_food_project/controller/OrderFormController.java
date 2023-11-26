package lk.ijse.yummy_food_project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import lk.ijse.yummy_food_project.dto.CustomerDto;
import lk.ijse.yummy_food_project.dto.EmployeeDto;
import lk.ijse.yummy_food_project.dto.FoodDto;
import lk.ijse.yummy_food_project.dto.PlaceOrderDto;
import lk.ijse.yummy_food_project.dto.tm.CartTm;
import lk.ijse.yummy_food_project.model.*;

public class OrderFormController {
    @FXML
    private CheckBox checkBoxPaid;
    @FXML
    private ComboBox<String> cmbCustomerId;

    @FXML
    private ComboBox<String> cmbDriverId;

    @FXML
    private ComboBox<String> cmbFoodId;

    @FXML
    private ComboBox<String> cmbOrderType;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colFoodId;

    @FXML
    private TableColumn<?, ?> colFoodName;


    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTime;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private Label lblCusName;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblDriverName;

    @FXML
    private Label lblFoodName;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblTime;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<CartTm> tblOrder;

    @FXML
    private TextField txtQty;

    @FXML
    private TableColumn<?, ?> colDesc;

    @FXML
    private Label lblDes;

    @FXML
    private Label lblPaymentId;

    @FXML
    private Button btnCancel;

    private CustomerModel cusModel = new CustomerModel();
    private  OrderModel orderModel = new OrderModel();
    private EmployeeModel empModel = new EmployeeModel();
    private MenuModel menuModel = new MenuModel();
    private ObservableList<CartTm> obList = FXCollections.observableArrayList();
    private PlaceOrderModel placeOrderModel = new PlaceOrderModel();
    private PaymentModel pModel = new PaymentModel();

    public void initialize(){

        String oId=generateOrderId();
        lblOrderId.setText(oId);
        setCellValueFactory();
        setDate();
        setTime();
        String pId=generatePaymentId();
        lblPaymentId.setText(pId);
        setDataComboBox();
        populateComboBox();
       // cmbFoodId();
    }
    private String generatePaymentId(){
        String paymentId = null;
        try {
            paymentId = pModel.getGeneratePaymentId();
            lblPaymentId.setText(paymentId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

        return paymentId;
    }
    private void setCellValueFactory() {

        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colFoodId.setCellValueFactory(new PropertyValueFactory<>("foodId"));
        colFoodName.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }
    @FXML
    void cancelOnButtonAction(ActionEvent event) {
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










private void setDate(){
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    public void setTime(){
   // lblTime.setText(String.valueOf(LocalTime.now()));
    LocalTime currentTime = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String formattedTime = currentTime.format(formatter);
    lblTime.setText(formattedTime);
}

//}
public void populateComboBox() {

    try {

        List<String> customerIdsFromDB = orderModel.getCmbCusId();
        ObservableList<String> observableCustomerIds = FXCollections.observableArrayList(customerIdsFromDB);
        cmbCustomerId.setItems(observableCustomerIds);
    } catch (SQLException e) {
        e.printStackTrace();
    }

    try {

        List<String> foodIdsFromDB = orderModel.getCmbFoodId();
        ObservableList<String> observableFoodIds = FXCollections.observableArrayList(foodIdsFromDB);
        cmbFoodId.setItems(observableFoodIds);
    } catch (SQLException e) {
        e.printStackTrace();
    }

    try {

        List<String> foodIdsFromDB = orderModel.getCmbEmployeeId();
        ObservableList<String> observableFoodIds = FXCollections.observableArrayList(foodIdsFromDB);
        cmbDriverId.setItems(observableFoodIds);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    @FXML
    void newButtonOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/customerForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Customer Manage");
        stage.centerOnScreen();
    }

    @FXML
    void cmbCustomerOnAction(ActionEvent event) {
        String cusId = cmbCustomerId.getValue();
        try{
            CustomerDto cusDto = cusModel.searchCustomerId(cusId);
            lblCusName.setText(cusDto.getName());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbEmployeeOnAction(ActionEvent  event) throws SQLException {

        String empId = cmbDriverId.getValue();
        if(empId.isEmpty()){
           empId="noEmployee";
           // String driverName = empModel.emptyEmployeeId(empId);


        }else {
            try {
                String driverName = empModel.searchEmployeeId(empId);
                if (driverName != null) {
                    lblDriverName.setText(driverName);

                }

            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
        }
    }

    @FXML
    void cmbFoodOnAction(ActionEvent event) {
        String foodId = cmbFoodId.getValue();
        try{
            FoodDto dto = menuModel.searchFood(foodId);
            lblFoodName.setText(dto.getName());
            lblPrice.setText(String.valueOf(dto.getPrice()));
            lblDes.setText(dto.getDesc());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void addToCartButtonOnAction(ActionEvent event) {
        //String oId = lblOrderId.getText();
        LocalDate date = LocalDate.parse(lblDate.getText());
        LocalTime time = LocalTime.parse(lblTime.getText());
        String foodId = cmbFoodId.getValue();
        String foodName = lblFoodName.getText();
        double price = Double.parseDouble(lblPrice.getText());
        String desc = lblDes.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double total = price * qty;
        Button btn = new Button("Remove");

        setRemoveBtnAction(btn);
        btn.setCursor(Cursor.HAND);

        if (!obList.isEmpty()) {
            for (int i = 2; i < tblOrder.getItems().size(); i++) {
                if (colFoodId.getCellData(i).equals(foodId)) {
                    int col_qty = (int) colQty.getCellData(i);
                    qty += col_qty;
                    total = price * qty;

                    obList.get(i).setQty(qty);
                    obList.get(i).setTotal(total);

                    calculateTotal();
                    tblOrder.refresh();
                    return;
                }
            }
        }
        var cartTm = new CartTm( date, time, foodId, foodName, price,desc,qty,total,btn);

        obList.add(cartTm);

        tblOrder.setItems(obList);
        calculateTotal();
        txtQty.clear();

    }
    private void setRemoveBtnAction(Button btn) {
        btn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

            if (type.orElse(no) == yes) {
                int focusedIndex = tblOrder.getSelectionModel().getSelectedIndex();

                obList.remove(focusedIndex+1);
                tblOrder.refresh();
                calculateTotal();
            }
        });
    }
    private void calculateTotal() {
        double total = 0;
        for (int i = 0; i < tblOrder.getItems().size(); i++) {
            total += (double) colTotal.getCellData(i);
        }
        lblNetTotal.setText(String.valueOf(total));
    }
   // @FXML
   /* void placeOrderButtonOnAction(ActionEvent event) {
        String or_id = txtOrderId.getText();
        LocalDate date = LocalDate.parse(lblOrderDate.getText());
        String order_type = (String) cmbOrderType.getValue();
        LocalTime time = LocalTime.parse(lblTime.getText());
        String cus_id = cmbCustomerId.getValue();
        String emp_id = cmbDriverId.getValue();

      /* List<CartTm> cartTmList = new ArrayList<>();
        for (int i = 0; i < tblOrder.getItems().size(); i++) {

            CartTm cartTm = obList.get(i);

            cartTmList.add(cartTm);
        }

        System.out.println("Place order form controller: " + cartTmList);
        var oDto = new OrderDto(orderId, date, orderType,time,cusId,driverId, cartTmList);
        try {
            boolean isSuccess = OrderModel.placeOrder(oDto);
            if (isSuccess) {
                new Alert(Alert.AlertType.CONFIRMATION, "Order Success!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
      /*  var dto = new OrderDto(or_id,date,order_type,time,cus_id,emp_id);
        try{
            boolean flag = orderModel.saveOrder(dto);

            if(flag){
                new Alert(Alert.AlertType.CONFIRMATION, "order saved!").show();
                //clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }*/
   @FXML
   void cmbOrderTypeOnAction(ActionEvent event) {

   }

    public void placeOrderButtonOnAction(ActionEvent actionEvent) throws IOException {
        boolean isChecked = checkBoxPaid.isSelected();
        if (!isChecked) {
            new Alert(Alert.AlertType.ERROR, "Please pay to place the order!").show();
        }else{
        String oId = lblOrderId.getText();
        LocalDate date = LocalDate.parse(lblDate.getText());
        String orderType = cmbOrderType.getValue();
        LocalTime time = LocalTime.parse(lblTime.getText());
        String pId = lblPaymentId.getText();
        String empId = cmbDriverId.getValue();
        String cusId = cmbCustomerId.getValue();
       Double total= Double.valueOf(lblNetTotal.getText());

        List<CartTm> cartTmList = new ArrayList<>();
        for (int i = 0; i < tblOrder.getItems().size(); i++) {
            CartTm cartTm = obList.get(i);

            cartTmList.add(cartTm);

            System.out.println("Place order form controller: " + cartTmList);
            var placeOrderDto = new PlaceOrderDto(oId, date, orderType, time,pId, empId, cusId, cartTmList,total);

            try {
                boolean isSuccess = placeOrderModel.placeOrder(placeOrderDto);
                //System.out.println("Sanjana");
                if (isSuccess) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Order Success!").show();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        }
        /*String orderType = (String) cmbOrderType.getValue();
        String cusId = cmbCustomerId.getValue();
        String empId = cmbDriverId.getValue();

        List<CartTm> cartTmList = new ArrayList<>();

        for (int i = 0; i < tblOrder.getItems().size(); i++) {
            CartTm cartTm = obList.get(i);

            cartTmList.add(cartTm);
        }
        System.out.println("Place order form controller: " + cartTmList);
       var placeOrderDto = new PlaceOrderDto(orderType, cusId, empId, cartTmList);

        try {
            boolean isSuccess = OrderModel.placeOrder(placeOrderDto);
            if (isSuccess) {
                new Alert(Alert.AlertType.CONFIRMATION, "Order Success!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }

    private String generateOrderId(){
        String orderId = null;
        try {
             orderId = orderModel.getGenerateOrderId();
            lblOrderId.setText(orderId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

        return orderId;
    }

   /* private void loadAllOrder(){
       var model = new OrderModel();
       ObservableList<OrderTm> obList = FXCollections.observableArrayList();
       try{
           List<OrderDto> dtoList = model.getAllOrders();
           for(OrderDto dto:dtoList){
               obList.add(
                       new OrderTm(
                               dto.getId(),
                               dto.getDate(),
                               dto.getOrderType(),
                               dto.getTime(),
                               dto.getCusId(),
                               dto.getEmpId()

                       )
               );

           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }*/

    public  void setDataComboBox(){

        cmbOrderType.getItems().addAll("Delivery", "Dine-in","Take out");
        //cmbOrderType.setValue("Driver");

    }
    @FXML
    void paidCheckBoxOnAction(ActionEvent event) throws IOException {

        boolean isChecked = checkBoxPaid.isSelected();
        if (isChecked) {
            try {

                placeOrderButtonOnAction(event);
            } catch (IOException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        } else {

            new Alert(Alert.AlertType.ERROR,"please pay to order!").show();
        }
    }
}

