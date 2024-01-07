package lk.ijse.yummy_food_project.bo.Custom;

import lk.ijse.yummy_food_project.DAO.SuperBO;
import lk.ijse.yummy_food_project.dto.UserDto;

import java.sql.SQLException;

public interface UserBO extends SuperBO {
    boolean checkUsernamePw(UserDto dto) throws SQLException;

}
