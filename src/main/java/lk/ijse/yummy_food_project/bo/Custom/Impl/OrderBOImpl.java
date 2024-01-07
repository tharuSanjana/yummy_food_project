package lk.ijse.yummy_food_project.bo.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.BoFactory;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.OrderDAOImpl;
import lk.ijse.yummy_food_project.DAO.Custom.OrderDAO;
import lk.ijse.yummy_food_project.bo.Custom.OrderBO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class OrderBOImpl implements OrderBO {
   OrderDAO orderDAO = new OrderDAOImpl();
    //OrderDAO orderDAO = (OrderDAO) BoFactory.boFactory.getBoTypes(BoFactory.BOTypes.ORDER);
    @Override
    public List<String> getCmbCusId() throws SQLException {
        return orderDAO.getCmbCusId();
    }

    @Override
    public List<String> getCmbFoodId() throws SQLException {
        return orderDAO.getCmbFoodId();
    }

    @Override
    public List<String> getCmbEmployeeId() throws SQLException {
        return orderDAO.getCmbEmployeeId();
    }

    @Override
    public String getGenerateOrderId() throws SQLException {
        return orderDAO.getGenerateOrderId();
    }

    @Override
    public boolean SaveOrder(String orId, LocalDate date, String orderType, LocalTime time, String pId, String empId, String cusId) throws SQLException {
        return orderDAO.SaveOrder(orId,date,orderType,time,empId,pId,cusId);
    }
}
