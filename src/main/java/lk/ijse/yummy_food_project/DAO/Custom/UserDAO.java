package lk.ijse.yummy_food_project.DAO.Custom;

import lk.ijse.yummy_food_project.DAO.CrudDAO;
import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.UserDto;
import lk.ijse.yummy_food_project.entity.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User> {
     boolean checkUsernamePw(User entity) throws SQLException;
    }
