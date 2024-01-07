package lk.ijse.yummy_food_project.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import lk.ijse.yummy_food_project.dto.tm.PlaceIngredientsTm;
import lk.ijse.yummy_food_project.DAO.BoFactory;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.IngredientsDAOImpl;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.SupIngDAOImpl;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.SupplierDAOImpl;
import lk.ijse.yummy_food_project.bo.Custom.FoodBO;
import lk.ijse.yummy_food_project.bo.Custom.IngredientsBO;
import lk.ijse.yummy_food_project.bo.Custom.SupIngBO;
import lk.ijse.yummy_food_project.bo.Custom.SupplierBO;
import lk.ijse.yummy_food_project.dto.*;
import lk.ijse.yummy_food_project.dto.tm.SupIngTm;
import lk.ijse.yummy_food_project.dto.tm.ViewSupIngTm;
import lk.ijse.yummy_food_project.entity.Supplier;
import lk.ijse.yummy_food_project.model.IngredientsModel;
import lk.ijse.yummy_food_project.model.SupModel;
import lk.ijse.yummy_food_project.model.SupplierModel;

public class SupIngFormController {

    @FXML
    private ComboBox<String> cmbIng;

    @FXML
    private ComboBox<String> cmbSupId;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colIngId;

    @FXML
    private TableColumn<?, ?> colIngName;

    @FXML
    private CheckBox checkBoxPaid;
    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<SupIngTm, String> colSupId;

    @FXML
    private TableColumn<?, ?> colSupName;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitePrice;

    @FXML
    private Label lblIngName;

    @FXML
    private Label lblIngPrice;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label lblPaymentId;

    @FXML
    private Label lblQty;

    @FXML
    private Label lblSupName;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<SupIngTm> tblSupIng;

    @FXML
    private Button btnCancel;

    private IngredientsModel ingModel = new IngredientsModel();

    private SupplierModel supModel = new SupplierModel();
    private ObservableList<SupIngTm> obList = FXCollections.observableArrayList();
    private ObservableList<ViewSupIngTm> viList = FXCollections.observableArrayList();
    private SupModel sModel = new SupModel();
    IngredientsBO ingredientsBO = (IngredientsBO) BoFactory.boFactory().getBoTypes(BoFactory.BOTypes.INGREDIENTS);
   SupplierBO supplierBO = (SupplierBO) BoFactory.boFactory().getBoTypes(BoFactory.BOTypes.SUPPLIER);
    SupIngBO supIngBO = (SupIngBO) BoFactory.boFactory().getBoTypes(BoFactory.BOTypes.SUP_ING);


    @FXML
    void addButtonOnAction(ActionEvent event) {
        String pId = lblPaymentId.getText();
        String sId = cmbSupId.getValue();
        System.out.println("supId" + cmbSupId.getValue());
        String supName = lblSupName.getText();
        String ingId = cmbIng.getValue();
        String ingName = lblIngName.getText();
        double qty = Double.parseDouble(lblQty.getText());
        double unitPrice = Double.parseDouble(lblIngPrice.getText());
        double total = unitPrice * qty;
        Button btn = new Button("Remove");

        setRemoveBtnAction(btn);
        btn.setCursor(Cursor.HAND);
        if (!obList.isEmpty()) {
            for (int i = 0; i < tblSupIng.getItems().size(); i++) {
                if (colIngId.getCellData(i).equals(pId)) {
                    double col_qty = (double) colQty.getCellData(i);
                    qty += col_qty;
                    total = unitPrice * qty;
                    //  obList.get(i).setsId(sId);

                    obList.get(i).setQty(qty);
                    obList.get(i).setTotal(total);

                    calculateTotal();
                    tblSupIng.refresh();
                    return;
                }
            }
        }
        var supIngTm = new SupIngTm(supName, ingId, ingName, qty, unitPrice, total, btn);

        obList.add(supIngTm);

        tblSupIng.setItems(obList);
        calculateTotal();
        tblSupIng.refresh();
        // lblQty.clear();
    }

    private void setRemoveBtnAction(Button btn) {
        btn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

            if (type.orElse(no) == yes) {
                int focusedIndex = tblSupIng.getSelectionModel().getSelectedIndex();

                obList.remove(focusedIndex + 1);
                tblSupIng.refresh();
                //calculateTotal();
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

    public void initialize() {
        populateComboBoxSupplier();
        populateComboBoxIng();
        setCellValueFactory();
    }


    @FXML
    void checkBoxOnAction(ActionEvent event) {

    }

    @FXML
    void cmbSupplierOnAction(ActionEvent event) {
        String supId = cmbSupId.getValue();
        try {
            Supplier sup = supplierBO.searchSupplierId(supId);
            lblSupName.setText(sup.getName());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void saveButtonOnAction(ActionEvent event) {
        boolean isChecked = checkBoxPaid.isSelected();
        if (!isChecked) {
            new Alert(Alert.AlertType.ERROR, "Please pay!").show();

        } else {
            String supId = cmbSupId.getValue();
            String ingId = cmbIng.getValue();
            String supName = lblSupName.getText();
            String ingName = lblIngName.getText();
            double total = Double.parseDouble(lblNetTotal.getText());
            String pId = lblPaymentId.getText();

            var viewDto = new ViewSupIngDto(supId, ingId, supName, ingName, total, pId);

            try {
                boolean flag = supIngBO.saveSupIng(viewDto);

                if (flag) {
                    new Alert(Alert.AlertType.CONFIRMATION, "supIng saved!").show();

                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }





    public void populateComboBoxSupplier() {

        try {
            List<String> dataFromDB = supplierBO.getCmbSupId();
            ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
            cmbSupId.setItems(observableData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void cmbIngOnAction(ActionEvent event) {
        String ingId =  cmbIng.getValue();
        try {
            IngredientsDto ingDto = ingredientsBO.searchIngredientId(ingId);
            lblIngName.setText(ingDto.getName());
            lblIngPrice.setText(String.valueOf(ingDto.getPrice()));
            lblQty.setText(String.valueOf(ingDto.getPrice()));
            lblPaymentId.setText(ingDto.getpId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void populateComboBoxIng() {
        List<String> dataFromDB = ingredientsBO.getCmbIngId();
        ObservableList<String> observableData = FXCollections.observableArrayList(dataFromDB);
        cmbIng.setItems(observableData);

    }
    public void setCellValueFactory(){
        //colPId.setCellValueFactory(new PropertyValueFactory<>("pId"));

        //colSupId.setCellValueFactory(new PropertyValueFactory<>("sId"));
        colSupName.setCellValueFactory(new PropertyValueFactory<>("supName"));
        colIngId.setCellValueFactory(new PropertyValueFactory<>("indId"));
        colIngName.setCellValueFactory(new PropertyValueFactory<>("ingName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitePrice.setCellValueFactory(new PropertyValueFactory<>("unitePrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }
    @FXML
    void cancelButtonOnAction(ActionEvent event) {
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
    }


