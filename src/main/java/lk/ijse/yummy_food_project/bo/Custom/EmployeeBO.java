package lk.ijse.yummy_food_project.bo.Custom;

import lk.ijse.yummy_food_project.DAO.SuperBO;
import lk.ijse.yummy_food_project.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeBO extends SuperBO {
    boolean saveEmp(EmployeeDto dto) throws SQLException;

    ArrayList<EmployeeDto> getAllEmployee() throws SQLException;


    List<String> getCmbUserId() throws SQLException;
    boolean updateEmployee(EmployeeDto dto) throws SQLException;
    boolean deleteEmployee(String id) throws SQLException;
    String searchEmployeeId(String dId) throws SQLException;
    String getGenerateEmployeeId() throws SQLException;

    EmployeeDto searchEmpId(String empId) throws SQLException;
    List<String> getCmbEmpId();
}
