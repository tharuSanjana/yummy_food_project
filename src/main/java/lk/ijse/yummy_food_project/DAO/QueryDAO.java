package lk.ijse.yummy_food_project.DAO;

import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.CostPaymentDto;
import lk.ijse.yummy_food_project.dto.PlaceDto;
import lk.ijse.yummy_food_project.dto.incomePaymentDto;
import lk.ijse.yummy_food_project.dto.tm.CostPaymentTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAO {
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

    public ArrayList<incomePaymentDto> getAllIncomePayment() throws SQLException {
        Connection connection= DbConnection.getInstance().getConnection();
        String sql ="SELECT\n" +
                "    p.date,\n" +
                "    o.p_id,\n" +
                "    o.cus_id,\n" +
                "    c.name,\n" +
                "    p.amount\n" +
                "    \n" +
                "FROM\n" +
                "    customer c\n" +
                "JOIN\n" +
                "    orders o ON c.cus_id = o.cus_id\n" +
                "JOIN\n" +
                "    payment p ON o.p_id = p.p_id;";


        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<incomePaymentDto> dtoList = new ArrayList<>();

        while(resultSet.next()){
            dtoList.add(
                    new incomePaymentDto(resultSet.getDate(1).toLocalDate(),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDouble(5)


                            // resultSet.getDouble(7)
                    )
            );
        }
        return dtoList;

    }

    public ArrayList<CostPaymentDto> getAllCostPayment() throws SQLException {
        Connection connection= DbConnection.getInstance().getConnection();
        String sql ="SELECT\n" +
                "    p.date,\n" +
                "    sid.p_id,\n" +
                "    sid.sup_id,\n" +
                "    sid.sup_name,  \n" +
                "    sid.total\n" +
                "    \n" +
                "  \n" +
                "FROM\n" +
                "    supplier_ingredients_details sid\n" +
                "JOIN\n" +
                "    ingredients i ON sid.p_id = i.p_id\n" +
                "JOIN\n" +
                "    payment p ON sid.p_id = p.p_id;\n" +
                "\n" +
                "\n";


        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<CostPaymentDto> dtoList = new ArrayList<>();

        while(resultSet.next()){
            dtoList.add(
                    new CostPaymentTm(resultSet.getDate(1).toLocalDate(),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDouble(5)


                            // resultSet.getDouble(7)
                    )
            );
        }
        return dtoList;

    }
}
