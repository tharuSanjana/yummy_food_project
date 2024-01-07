package lk.ijse.yummy_food_project.DAO.Custom;

import lk.ijse.yummy_food_project.DAO.CrudDAO;
import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.IngredientsDto;
import lk.ijse.yummy_food_project.entity.Ingredients;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface IngredientsDAO extends CrudDAO<Ingredients> {
     boolean saveIngredients(Ingredients entity, LocalDate date) throws SQLException;
     ArrayList<Ingredients> getAllIngredients() throws SQLException;
     IngredientsDto searchIngredientId(String id) throws SQLException;
     String getGenerateIngredientId() throws SQLException;

     List<String> getCmbIngId();
     boolean updateIngredeient(Ingredients entity, LocalDate date) throws SQLException;

}
