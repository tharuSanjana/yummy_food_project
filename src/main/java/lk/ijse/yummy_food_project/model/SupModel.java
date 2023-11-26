package lk.ijse.yummy_food_project.model;

import lk.ijse.yummy_food_project.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
