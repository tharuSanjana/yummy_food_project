package lk.ijse.yummy_food_project.bo.Custom;

import lk.ijse.yummy_food_project.DAO.SuperBO;
import lk.ijse.yummy_food_project.dto.ViewSupIngDto;

import java.sql.SQLException;
import java.util.List;

public interface SupIngBO extends SuperBO {
    List<ViewSupIngDto> getAllSupIng() throws SQLException;
    boolean saveSupIng(ViewSupIngDto viewDto) throws SQLException;
}
