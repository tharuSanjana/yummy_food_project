package lk.ijse.yummy_food_project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.yummy_food_project.dto.IngredientsDto;
import lk.ijse.yummy_food_project.dto.tm.IngredientsTm;
//import lk.ijse.yummy_food_project.dto.tm.PlaceIngredientsTm;
import lk.ijse.yummy_food_project.model.IngredientsModel;
import lk.ijse.yummy_food_project.model.PaymentModel;

public class SupIngFormController {
    @FXML
    private ComboBox<?> cmbIngId;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colIngId;

    @FXML
    private TableColumn<?, ?> colIngName;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private Label lblIngName;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label lblPaymentId;

    @FXML
    private Label lblSupName;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<IngredientsTm> tblSupIng;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    private PaymentModel pModel = new PaymentModel();
private IngredientsModel ingModel = new IngredientsModel();
    private ObservableList<IngredientsTm> obList = FXCollections.observableArrayList();

    public void cmbSupplierOnAction(ActionEvent actionEvent) {

    }

    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(anchorPane);

        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Employee Manage");
        stage.centerOnScreen();
    }

    public void cmbIngOnAction(ActionEvent actionEvent) {

    }

    public void addButtonOnAction(ActionEvent actionEvent) {

    }
   /* private String generatePaymentId(){
        String paymentId = null;
        try {
            paymentId = pModel.getGeneratePaymentId();
            lblPaymentId.setText(paymentId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

        return paymentId;
    }
    public void initialize(){
        generatePaymentId();
    }

    @FXML
    void addButtonOnAction(ActionEvent event) {
        String id = (String) cmbIngId.getValue();
        String name = lblIngName.getText();
        double qty = Double.parseDouble(txtQty.getText());
        double price = Double.parseDouble(txtPrice.getText());
        double total = price * qty;
        Button btn = new Button("Remove");

        setRemoveBtnAction(btn);
        btn.setCursor(Cursor.HAND);

        if (!obList.isEmpty()) {
            for (int i = 2; i < tblSupIng.getItems().size(); i++) {
                if (colIngId.getCellData(i).equals(colIngId)) {
                    int col_qty = (int) colQty.getCellData(i);
                    qty += col_qty;
                    total = qty * price;

                    obList.get(i).setQty((int) qty);
                    obList.get(i).setTotal(total);

                    calculateTotal();
                    tblSupIng.refresh();
                    return;
                }
            }
        }
        var ingTm = new PlaceIngredientsTm( id,name,qty, price,total,btn);

        obList.add(ingTm);

        tblSupIng.setItems(obList);
        calculateTotal();
        txtQty.clear();
    }
    private void setRemoveBtnAction(Button btn) {
        btn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();
            if (type.orElse(no) == yes) {
                int focusedIndex = tblSupIng.getSelectionModel().getSelectedIndex();
                this.obList.remove(focusedIndex+1);
                tblSupIng.refresh();

            }
        });
    }
    private void calculateTotal() {
        double total = 0;
        for (int i = 0; i < tblSupIng.getItems().size(); i++) {
            total += (double) colTotal.getCellData(i);
        }
        lblNetTotal.setText(String.valueOf(total));
    }

    @FXML
    void backButtonOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Supplier Manage");
        stage.centerOnScreen();
    }

  

    @FXML
    void saveButtonOnAction(ActionEvent event) {

    }

    @FXML
    void updateButtonOnAction(ActionEvent event) {

    }
    @FXML
    void cmbIngOnAction(ActionEvent event) {
        String ingId = (String) cmbIngId.getValue();
        try{
            IngredientsDto ingDto = ingModel.searchIngredients(ingId);
            lblIngName.setText(ingDto.getName());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    void cmbSupplierOnAction(ActionEvent event) {}*/
}
