package lk.ijse.yummy_food_project.DAO.Custom;

import lk.ijse.yummy_food_project.DAO.CrudDAO;
import lk.ijse.yummy_food_project.dto.CustomerDto;
import lk.ijse.yummy_food_project.entity.Customer;
import lk.ijse.yummy_food_project.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerDAO extends CrudDAO<Customer> {
     ArrayList<Customer> getAllCustomer() throws SQLException;
     boolean saveCustomer(Customer entity) throws SQLException;
     boolean updateCustomer(Customer entity) throws SQLException;
     boolean deleteCustomer(String id) throws SQLException;
     CustomerDto searchCustomerId(String cusId) throws SQLException;
     String getGenerateCustomerId() throws SQLException;
     List<String> getCmbUserId() throws SQLException;
     List<String> getCmbCustomerId();
}
