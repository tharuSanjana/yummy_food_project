package lk.ijse.yummy_food_project.model;

import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.PaymentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PaymentModel {
    public String getGeneratePaymentId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT p_id FROM payment ORDER BY p_id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    private String splitOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("P0");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "P00" + id;
        } else {
            return "P001";
        }
    }

    public boolean savePayment(String pId, double total, LocalDate date) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO payment VALUES(?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, pId);
        pstm.setDouble(2, total);
        pstm.setString(3, String.valueOf(date));

        return pstm.executeUpdate() > 0;
    }

   /* public boolean savePayment(String pId, List<CartTm> cartTmList) throws SQLException {
        for (CartTm tm : cartTmList) {
            if (!savePayment(pId, tm)) {

            }
        }
        return false;
        }*/
   /* public ArrayList<PaymentDto> getAllPayment() throws SQLException {
        Connection connection= DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM payment";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<PaymentDto> dtoList = new ArrayList<>();

        while (resultSet.next()){
            dtoList.add(
                    new PaymentDto(resultSet.getString(1),
                            resultSet.getDouble(2),
                            resultSet.getDate(3).toLocalDate()
                    )
            );
        }
        return dtoList;

    }*/
   public ArrayList<PaymentDto> getAllPayment() throws SQLException {
       Connection connection= DbConnection.getInstance().getConnection();
       String sql = "SELECT\n" +
               "    o.p_id,\n" +
               "    p.amount,\n" +
               "    o.cus_id,\n" +
               "    c.name,\n" +
               "    o.date\n" +
               "FROM\n" +
               "    orders o\n" +
               "JOIN\n" +
               "    payment p ON o.p_id = p.p_id\n" +
               "JOIN\n" +
               "    customer c ON o.cus_id = c.cus_id;";



       PreparedStatement pstm = connection.prepareStatement(sql);
       ResultSet resultSet = pstm.executeQuery();

       ArrayList<PaymentDto> dtoList = new ArrayList<>();

       while(resultSet.next()){
           dtoList.add(
                   new PaymentDto(resultSet.getString(1),
                           resultSet.getDouble(2),
                           resultSet.getString(3),
                           resultSet.getString(4),
                           resultSet.getDate(5).toLocalDate()


                           // resultSet.getDouble(7)
                   )
           );
       }
       return dtoList;

   }

    }

