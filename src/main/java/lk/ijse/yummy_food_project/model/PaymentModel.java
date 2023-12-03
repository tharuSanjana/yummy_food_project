package lk.ijse.yummy_food_project.model;

import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.CostPaymentDto;
import lk.ijse.yummy_food_project.dto.incomePaymentDto;
import lk.ijse.yummy_food_project.dto.tm.CostPaymentTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<String> getCmbPId() {
        Connection connection = null;
        List<String> pIds = new ArrayList<>();
        String query = "SELECT p_id FROM payment";

        try {
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                pIds.add(resultSet.getString("p_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            if (connection != null) {
                // connection.close();
            }
        }

        return pIds;
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

