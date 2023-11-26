package lk.ijse.yummy_food_project.model;

import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.CustomerDto;
import lk.ijse.yummy_food_project.dto.SupplierDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierModel {
    public boolean saveSupplier(SupplierDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO supplier VALUES(?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getTel());

        boolean flag = pstm.executeUpdate() > 0;
        return flag;
    }
    public boolean updateSupplier(SupplierDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE supplier SET name = ?  ,tel = ?  WHERE sup_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,dto.getName());
        pstm.setString(2,dto.getTel());
        pstm.setString(3,dto.getId());

        return pstm.executeUpdate() > 0;

    }
    public boolean deleteSupplier(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "DELETE FROM supplier WHERE sup_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        return pstm.executeUpdate() > 0;
    }
    public ArrayList<SupplierDto> getAllSupplier() throws SQLException {
        Connection connection= DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM supplier";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<SupplierDto> dtoList = new ArrayList<>();

        while (resultSet.next()){
            dtoList.add(
                    new SupplierDto(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    )
            );
        }
        return dtoList;
    }
}
