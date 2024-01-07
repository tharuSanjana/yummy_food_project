package lk.ijse.yummy_food_project.DAO.Custom;

import lk.ijse.yummy_food_project.DAO.CrudDAO;
import lk.ijse.yummy_food_project.dto.ViewSupIngDto;
import lk.ijse.yummy_food_project.entity.ViewSupIng;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SupIngDAO extends CrudDAO<ViewSupIng> {
     List<ViewSupIng> getAllSupIng() throws SQLException;
     boolean saveSupIng(ViewSupIng entity) throws SQLException;
}
