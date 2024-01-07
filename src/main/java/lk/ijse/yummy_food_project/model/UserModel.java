package lk.ijse.yummy_food_project.model;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.UserDto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserModel {


    /*public static boolean checkUsernamePw(UserDto dto) throws SQLException {
        boolean flag = false;
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM user";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();



        while(resultSet.next()) {

            if(resultSet.getString(2).equals(dto.getUser_id())&&resultSet.getString(3).equals(dto.getUsername())){
                 flag= true;
            }else{
                 flag = false;

            }


        }
        return flag;

    }

  /*  public static String setCmbUserId() throws SQLException {
        String userId = null;
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()){
             userId = resultSet.getString("userId");

        }
       return userId;
    }*/

  }






