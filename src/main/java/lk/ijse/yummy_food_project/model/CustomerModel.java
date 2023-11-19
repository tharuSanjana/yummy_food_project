package lk.ijse.yummy_food_project.model;

import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.CustomerDto;

import java.sql.*;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CustomerModel {
public ArrayList<CustomerDto> getAllCustomer() throws SQLException {
    Connection connection= DbConnection.getInstance().getConnection();

    String sql = "SELECT * FROM customer";
    PreparedStatement pstm = connection.prepareStatement(sql);
    ResultSet resultSet = pstm.executeQuery();

    ArrayList<CustomerDto> dtoList = new ArrayList<>();

    while (resultSet.next()){
        dtoList.add(
                new CustomerDto(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                )
        );
    }
    return dtoList;
}
public boolean saveCustomer(CustomerDto dto) throws SQLException {
    Connection connection = DbConnection.getInstance().getConnection();

    String sql = "INSERT INTO customer VALUES(?,?,?,?,?)";
    PreparedStatement pstm = connection.prepareStatement(sql);

    pstm.setString(1, dto.getId());
    pstm.setString(2, dto.getName());
    pstm.setString(3, dto.getAddress());
    pstm.setString(4, dto.getTel());
    pstm.setString(5,dto.getUserId());
    boolean flag = pstm.executeUpdate() > 0;
    return flag;
}

public boolean updateCustomer(CustomerDto dto) throws SQLException {
    Connection connection = DbConnection.getInstance().getConnection();

    String sql = "UPDATE customer SET name = ? ,address = ? ,tel = ? ,user_id = ? WHERE cus_id = ?";
    PreparedStatement pstm = connection.prepareStatement(sql);

    pstm.setString(1,dto.getName());
    pstm.setString(2,dto.getAddress());
    pstm.setString(3,dto.getTel());
    pstm.setString(4,dto.getUserId());
    pstm.setString(5,dto.getId());

    return pstm.executeUpdate() > 0;

}
public boolean deleteCustomer(String id) throws SQLException {
    Connection connection = DbConnection.getInstance().getConnection();
    String sql = "DELETE FROM customer WHERE cus_id = ?";
    PreparedStatement pstm = connection.prepareStatement(sql);
    pstm.setString(1,id);
    return pstm.executeUpdate() > 0;
}
public CustomerDto searchCustomerId(String cusId) throws SQLException {
    Connection connection = DbConnection.getInstance().getConnection();
    String sql = "SELECT * FROM customer WHERE cus_id = ?";
    PreparedStatement pstm = connection.prepareStatement(sql);
    pstm.setString(1,cusId);
    ResultSet resultSet = pstm.executeQuery();

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

}