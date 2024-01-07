package lk.ijse.yummy_food_project.bo.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.BoFactory;
import lk.ijse.yummy_food_project.DAO.Custom.CustomerDAO;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.CustomerDAOImpl;
import lk.ijse.yummy_food_project.DAO.DAOFactory;
import lk.ijse.yummy_food_project.bo.Custom.CustomerBO;
import lk.ijse.yummy_food_project.dto.CustomerDto;
import lk.ijse.yummy_food_project.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
   // CustomerDAO customerDAO = new CustomerDAOImpl();
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.daoFactory().getDAOTypes(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerDto> getAllCustomer() throws SQLException {
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();
        ArrayList<Customer> allCustomer = customerDAO.getAllCustomer();
        for (Customer customer:allCustomer){
            customerDtos.add(new CustomerDto(customer.getId(),customer.getName(),customer.getAddress(),customer.getTel(),customer.getUserId()));
        }
        return customerDtos;
    }

    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException {
       return customerDAO.saveCustomer(new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getTel(), dto.getUserId()));


    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException {
        return customerDAO.updateCustomer(new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getTel(),dto.getUserId()));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return customerDAO.deleteCustomer(id);
    }

    @Override
    public CustomerDto searchCustomerId(String cusId) throws SQLException {
        return customerDAO.searchCustomerId(cusId);
    }

    @Override
    public String getGenerateCustomerId() throws SQLException {
        return customerDAO.getGenerateCustomerId();
    }

    @Override
    public List<String> getCmbUserId() throws SQLException {
        return customerDAO.getCmbUserId();
    }

    @Override
    public List<String> getCmbCustomerId() {
        return customerDAO.getCmbCustomerId();
    }


}
