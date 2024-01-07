package lk.ijse.yummy_food_project.bo.Custom;

import lk.ijse.yummy_food_project.DAO.SuperBO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface OrderBO extends SuperBO {
    List<String> getCmbCusId() throws SQLException;

    List<String> getCmbFoodId() throws SQLException;

    List<String> getCmbEmployeeId() throws SQLException;

    String getGenerateOrderId() throws SQLException;

    boolean SaveOrder(String orId, LocalDate date, String orderType, LocalTime time, String pId, String empId, String cusId) throws SQLException;
}
