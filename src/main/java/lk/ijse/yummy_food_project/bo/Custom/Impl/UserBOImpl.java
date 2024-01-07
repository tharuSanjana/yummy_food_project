package lk.ijse.yummy_food_project.bo.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.Custom.Impl.UserDAOImpl;
import lk.ijse.yummy_food_project.DAO.Custom.UserDAO;
import lk.ijse.yummy_food_project.bo.Custom.UserBO;
import lk.ijse.yummy_food_project.dto.UserDto;
import lk.ijse.yummy_food_project.entity.User;

import java.sql.SQLException;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = new UserDAOImpl();
    @Override
    public boolean checkUsernamePw(UserDto dto) throws SQLException {
        return userDAO.checkUsernamePw(new User(dto.getUser_id(),dto.getUsername()));
    }
}
