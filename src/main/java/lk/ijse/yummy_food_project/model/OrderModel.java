package lk.ijse.yummy_food_project.model;

import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.CustomerDto;
import lk.ijse.yummy_food_project.dto.OrderDto;
import lk.ijse.yummy_food_project.dto.PlaceOrderDto;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderModel {
    public List<String> getCmbCusId() throws SQLException {
        Connection connection = null;
        List<String> customerId = new ArrayList<>();
        String query = "SELECT cus_id FROM customer";

        try {
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                customerId.add(resultSet.getString("cus_id"));
            }
        } finally {

            if (connection != null) {
                // connection.close();
            }
        }

        return customerId;
    }


    public List<String> getCmbFoodId() throws SQLException {
        Connection connection = null;
        List<String> foodId = new ArrayList<>();
        String query = "SELECT food_id FROM food";

        try {
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                foodId.add(resultSet.getString("food_id"));
            }
        } finally {

            if (connection != null) {
                // connection.close();
            }
        }

        return foodId;
    }

    public List<String> getCmbEmployeeId() throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
            List<String> driverEmpIds = new ArrayList<>();
            String query = "SELECT emp_id FROM employee WHERE emp_type = 'Driver'";

            try (//Connection connection = DbConnection.getInstance().getConnection();
                 PreparedStatement pstm = connection.prepareStatement(query);
                 ResultSet resultSet = pstm.executeQuery()) {

                while (resultSet.next()) {
                    String empId = resultSet.getString("emp_id");
                    driverEmpIds.add(empId);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return driverEmpIds;
        }
    public boolean saveOrder(OrderDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO orders VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        java.sql.Time sqlTime = java.sql.Time.valueOf(dto.getTime());

        pstm.setString(1, dto.getId());
        pstm.setString(2, String.valueOf(dto.getDate()));
        pstm.setString(3, dto.getOrderType());
        pstm.setString(4, String.valueOf(sqlTime));
        pstm.setString(5,dto.getCusId());
        pstm.setString(6, dto.getEmpId());
        boolean flag = pstm.executeUpdate() > 0;
        return flag;
    }

   /* public boolean placeOrder(OrderDto oDto){
        String oId = oDto.getId();
        LocalDate date = oDto.getDate();
        String type = oDto.getOrderType();
        LocalTime time = oDto.getTime();
        String cusId = oDto.getCusId();
        String empId = oDto.getEmpId();
    }*/

    public String getGenerateOrderId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT or_id FROM orders ORDER BY or_id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);


    }

    private String splitOrderId(String currentOrderId) {
        if(currentOrderId != null) {
            String[] split = currentOrderId.split("O0");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "O00" + id;
        } else {
            return "O001";
        }
    }

  /*  public ArrayList<OrderDto> getAllOrders() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM orders";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<OrderDto> dtoList = new ArrayList<>();

        while (resultSet.next()){
            dtoList.add(
                    new OrderDto(resultSet.getString(1),
                            resultSet.getDate(2).toLocalDate(),
                            resultSet.getString(3),
                            resultSet.getTime(4).toLocalTime(),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        return dtoList;

    }*/
    public boolean SaveOrder(String orId,LocalDate date,String orderType,LocalTime time,String pId,String empId,String cusId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO orders VALUES(?, ?, ?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, orId);
        pstm.setDate(2, Date.valueOf(date));
        pstm.setString(3,orderType);
        pstm.setString(4, String.valueOf(Time.valueOf(time)));
        pstm.setString(5,pId);
        pstm.setString(6,empId);
        pstm.setString(7,cusId);


        return pstm.executeUpdate() > 0;
    }

}
