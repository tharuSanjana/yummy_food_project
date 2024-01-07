package lk.ijse.yummy_food_project.DAO;

import lk.ijse.yummy_food_project.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlUtil {
    public <T> T test(String sql, Object...ob) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        for (int i=0;i< ob.length;i++){
            pstm.setObject((i+1),ob[i]);
        }
        if (sql.startsWith("SELECT")){
       return (T) pstm.executeQuery();

    }else{

            return (T)(Boolean)(pstm.executeUpdate()>0);
        }
    }

}
