package lk.ijse.yummy_food_project.DAO.Custom;

import lk.ijse.yummy_food_project.DAO.CrudDAO;
import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.PlaceDto;
import lk.ijse.yummy_food_project.dto.PlaceOrderDto;
import lk.ijse.yummy_food_project.dto.tm.CartTm;
import lk.ijse.yummy_food_project.entity.PlaceOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public interface OrderDetailDAO extends CrudDAO<PlaceOrder> {
     boolean saveOrderDetails(String oId, CartTm tm) throws SQLException;
     boolean saveOrderDetails(String orderId, List<CartTm> cartTmList) throws SQLException;
    // ArrayList<PlaceDto> getAllPlaceOrder() throws SQLException;

     boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException;
}
