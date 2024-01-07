package lk.ijse.yummy_food_project.DAO.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.Custom.PaymentDAO;
import lk.ijse.yummy_food_project.DAO.SqlUtil;
import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.CostPaymentDto;
import lk.ijse.yummy_food_project.dto.incomePaymentDto;
import lk.ijse.yummy_food_project.dto.tm.CostPaymentTm;
import lk.ijse.yummy_food_project.entity.IncomePayment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    SqlUtil s = new SqlUtil();
    @Override
    public String getGeneratePaymentId() throws SQLException {

        String sql = "SELECT p_id FROM payment ORDER BY p_id DESC LIMIT 1";
        ResultSet resultSet = s.test(sql);

        if(resultSet.next()) {
            return splitPaymentId(resultSet.getString(1));
        }
        return splitPaymentId(null);
    }

    private String splitPaymentId(String currentPaymentId) {
        if(currentPaymentId != null) {
            String[] split = currentPaymentId.split("P0");

            int id = Integer.parseInt(split[1]);
            id++;
            if (id<10){
                return "P00" + id;}
            else {
                return "P0"+id;
            }
        } else {
            return "P001";
        }

    }


    public boolean savePayment(String pId, double total, LocalDate date) throws SQLException {
        String sql = "INSERT INTO payment VALUES(?,?,?)";
        Boolean test = s.test(sql, pId, total, String.valueOf(date));
        return test;
    }



    public List<String> getCmbPId() {

        List<String> pIds = new ArrayList<>();

        try {
            String sql = "SELECT p_id FROM payment";
            ResultSet resultSet = s.test(sql);

            while (resultSet.next()) {
                pIds.add(resultSet.getString("p_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pIds;
    }

    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(IncomePayment dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(IncomePayment dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getGenerate() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public IncomePayment search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getCmbId() throws SQLException {
        return null;
    }
    /*public ArrayList<incomePaymentDto> getAllIncomePayment() throws SQLException {
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

    }*/
    /*public ArrayList<CostPaymentDto> getAllCostPayment() throws SQLException {
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

    }*/
}
