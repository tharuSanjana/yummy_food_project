package lk.ijse.yummy_food_project.DAO.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.Custom.FoodDAO;
import lk.ijse.yummy_food_project.DAO.SqlUtil;
import lk.ijse.yummy_food_project.dto.FoodDto;
import lk.ijse.yummy_food_project.entity.Customer;
import lk.ijse.yummy_food_project.entity.Food;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDAOImpl implements FoodDAO {
    SqlUtil s = new SqlUtil();
    @Override
    public ArrayList<Food> getAllFood() throws SQLException {

        String sql = "SELECT * FROM food";
        ResultSet resultSet = s.test(sql);

        ArrayList<Food> dtoList = new ArrayList<>();

        while (resultSet.next()){
            Food food = new Food(resultSet.getString(1),resultSet.getString(2), resultSet.getDouble(3),resultSet.getString(4));
            dtoList.add(food);
        }
        return dtoList;
    }
    @Override
    public Food searchFood(String foodId) throws SQLException {
        String sql = "SELECT * FROM food WHERE food_id = ?";
        ResultSet resultSet = s.test(sql, foodId);

        Food dto = null;

        if(resultSet.next()) {
            dto = new Food(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4)
            );
        }
        return dto;
    }
    @Override
    public boolean saveMenu(Food entity) throws SQLException {
        String sql = "INSERT INTO food VALUES(?,?,?,?)";
        Boolean test = s.test(sql, entity.getId(), entity.getName(), entity.getPrice(), entity.getDesc());

        return test;

    }
    @Override
    public boolean updateMenu(Food entity) throws SQLException {

        String sql = "UPDATE food SET name = ?,price = ?,description = ? WHERE food_id = ?";
        Boolean test = s.test(sql, entity.getName(), entity.getPrice(), entity.getDesc(), entity.getId());

        return test;
    }
    @Override
    public boolean deleteMenu(String id) throws SQLException {

        String sql = "DELETE FROM food WHERE food_id =?";
        Boolean test = s.test(sql, id);

        return test;
    }

    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Food dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Food dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getGenerate() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Food search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getCmbId() throws SQLException {
        return null;
    }
}
