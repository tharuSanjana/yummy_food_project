package lk.ijse.yummy_food_project.DAO.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.Custom.EmployeeDAO;
import lk.ijse.yummy_food_project.DAO.SqlUtil;
import lk.ijse.yummy_food_project.dto.EmployeeDto;
import lk.ijse.yummy_food_project.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    SqlUtil s = new SqlUtil();
    @Override
    public boolean saveEmp(Employee entity) throws SQLException {

        String sql = "INSERT INTO employee VALUES(?,?,?,?,?,?)";
        Boolean test = s.test(sql, entity.getId(), entity.getName(), entity.getAddress(), entity.getTel(), entity.getType(), entity.getUserId());

        return test;
    }
    @Override
    public ArrayList<Employee> getAllEmployee() throws SQLException {

        String sql = "SELECT * FROM employee";
        ResultSet resultSet = s.test(sql);

        ArrayList<Employee> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new Employee(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)

                    )
            );
        }
        return dtoList;
    }

    @Override
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
    public boolean updateEmployee(Employee entity) throws SQLException {
        String sql = "UPDATE employee SET name = ?,address = ?,tel = ?,emp_type = ?,user_id = ? WHERE emp_id = ?";
        Boolean test = s.test(sql, entity.getName(), entity.getAddress(), entity.getTel(), entity.getType(), entity.getUserId(), entity.getId());

        return test;
    }
    @Override
    public boolean deleteEmployee(String id) throws SQLException {
       String sql = "DELETE from employee WHERE emp_id = ?";
        Boolean test = s.test(sql, id);

        return test;
    }
    @Override
    public String searchEmployeeId(String dId) throws SQLException {
        String sql = "SELECT name FROM employee WHERE emp_id = ? AND emp_type = 'Driver'";
        ResultSet resultSet = s.test(sql, dId);

        String empName = null;

        if (resultSet.next()) {
            empName = resultSet.getString("name");
        }

        return empName;

    }
    @Override
    public String getGenerateEmployeeId() throws SQLException {
        String sql = "SELECT emp_id FROM employee ORDER BY emp_id DESC LIMIT 1";
        ResultSet resultSet = s.test(sql);

        if(resultSet.next()) {
            return splitEmployeeId(resultSet.getString(1));
        }
        return splitEmployeeId(null);
    }
    private String splitEmployeeId(String currentEmployeeId) {
        if(currentEmployeeId!= null) {
            String[] split = currentEmployeeId.split("E0");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "E00" + id;
        } else {
            return "E001";
        }
    }
    @Override
    public EmployeeDto searchEmpId(String empId) throws SQLException {
        String sql = "SELECT * FROM employee WHERE emp_id = ?";
        ResultSet resultSet = s.test(sql, empId);

        EmployeeDto empDto = null;

        if(resultSet.next()){
            empDto = new EmployeeDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
        }
        return  empDto;
    }
    @Override
    public List<String> getCmbEmpId(){
        List<String> ids = new ArrayList<>();
        try {
            String sql = "SELECT emp_id FROM employee";
            ResultSet resultSet = s.test(sql);

            while (resultSet.next()) {
                ids.add(resultSet.getString("emp_id"));
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
    public boolean save(Employee dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Employee dto) throws SQLException, ClassNotFoundException {
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
    public Employee search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getCmbId() throws SQLException {
        return null;
    }
}
