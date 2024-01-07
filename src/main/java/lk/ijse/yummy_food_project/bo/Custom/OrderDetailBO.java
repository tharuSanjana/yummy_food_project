package lk.ijse.yummy_food_project.bo.Custom;

import lk.ijse.yummy_food_project.DAO.SuperBO;
import lk.ijse.yummy_food_project.dto.PlaceDto;
import lk.ijse.yummy_food_project.dto.PlaceOrderDto;
import lk.ijse.yummy_food_project.dto.tm.CartTm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface OrderDetailBO extends SuperBO {
    boolean saveOrderDetails(String oId, CartTm tm) throws SQLException;
    boolean saveOrderDetails(String orderId, List<CartTm> cartTmList) throws SQLException;
    //ArrayList<PlaceDto> getAllPlaceOrder() throws SQLException;//J0in query

    boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException;
}
