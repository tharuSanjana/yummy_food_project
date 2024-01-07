package lk.ijse.yummy_food_project.bo.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.BoFactory;
import lk.ijse.yummy_food_project.DAO.Custom.FoodDAO;
import lk.ijse.yummy_food_project.DAO.DAOFactory;
import lk.ijse.yummy_food_project.bo.Custom.FoodBO;
import lk.ijse.yummy_food_project.dto.FoodDto;
import lk.ijse.yummy_food_project.entity.Food;

import java.sql.SQLException;
import java.util.ArrayList;

public class FoodBOImpl implements FoodBO {
    //FoodDAO foodDAO = new FoodDAOImpl();
    FoodDAO foodDAO = (FoodDAO) DAOFactory.daoFactory().getDAOTypes(DAOFactory.DAOTypes.FOOD);
    @Override
    public ArrayList<FoodDto> getAllFood() throws SQLException {
        ArrayList<FoodDto> foodDtos = new ArrayList<>();
        ArrayList<Food> allFood = foodDAO.getAllFood();
        for (Food food:allFood){
            foodDtos.add(new FoodDto(food.getId(),food.getName(),food.getPrice(),food.getDesc()));
        }
        return foodDtos;
    }

    @Override
    public Food searchFood(String foodId) throws SQLException {
        return foodDAO.searchFood(foodId);
    }



    @Override
    public boolean saveMenu(FoodDto dto) throws SQLException {
        return foodDAO.saveMenu(new Food(dto.getId(), dto.getName(), dto.getPrice(),dto.getDesc()));
    }

    @Override
    public boolean updateMenu(FoodDto dto) throws SQLException {
        return foodDAO.updateMenu(new Food(dto.getId(), dto.getName(), dto.getPrice(), dto.getDesc()));
    }

    @Override
    public boolean deleteMenu(String id) throws SQLException {
        return foodDAO.deleteMenu(id);
    }
}
