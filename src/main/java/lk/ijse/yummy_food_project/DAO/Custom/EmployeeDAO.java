package lk.ijse.yummy_food_project.DAO.Custom;

import lk.ijse.yummy_food_project.DAO.CrudDAO;
import lk.ijse.yummy_food_project.dto.EmployeeDto;
import lk.ijse.yummy_food_project.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeDAO extends CrudDAO<Employee> {
     boolean saveEmp(Employee entity) throws SQLException;

     ArrayList<Employee> getAllEmployee() throws SQLException;


     List<String> getCmbUserId() throws SQLException;
     boolean updateEmployee(Employee entity) throws SQLException;
     boolean deleteEmployee(String id) throws SQLException;
     String searchEmployeeId(String dId) throws SQLException;
     String getGenerateEmployeeId() throws SQLException;

     EmployeeDto searchEmpId(String empId) throws SQLException;
     List<String> getCmbEmpId();
}
