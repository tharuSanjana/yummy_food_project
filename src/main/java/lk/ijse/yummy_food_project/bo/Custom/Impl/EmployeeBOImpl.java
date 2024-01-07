package lk.ijse.yummy_food_project.bo.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.BoFactory;
import lk.ijse.yummy_food_project.DAO.Custom.EmployeeDAO;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.EmployeeDAOImpl;
import lk.ijse.yummy_food_project.DAO.DAOFactory;
import lk.ijse.yummy_food_project.bo.Custom.EmployeeBO;
import lk.ijse.yummy_food_project.dto.EmployeeDto;
import lk.ijse.yummy_food_project.dto.ViewSupIngDto;
import lk.ijse.yummy_food_project.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {
    //EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.daoFactory().getDAOTypes(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public boolean saveEmp(EmployeeDto dto) throws SQLException {
        return employeeDAO.saveEmp(new Employee(dto.getId(), dto.getName(), dto.getAddress(), dto.getTel(), dto.getType(), dto.getUserId()));
    }

    @Override
    public ArrayList<EmployeeDto> getAllEmployee() throws SQLException {
    ArrayList<EmployeeDto> employeeDtos = new ArrayList<>();
    ArrayList<Employee> allEmployee = employeeDAO.getAllEmployee();
    for (Employee employee:allEmployee){
        employeeDtos.add(new EmployeeDto(employee.getId(),employee.getName(),employee.getAddress(),employee.getTel(),employee.getType(),employee.getUserId()));
    }
        return employeeDtos;
    }

    @Override
    public List<String> getCmbUserId() throws SQLException {
        return employeeDAO.getCmbUserId();
    }

    @Override
    public boolean updateEmployee(EmployeeDto dto) throws SQLException {
        return employeeDAO.updateEmployee(new Employee(dto.getId(),dto.getName(), dto.getAddress(), dto.getTel(), dto.getType(), dto.getUserId()));
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException {
        return employeeDAO.deleteEmployee(id);
    }

    @Override
    public String searchEmployeeId(String dId) throws SQLException {
        return employeeDAO.searchEmployeeId(dId);
    }

    @Override
    public String getGenerateEmployeeId() throws SQLException {
        return employeeDAO.getGenerateEmployeeId();
    }

    @Override
    public EmployeeDto searchEmpId(String empId) throws SQLException {
        return employeeDAO.searchEmpId(empId);
    }

    @Override
    public List<String> getCmbEmpId() {
        return employeeDAO.getCmbEmpId();
    }


}
