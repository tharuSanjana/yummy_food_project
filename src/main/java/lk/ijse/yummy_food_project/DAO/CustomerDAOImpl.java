package lk.ijse.yummy_food_project.DAO;

import lk.ijse.yummy_food_project.SqlUtil;
import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl {
    SqlUtil s = new SqlUtil();
    List<String> ids = new ArrayList<>();
    public ArrayList<CustomerDto> getAllCustomer() throws SQLException {
        String sql = "SELECT * FROM customer";

        ResultSet resultSet = s.test(sql);

        ArrayList<CustomerDto> dtoList = new ArrayList<>();

        while (resultSet.next()){
            CustomerDto customerDto = new CustomerDto(resultSet.getString(1),resultSet.getString(2), resultSet.getString(3),resultSet.getString(4), resultSet.getString(5));
            dtoList.add(customerDto);
        }
        return dtoList;
    }
    public boolean saveCustomer(CustomerDto dto) throws SQLException {
       String sql = "INSERT INTO customer VALUES(?,?,?,?,?)";
        Boolean test = s.test(sql, dto.getId(), dto.getName(), dto.getAddress(), dto.getTel(), dto.getUserId());

        return test;

    }

    public boolean updateCustomer(CustomerDto dto) throws SQLException {
        String sql = "UPDATE customer SET name = ? ,address = ? ,tel = ? ,user_id = ? WHERE cus_id = ?";
        Boolean test = s.test(sql, dto.getName(), dto.getAddress(), dto.getTel(), dto.getUserId(), dto.getId());
        return test;

    }
    public boolean deleteCustomer(String id) throws SQLException {

        String sql = "DELETE FROM customer WHERE cus_id = ?";
        Boolean test = s.test(sql,id);

        return test;
    }
    public CustomerDto searchCustomerId(String cusId) throws SQLException {
        String sql = "SELECT * FROM customer WHERE cus_id = ?";
        ResultSet resultSet = s.test(sql, cusId);

        CustomerDto cusDto = null;

        if(resultSet.next()){
            cusDto = new CustomerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        }
        return  cusDto;
    }

    public String getGenerateCustomerId() throws SQLException {
       String sql = "SELECT cus_id FROM customer ORDER BY cus_id DESC LIMIT 1";
        ResultSet resultSet = s.test(sql);

        if(resultSet.next()) {
            return splitCustomerId(resultSet.getString(1));
        }
        return splitCustomerId(null);

    }
    private String splitCustomerId(String currentCustomerId) {
        if(currentCustomerId!= null) {
            String[] split = currentCustomerId.split("C0");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "C00" + id;
        } else {
            return "C001";
        }
    }

    public List<String> getCmbUserId() throws SQLException {

        try {
            String sql = "SELECT user_id FROM user";
            ResultSet resultSet = s.test(sql);

            while (resultSet.next()) {
                ids.add(resultSet.getString("user_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ids;
    }
    public List<String> getCmbCustomerId(){

        try {

            String sql = "SELECT cus_id FROM customer";
            ResultSet resultSet = s.test(sql);

            while (resultSet.next()) {
                ids.add(resultSet.getString("cus_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ids;
    }

}
