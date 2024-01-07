package lk.ijse.yummy_food_project.bo.Custom;

import lk.ijse.yummy_food_project.DAO.SuperBO;
import lk.ijse.yummy_food_project.dto.FoodDto;
import lk.ijse.yummy_food_project.entity.Food;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FoodBO extends SuperBO {
    ArrayList<FoodDto> getAllFood() throws SQLException;
    Food searchFood(String foodId) throws SQLException;
    boolean saveMenu(FoodDto dto) throws SQLException;
    boolean updateMenu(FoodDto dto) throws SQLException;
    boolean deleteMenu(String id) throws SQLException;
}
