package lk.ijse.yummy_food_project.DAO.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.Custom.SupplierDAO;
import lk.ijse.yummy_food_project.DAO.SqlUtil;
import lk.ijse.yummy_food_project.dto.SupplierDto;
import lk.ijse.yummy_food_project.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {
    SqlUtil s = new SqlUtil();
    @Override
    public boolean saveSupplier(Supplier entity) throws SQLException {
        String sql = "INSERT INTO supplier VALUES(?,?,?,?)";
        Boolean test = s.test(sql, entity.getId(), entity.getName(), entity.getTel(), entity.getEmail());
        return test;
    }
    @Override
    public boolean updateSupplier(Supplier entity) throws SQLException {
        String sql = "UPDATE supplier SET name = ?  ,tel = ? ,email = ? WHERE sup_id = ?";
        Boolean test = s.test(sql, entity.getName(), entity.getTel(), entity.getEmail(), entity.getId());
        return test;

    }
    @Override
    public boolean deleteSupplier(String id) throws SQLException {
        String sql = "DELETE FROM supplier WHERE sup_id = ?";
        Boolean test = s.test(sql, id);
        return test;
    }
    @Override
    public ArrayList<Supplier> getAllSupplier() throws SQLException {
        String sql = "SELECT * FROM supplier";
        ResultSet resultSet = s.test(sql);
        ArrayList<Supplier> dtoList = new ArrayList<>();

        while (resultSet.next()){
            dtoList.add(
                    new Supplier(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getNString(4)
                    )
            );
        }
        return dtoList;
    }
    @Override
    public String getGenerateSupplierId() throws SQLException {
        String sql = "SELECT sup_id FROM supplier ORDER BY sup_id DESC LIMIT 1";
        ResultSet resultSet = s.test(sql);
         if(resultSet.next()) {
            return splitSupplierId(resultSet.getString(1));
        }
        return splitSupplierId(null);

    }
    private String splitSupplierId(String currentCustomerId) {
        if(currentCustomerId!= null) {
            String[] split = currentCustomerId.split("S0");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "S00" + id;
        } else {
            return "S001";
        }
    }
    @Override
    public List<String> getCmbSupId() throws SQLException {

        List<String> supIds = new ArrayList<>();

        try {
            String sql = "SELECT sup_id FROM supplier";
            ResultSet resultSet = s.test(sql);
            while (resultSet.next()) {
                supIds.add(resultSet.getString("sup_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return supIds;
    }
    @Override
    public Supplier searchSupplierId(String id) throws SQLException {

        String sql = "SELECT * FROM supplier WHERE sup_id = ?";
        ResultSet resultSet = s.test(sql, id);
        Supplier supDto = null;

        if(resultSet.next()){
            supDto = new Supplier(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)

            );
        }
        return  supDto;
    }

    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Supplier dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Supplier dto) throws SQLException, ClassNotFoundException {
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
    public Supplier search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getCmbId() throws SQLException {
        return null;
    }
}
