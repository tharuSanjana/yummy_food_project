package lk.ijse.yummy_food_project.bo.Custom;

import lk.ijse.yummy_food_project.DAO.SuperBO;
import lk.ijse.yummy_food_project.entity.User;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    User searchUserId(String id) throws SQLException;

}
