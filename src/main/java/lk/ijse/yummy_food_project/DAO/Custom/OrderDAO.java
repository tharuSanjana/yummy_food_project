package lk.ijse.yummy_food_project.DAO.Custom;

import lk.ijse.yummy_food_project.DAO.CrudDAO;
import lk.ijse.yummy_food_project.entity.Order;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public interface OrderDAO extends CrudDAO<Order> {
     List<String> getCmbCusId() throws SQLException;

     List<String> getCmbFoodId() throws SQLException;

     List<String> getCmbEmployeeId() throws SQLException;

     String getGenerateOrderId() throws SQLException;

     boolean SaveOrder(String orId, LocalDate date, String orderType, LocalTime time, String pId, String empId, String cusId) throws SQLException;
}