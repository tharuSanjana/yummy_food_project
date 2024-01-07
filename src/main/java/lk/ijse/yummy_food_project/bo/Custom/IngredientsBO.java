package lk.ijse.yummy_food_project.bo.Custom;

import lk.ijse.yummy_food_project.DAO.SuperBO;
import lk.ijse.yummy_food_project.dto.IngredientsDto;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface IngredientsBO extends SuperBO {
    boolean saveIngredients(IngredientsDto dto, LocalDate date) throws SQLException;
    ArrayList<IngredientsDto> getAllIngredients() throws SQLException;
    IngredientsDto searchIngredientId(String id) throws SQLException;
    String getGenerateIngredientId() throws SQLException;

    List<String> getCmbIngId();
    boolean updateIngredeient(IngredientsDto dto, LocalDate date) throws SQLException;

}
