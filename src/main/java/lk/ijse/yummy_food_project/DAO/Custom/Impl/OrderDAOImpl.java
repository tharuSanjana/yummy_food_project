package lk.ijse.yummy_food_project.DAO.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.Custom.OrderDAO;
import lk.ijse.yummy_food_project.DAO.SqlUtil;
import lk.ijse.yummy_food_project.entity.Order;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    SqlUtil s = new SqlUtil();
    @Override
    public List<String> getCmbCusId() throws SQLException {

        List<String> customerId = new ArrayList<>();
        try {
            String sql = "SELECT cus_id FROM customer";
            ResultSet resultSet = s.test(sql);
            while (resultSet.next()) {
                customerId.add(resultSet.getString("cus_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerId;
    }


    public List<String> getCmbFoodId() throws SQLException {

        List<String> foodId = new ArrayList<>();
        try {
            String sql = "SELECT food_id FROM food";
            ResultSet resultSet = s.test(sql);

            while (resultSet.next()) {
                foodId.add(resultSet.getString("food_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return foodId;
    }

    public List<String> getCmbEmployeeId() throws SQLException {

         List<String> driverEmpIds = new ArrayList<>();
       try{
           String sql = "SELECT emp_id FROM employee WHERE emp_type = 'Driver'";
            ResultSet resultSet = s.test(sql);

            while (resultSet.next()) {
                String empId = resultSet.getString("emp_id");
                driverEmpIds.add(empId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driverEmpIds;
    }

    public String getGenerateOrderId() throws SQLException {
        String sql = "SELECT or_id FROM orders ORDER BY or_id DESC LIMIT 1";
        ResultSet resultSet = s.test(sql);
        if(resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);


    }

    private String splitOrderId(String currentOrderId) {

        if(currentOrderId!= null) {
            String[] split = currentOrderId.split("O0");

            int id = Integer.parseInt(split[1]);
            id++;
            if (id<10){
                return "O00" + id;}
            else {
                return "O0"+id;
            }
        } else {
            return "O001";
        }
    }


    public boolean SaveOrder(String orId, LocalDate date, String orderType, LocalTime time, String pId, String empId, String cusId) throws SQLException {
        String sql = "INSERT INTO orders VALUES(?, ?, ?,?,?,?,?)";
        Boolean test = s.test(sql, orId, Date.valueOf(date), orderType, String.valueOf(Time.valueOf(time)), pId, empId, cusId);

        return test;
    }

    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Order dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Order dto) throws SQLException, ClassNotFoundException {
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
    public Order search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getCmbId() throws SQLException {
        return null;
    }
}
