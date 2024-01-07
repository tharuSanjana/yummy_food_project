package lk.ijse.yummy_food_project.bo.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.BoFactory;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.IngredientsDAOImpl;
import lk.ijse.yummy_food_project.DAO.Custom.IngredientsDAO;
import lk.ijse.yummy_food_project.bo.Custom.IngredientsBO;
import lk.ijse.yummy_food_project.dto.IngredientsDto;
import lk.ijse.yummy_food_project.entity.Ingredients;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IngredientsBOImpl implements IngredientsBO {
   IngredientsDAO ingredientsDAO = new IngredientsDAOImpl();
    //IngredientsDAO ingredientsDAO = (IngredientsDAO) BoFactory.boFactory.getBoTypes(BoFactory.BOTypes.INGREDIENTS);

    @Override
    public boolean saveIngredients(IngredientsDto dto, LocalDate date) throws SQLException {
        return ingredientsDAO.saveIngredients(new Ingredients(dto.getId(), dto.getName(), dto.getPrice(), dto.getQty(), dto.getpId()),date);
    }

    @Override
    public ArrayList<IngredientsDto> getAllIngredients() throws SQLException {
        ArrayList<IngredientsDto> ingredientsDtos = new ArrayList<>();
        ArrayList<Ingredients> allIngredients = ingredientsDAO.getAllIngredients();
        for (Ingredients ingredients:allIngredients){
            ingredientsDtos.add(new IngredientsDto(ingredients.getId(),ingredients.getName(),ingredients.getPrice(),ingredients.getQty(),ingredients.getpId()));
        }
        return ingredientsDtos;
    }

    @Override
    public IngredientsDto searchIngredientId(String id) throws SQLException {
        return ingredientsDAO.searchIngredientId(id);
    }

    @Override
    public String getGenerateIngredientId() throws SQLException {
        return ingredientsDAO.getGenerateIngredientId();
    }

    @Override
    public List<String> getCmbIngId() {
        return ingredientsDAO.getCmbIngId();
    }

    @Override
    public boolean updateIngredeient(IngredientsDto dto, LocalDate date) throws SQLException {
        return ingredientsDAO.updateIngredeient(new Ingredients(dto.getId(), dto.getName(), dto.getPrice(), dto.getQty(), dto.getpId()),date);
    }
}
