package lk.ijse.yummy_food_project.DAO.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.Custom.SupIngDAO;
import lk.ijse.yummy_food_project.DAO.SqlUtil;
import lk.ijse.yummy_food_project.dto.ViewSupIngDto;
import lk.ijse.yummy_food_project.entity.ViewSupIng;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupIngDAOImpl implements SupIngDAO {
    SqlUtil s = new SqlUtil();
    @Override
    public List<ViewSupIng> getAllSupIng() throws SQLException {

        String sql = "SELECT * FROM supplier_ingredients_details";
        ResultSet resultSet = s.test(sql);
        ArrayList<ViewSupIng> dtoList = new ArrayList<>();

        while(resultSet.next()){
            dtoList.add(
                    new ViewSupIng(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDouble(5),
                            resultSet.getString(6)

                    )
            );
        }
        return dtoList;

    }
    @Override
    public boolean saveSupIng(ViewSupIng entity) throws SQLException {
        String sql = "INSERT INTO supplier_ingredients_details VALUES(?, ?, ?, ? ,? ,?)";
        Boolean test = s.test(sql, entity.getSupId(), entity.getIngId(), entity.getSupName(), entity.getIngName(), entity.getTotal(), entity.getPId());

        return test;

    }

    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(ViewSupIng dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ViewSupIng dto) throws SQLException, ClassNotFoundException {
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
    public ViewSupIng search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getCmbId() throws SQLException {
        return null;
    }
}
