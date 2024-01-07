package lk.ijse.yummy_food_project.DAO.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.Custom.CustomerDAO;
import lk.ijse.yummy_food_project.DAO.SqlUtil;
import lk.ijse.yummy_food_project.dto.CustomerDto;
import lk.ijse.yummy_food_project.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    SqlUtil s = new SqlUtil();
    @Override
    public ArrayList<Customer> getAllCustomer() throws SQLException {
        String sql = "SELECT * FROM customer";
        ResultSet resultSet = s.test(sql);
        ArrayList<Customer> dtoList = new ArrayList<>();

        while (resultSet.next()){
            Customer customer = new Customer(resultSet.getString(1),resultSet.getString(2), resultSet.getString(3),resultSet.getString(4), resultSet.getString(5));
            dtoList.add(customer);
        }
        return dtoList;
    }
    @Override
    public boolean saveCustomer(Customer entity) throws SQLException {
       String sql = "INSERT INTO customer VALUES(?,?,?,?,?)";
        Boolean test = s.test(sql, entity.getId(), entity.getName(), entity.getAddress(), entity.getTel(), entity.getUserId());

        return test;

    }
    @Override
    public boolean updateCustomer(Customer entity) throws SQLException {
        String sql = "UPDATE customer SET name = ? ,address = ? ,tel = ? ,user_id = ? WHERE cus_id = ?";
        Boolean test = s.test(sql, entity.getName(), entity.getAddress(), entity.getTel(), entity.getUserId(), entity.getId());
        return test;

    }
    @Override
    public boolean deleteCustomer(String id) throws SQLException {

        String sql = "DELETE FROM customer WHERE cus_id = ?";
        Boolean test = s.test(sql,id);

        return test;
    }
    @Override
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
    @Override
    public String getGenerateCustomerId() throws SQLException {
       String sql = "SELECT cus_id FROM customer ORDER BY cus_id DESC LIMIT 1";
        ResultSet resultSet = s.test(sql);

        if(resultSet.next()) {
            return splitCustomerId(resultSet.getString(1));
        }
        return splitCustomerId(null);

    }

    private String splitCustomerId(String currentCustomerId) {
        if(currentCustomerId != null) {
            String[] split = currentCustomerId.split("C0");

            int id = Integer.parseInt(split[1]);
            id++;
            if (id<10){
                return "C00" + id;}
            else {
                return "C0"+id;
            }
        } else {
            return "C001";
        }
    }

    public List<String> getCmbUserId() throws SQLException {
        List<String> ids = new ArrayList<>();
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
    @Override
    public List<String> getCmbCustomerId(){
        List<String> ids = new ArrayList<>();
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

    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Customer dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Customer dto) throws SQLException, ClassNotFoundException {
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
    public Customer search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getCmbId() throws SQLException {
        return null;
    }
}
