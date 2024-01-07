package lk.ijse.yummy_food_project.bo.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.Custom.Impl.LoginDAOImpl;
import lk.ijse.yummy_food_project.DAO.Custom.LoginDAO;
import lk.ijse.yummy_food_project.bo.Custom.LoginBO;
import lk.ijse.yummy_food_project.entity.User;

import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {
   LoginDAO loginDAO = new LoginDAOImpl();
    //LoginDAO loginDAO = (LoginDAO) BoFactory.boFactory.getBoTypes(BoFactory.BOTypes.LOGIN);
    @Override
    public User searchUserId(String id) throws SQLException {
        return loginDAO.searchUserId(id);
    }
}
