package lk.ijse.yummy_food_project.bo.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.Custom.Impl.SupplierDAOImpl;
import lk.ijse.yummy_food_project.DAO.Custom.SupplierDAO;
import lk.ijse.yummy_food_project.bo.Custom.SupplierBO;
import lk.ijse.yummy_food_project.dto.SupplierDto;
import lk.ijse.yummy_food_project.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOImpl implements SupplierBO {
    SupplierDAO supplierDAO = new SupplierDAOImpl();
    @Override
    public boolean saveSupplier(SupplierDto dto) throws SQLException {
        return supplierDAO.saveSupplier(new Supplier(dto.getId(), dto.getName(), dto.getTel(), dto.getEmail())) ;
    }

    @Override
    public boolean updateSupplier(SupplierDto dto) throws SQLException {
        return supplierDAO.updateSupplier(new Supplier(dto.getId(), dto.getName(), dto.getTel(), dto.getEmail()));
    }

    @Override
    public boolean deleteSupplier(String id) throws SQLException {
        return supplierDAO.deleteSupplier(id);
    }

    @Override
    public ArrayList<SupplierDto> getAllSupplier() throws SQLException {
        ArrayList<SupplierDto> supplierDtos = new ArrayList<>();
        ArrayList<Supplier> allSupplier = supplierDAO.getAllSupplier();
        for (Supplier supplier:allSupplier){
            supplierDtos.add(new SupplierDto(supplier.getId(),supplier.getName(),supplier.getTel(),supplier.getEmail()));
        }
        return supplierDtos;
    }

    @Override
    public String getGenerateSupplierId() throws SQLException {
        return supplierDAO.getGenerateSupplierId();
    }

    @Override
    public List<String> getCmbSupId() throws SQLException {
        return supplierDAO.getCmbSupId();
    }

    @Override
    public Supplier searchSupplierId(String id) throws SQLException {
        return supplierDAO.searchSupplierId(id);
    }
}
