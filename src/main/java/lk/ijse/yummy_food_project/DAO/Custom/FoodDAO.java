package lk.ijse.yummy_food_project.DAO.Custom;

import lk.ijse.yummy_food_project.DAO.CrudDAO;
import lk.ijse.yummy_food_project.dto.FoodDto;
import lk.ijse.yummy_food_project.entity.Food;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface FoodDAO extends CrudDAO<Food> {
     ArrayList<Food> getAllFood() throws SQLException;
     Food searchFood(String foodId) throws SQLException;
     boolean saveMenu(Food entity) throws SQLException;
     boolean updateMenu(Food entity) throws SQLException;
     boolean deleteMenu(String id) throws SQLException;
}
