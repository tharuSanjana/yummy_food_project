package lk.ijse.yummy_food_project.model;

import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.FoodDto;
import lk.ijse.yummy_food_project.dto.tm.CartTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuModel {
    public ArrayList<FoodDto> getAllFood() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM food";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        ArrayList<FoodDto> dtoList = new ArrayList<>();

        while(resultSet.next()){
            dtoList.add(
                    new FoodDto(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getDouble(3),
                            resultSet.getString(4))
            );

        }
        return dtoList;
    }

    public FoodDto searchFood(String foodId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM food WHERE food_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, foodId);

        ResultSet resultSet = pstm.executeQuery();

        FoodDto dto = null;

        if(resultSet.next()) {
            dto = new FoodDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4)
            );
        }
        return dto;
    }
    public  boolean updateMenu(FoodDto foodDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE food SET description = ?, price = ?, name = ? WHERE food_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, foodDto.getDesc());
        pstm.setDouble(2, foodDto.getPrice());
        pstm.setString(3, foodDto.getName());
        pstm.setString(4, foodDto.getId());

        return pstm.executeUpdate() > 0;
    }
   /* public boolean updateItem(List<CartTm> cartTmList) throws SQLException {
        for(CartTm tm : cartTmList) {
            System.out.println("Food: " + tm);
            if(!updateQty(tm.getFoodId(), tm.getQty())) {
                return false;
            }
        }
        return true;
    }
    public boolean updateQty(String code, int qty) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE food SET qty_on_hand = qty_on_hand - ? WHERE code = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setInt(1, qty);
        pstm.setString(2, code);

        return pstm.executeUpdate() > 0; //false
    }*/
}
