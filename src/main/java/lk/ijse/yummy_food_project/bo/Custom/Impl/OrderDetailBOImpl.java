package lk.ijse.yummy_food_project.bo.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.BoFactory;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.OrderDAOImpl;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.OrderDetailDAOImpl;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.PaymentDAOImpl;
import lk.ijse.yummy_food_project.DAO.Custom.OrderDAO;
import lk.ijse.yummy_food_project.DAO.Custom.OrderDetailDAO;
import lk.ijse.yummy_food_project.DAO.Custom.PaymentDAO;
import lk.ijse.yummy_food_project.bo.Custom.OrderDetailBO;
import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.PlaceOrderDto;
import lk.ijse.yummy_food_project.dto.tm.CartTm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailBOImpl implements OrderDetailBO {
    OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
    PaymentDAO paymentDAO = new PaymentDAOImpl();
    OrderDAO orderDAO = new OrderDAOImpl();
    //OrderDetailDAO orderDetailDAO = BoFactory.boFactory()
    @Override
    public boolean saveOrderDetails(String oId, CartTm tm) throws SQLException {
        return orderDetailDAO.saveOrderDetails(oId,tm);
    }

    @Override
    public boolean saveOrderDetails(String orderId, List<CartTm> cartTmList) throws SQLException {
        return orderDetailDAO.saveOrderDetails(orderId,cartTmList);
    }

    @Override
    public boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException { //Transaction
        Connection connection = null;


        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            boolean isPaymentSaved = paymentDAO.savePayment(placeOrderDto.getpId(), placeOrderDto.getTotal(), placeOrderDto.getDate());
            if (isPaymentSaved) {
                System.out.println("payment");
                boolean isOrderSaved = orderDAO.SaveOrder(placeOrderDto.getoId(), placeOrderDto.getDate(), placeOrderDto.getOrderType(), placeOrderDto.getTime(), placeOrderDto.getpId(), placeOrderDto.getEmpId(), placeOrderDto.getCusId());

                if (isOrderSaved) {
                    System.out.println("order");
                    boolean isOrderDetailSaved = saveOrderDetails(placeOrderDto.getoId(), placeOrderDto.getCartTmList());
                    if (isOrderDetailSaved) {
                        System.out.println("order out");
                        connection.commit();
                    }
                }
            }

        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }

        return true;




    }
}
