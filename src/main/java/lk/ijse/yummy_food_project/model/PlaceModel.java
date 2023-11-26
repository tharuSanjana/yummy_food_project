package lk.ijse.yummy_food_project.model;

import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.CustomerDto;
import lk.ijse.yummy_food_project.dto.PlaceDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceModel {
    public ArrayList<PlaceDto> getAllPlaceOrder() throws SQLException {
        Connection connection= DbConnection.getInstance().getConnection();
        String sql = "SELECT \n" +
                "orders.or_id,\n" +
                "customer.cus_id,\n" +
                "customer.name,\n" +
                "payment.p_id,\n" +
                "orders.date,\n" +
                "orders.time,\n" +
                "payment.amount\n" +
                "FROM\n" +
                "orders\n" +
                "JOIN customer ON orders.cus_id = customer.cus_id\n" +
                "JOIN payment ON orders.p_id  = payment.p_id;\n" +
                " \n";



        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<PlaceDto> dtoList = new ArrayList<>();

        while(resultSet.next()){
            dtoList.add(
                    new PlaceDto(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDate(5).toLocalDate(),
                            resultSet.getTime(6).toLocalTime(),
                            resultSet.getDouble(7)
                           // resultSet.getDouble(7)
                            )
            );
        }
        return dtoList;

    }
}
