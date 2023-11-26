package lk.ijse.yummy_food_project.model;

import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    public UserDto searchUserId(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user WHERE user_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        ResultSet resultSet = pstm.executeQuery();

        UserDto userDto = null;

        if(resultSet.next()){
            userDto = new UserDto(
                    resultSet.getString(1),
                    resultSet.getString(2)
                    //resultSet.getString(3)

            );
        }
        return  userDto;
    }
}
