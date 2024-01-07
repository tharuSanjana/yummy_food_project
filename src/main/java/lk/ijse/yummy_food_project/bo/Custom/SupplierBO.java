package lk.ijse.yummy_food_project.bo.Custom;

import lk.ijse.yummy_food_project.DAO.SuperBO;
import lk.ijse.yummy_food_project.dto.SupplierDto;
import lk.ijse.yummy_food_project.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SupplierBO extends SuperBO {
    boolean saveSupplier(SupplierDto dto) throws SQLException;

    boolean updateSupplier(SupplierDto dto) throws SQLException;

    boolean deleteSupplier(String id) throws SQLException;

    ArrayList<SupplierDto> getAllSupplier() throws SQLException;

    String getGenerateSupplierId() throws SQLException;

    List<String> getCmbSupId() throws SQLException;

    Supplier searchSupplierId(String id) throws SQLException;
}
