package lk.ijse.yummy_food_project.DAO.Custom;

import lk.ijse.yummy_food_project.DAO.CrudDAO;
import lk.ijse.yummy_food_project.entity.User;

import java.sql.SQLException;

public interface LoginDAO extends CrudDAO<User> {
     User searchUserId(String id) throws SQLException;

    }
