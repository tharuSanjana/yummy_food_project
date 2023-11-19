package lk.ijse.yummy_food_project;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class AppInitializer  extends Application {
    public static void main(String[] args) {
        launch(args);
    }
@Override
   public void start(Stage stage) throws Exception{
       stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/loginForm.fxml"))));
       stage.centerOnScreen();
       stage.setTitle("Login");

       stage.show();
   }

}
