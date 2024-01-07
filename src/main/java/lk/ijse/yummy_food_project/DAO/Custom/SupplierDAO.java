package lk.ijse.yummy_food_project.DAO.Custom;

import lk.ijse.yummy_food_project.DAO.CrudDAO;
import lk.ijse.yummy_food_project.dto.SupplierDto;
import lk.ijse.yummy_food_project.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SupplierDAO extends CrudDAO<Supplier> {
     boolean saveSupplier(Supplier entity) throws SQLException;

     boolean updateSupplier(Supplier entity) throws SQLException;

     boolean deleteSupplier(String id) throws SQLException;

     ArrayList<Supplier> getAllSupplier() throws SQLException;

     String getGenerateSupplierId() throws SQLException;

     List<String> getCmbSupId() throws SQLException;

     Supplier searchSupplierId(String id) throws SQLException;
}
