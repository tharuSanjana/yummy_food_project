package lk.ijse.yummy_food_project.model;

import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.ViewSupIngDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupModel {
    public static boolean saveSupplier(String supId, String supName, String tel) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO supplier VALUES(?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, supId);
        pstm.setString(2, supName);
        pstm.setString(3,tel);

        return pstm.executeUpdate() > 0;
    }
    public List<ViewSupIngDto> getAllSupIng() throws SQLException {

        Connection connection= DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM supplier_ingredients_details";



        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<ViewSupIngDto> dtoList = new ArrayList<>();

        while(resultSet.next()){
            dtoList.add(
                    new ViewSupIngDto(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDouble(5),
                            resultSet.getString(6)
                            // resultSet.getDouble(7)
                    )
            );
        }
        return dtoList;

    }
    public boolean saveSupIng(ViewSupIngDto viewDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO supplier_ingredients_details VALUES(?, ?, ?, ? ,? ,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, viewDto.getSupId());
        pstm.setString(2, viewDto.getIngId());
        pstm.setString(3, viewDto.getSupName());
        pstm.setString(4, viewDto.getIngName());
        pstm.setDouble(5,viewDto.getTotal());
        pstm.setString(6, viewDto.getPId());

        return pstm.executeUpdate() > 0;

    }
    }

