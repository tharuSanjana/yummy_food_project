package lk.ijse.yummy_food_project.bo.Custom;

import lk.ijse.yummy_food_project.DAO.SuperBO;
import lk.ijse.yummy_food_project.dto.CustomerDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerBO extends SuperBO {
    ArrayList<CustomerDto> getAllCustomer() throws SQLException;

     boolean saveCustomer(CustomerDto dto) throws SQLException;
    boolean updateCustomer(CustomerDto dto) throws SQLException;
    boolean deleteCustomer(String id) throws SQLException;
    CustomerDto searchCustomerId(String cusId) throws SQLException;
    String getGenerateCustomerId() throws SQLException;
    List<String> getCmbUserId() throws SQLException;
    List<String> getCmbCustomerId();
}
