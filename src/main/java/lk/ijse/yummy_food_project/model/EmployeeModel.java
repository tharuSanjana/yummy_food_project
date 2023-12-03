package lk.ijse.yummy_food_project.model;

import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.EmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
    public boolean saveEmp(EmployeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO employee VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        pstm.setString(4, dto.getTel());
        pstm.setString(5, dto.getType());
        pstm.setString(6, dto.getUserId());

        return pstm.executeUpdate() > 0;
    }

    public ArrayList<EmployeeDto> getAllEmployee() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM employee";

        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        ArrayList<EmployeeDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new EmployeeDto(
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


    public List<String> getCmbUserId() throws SQLException {
        Connection connection = null;
        List<String> userIds = new ArrayList<>();
        String query = "SELECT user_id FROM user";

        try {
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                userIds.add(resultSet.getString("user_id"));
            }
        } finally {

            if (connection != null) {
               // connection.close();
            }
        }

        return userIds;
    }



    public boolean updateEmployee(EmployeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "UPDATE employee SET name = ?,address = ?,tel = ?,emp_type = ?,user_id = ? WHERE emp_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getTel());
        pstm.setString(4,dto.getType());
        pstm.setString(5, dto.getUserId());
        pstm.setString(6,dto.getId());

        return pstm.executeUpdate()>0;
    }
    public boolean deleteEmployee(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "DELETE from employee WHERE emp_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate() > 0;
    }
   public String searchEmployeeId(String dId) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT name FROM employee WHERE emp_type = 'Driver'";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,dId);

        ResultSet resultSet = pstm.executeQuery();
       // EmployeeDto empDto = null;

        if(resultSet.next()){
           // empDto = new EmployeeDto(
                 //  String emp_id = resultSet.getString(1);
                   String emp_name =  resultSet.getString(1);
                  /* String address = resultSet.getString(3);
                   String tel =   resultSet.getString(4);
                   String emp_type = resultSet.getString(5);
                   String user_id = resultSet.getString(6);*/

                  // empDto=new EmployeeDto(emp_id,emp_name,address,tel,emp_type,user_id);*/
       Connection connection = DbConnection.getInstance().getConnection();
       String sql = "SELECT name FROM employee WHERE emp_id = ? AND emp_type = 'Driver'";
       PreparedStatement pstm = connection.prepareStatement(sql);
       pstm.setString(1, dId);

       ResultSet resultSet = pstm.executeQuery();
       String empName = null;

       if (resultSet.next()) {
           empName = resultSet.getString("name");
       }

       return empName;

   }
 /*  public ArrayList<EmployeeDto> emptyEmployee() throws SQLException {

       Connection   connection = DbConnection.getInstance().getConnection();
      // List<String> empIds = new ArrayList<>();
        String sql = "SELECT * FROM employee WHERE emp_id ='noEmployee'";
       PreparedStatement pstm = connection.prepareStatement(sql);
       ResultSet resultSet = pstm.executeQuery();
       ArrayList<EmployeeDto> dtoList = new ArrayList<>();
       while (resultSet.next()) {
           dtoList.add(
                   new EmployeeDto(
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
   }*/
/* public String emptyEmployeeId(String dId) throws SQLException {
     Connection connection = DbConnection.getInstance().getConnection();
     String sql = "SELECT * FROM employee WHERE emp_id =?";
     PreparedStatement pstm = connection.prepareStatement(sql);
     pstm.setString(1, dId);

     ResultSet resultSet = pstm.executeQuery();
     String empName = null;

     if (resultSet.next()) {
         empName = resultSet.getString("name");
     }

     return empName;

 }*/
    public String getGenerateEmployeeId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT emp_id FROM employee ORDER BY emp_id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
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
    public EmployeeDto searchEmpId(String empId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM employee WHERE emp_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,empId);
        ResultSet resultSet = pstm.executeQuery();

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
    public List<String> getCmbEmpId(){
        Connection connection = null;
        List<String> empIds = new ArrayList<>();
        String query = "SELECT emp_id FROM employee";

        try {
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                empIds.add(resultSet.getString("emp_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            if (connection != null) {
                // connection.close();
            }
        }

        return empIds;
    }
    }
   //}



