package lk.ijse.yummy_food_project.model;

import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.FoodDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class AddMenuModel {
    /*public boolean saveMenu(FoodDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO food VALUES(?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setDouble(3, dto.getPrice());
        pstm.setString(4, dto.getDesc());

        return pstm.executeUpdate() > 0;

    }
    public boolean updateMenu(FoodDto dto) throws SQLException {
       Connection connection = DbConnection.getInstance().getConnection();
       String sql = "UPDATE food SET name = ?,price = ?,description = ? WHERE food_id = ?";
       PreparedStatement pstm = connection.prepareStatement(sql);

       pstm.setString(1,dto.getName());
       pstm.setDouble(2,dto.getPrice());
       pstm.setString(3,dto.getDesc());
       pstm.setString(4, dto.getId());

       return pstm.executeUpdate()>0;
    }
    public boolean deleteMenu(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM food WHERE food_id =?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        return pstm.executeUpdate()>0;
    }*/
}
