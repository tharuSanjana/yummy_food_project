package lk.ijse.yummy_food_project.DAO.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.Custom.LoginDAO;
import lk.ijse.yummy_food_project.DAO.SqlUtil;
import lk.ijse.yummy_food_project.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {
    SqlUtil s = new SqlUtil();
    @Override
    public User searchUserId(String id) throws SQLException {
        String sql = "SELECT * FROM user WHERE user_id = ?";
        ResultSet resultSet = s.test(sql, id);
        User user = null;

        if(resultSet.next()){
            user = new User(
                    resultSet.getString(1),
                    resultSet.getString(2)
                    //resultSet.getString(3)


            );
        }
        return  user;
    }

    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(User dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(User dto) throws SQLException, ClassNotFoundException {
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
    public User search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getCmbId() throws SQLException {
        return null;
    }
}
