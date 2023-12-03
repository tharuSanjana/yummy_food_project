package lk.ijse.yummy_food_project.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.ijse.yummy_food_project.dto.ViewSupIngDto;
import lk.ijse.yummy_food_project.dto.tm.ViewSupIngTm;
import lk.ijse.yummy_food_project.model.SupModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class ViewSupIngController {

    @FXML
    private TableColumn<?, ?> colIngId;

    @FXML
    private TableColumn<?, ?> colIngName;


    @FXML
    private TableColumn<?, ?> colSupId;

    @FXML
    private TableColumn<?, ?> colSupName;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private AnchorPane root;

    @FXML
    private TableColumn<?, ?> colPId;

    @FXML
    private TableView<ViewSupIngDto> tblSupIng;

//private SupModel model = new SupModel();

    public void initialize(){
        setCellValueFactory();
        loadAllSupIng();

    }
    @FXML
    void addOrderButtonOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/supIngForm.fxml");
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

    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(anchorPane);

        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Employee Manage");
        stage.centerOnScreen();
    }
    public void loadAllSupIng() {
        var model = new SupModel();

        ObservableList<ViewSupIngDto> obList = FXCollections.observableArrayList();


        try {
            List<ViewSupIngDto> dtoList = model.getAllSupIng();
            for (ViewSupIngDto dto : dtoList) {
                obList.add(
                        new ViewSupIngTm(
                                dto.getSupId(),
                                dto.getIngId(),
                                dto.getSupName(),
                                dto.getIngName(),
                                dto.getTotal(),
                                dto.getPId()
                        )
                );
            }
            tblSupIng.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
           // System.out.println("AAAAAAAAAAAAAA");
        }
    }
    public void setCellValueFactory(){
        colSupId.setCellValueFactory(new PropertyValueFactory<>("supId"));
        colIngId.setCellValueFactory(new PropertyValueFactory<>("ingId"));
        colSupName.setCellValueFactory(new PropertyValueFactory<>("supName"));
        colIngName.setCellValueFactory(new PropertyValueFactory<>("ingName"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colPId.setCellValueFactory(new PropertyValueFactory<>("PId"));
    }
}
