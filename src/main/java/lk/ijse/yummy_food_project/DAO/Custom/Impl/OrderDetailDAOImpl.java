package lk.ijse.yummy_food_project.DAO.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.Custom.OrderDAO;
import lk.ijse.yummy_food_project.DAO.Custom.OrderDetailDAO;
import lk.ijse.yummy_food_project.DAO.Custom.PaymentDAO;
import lk.ijse.yummy_food_project.DAO.SqlUtil;
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

public class OrderDetailDAOImpl implements OrderDetailDAO {
    SqlUtil s = new SqlUtil();

    OrderDAO orderDAO = new OrderDAOImpl();
    PaymentDAO paymentDAO = new PaymentDAOImpl();
    @Override
    public boolean saveOrderDetails(String oId, CartTm tm) throws SQLException {
        String sql = "INSERT INTO order_food_details VALUES(?, ?)";
        Boolean test = s.test(sql, tm.getFoodId(), oId);
        return test;
    }
    @Override
    public boolean saveOrderDetails(String orderId, List<CartTm> cartTmList) throws SQLException {
        for(CartTm tm : cartTmList) {
            if(!saveOrderDetails(orderId, tm)) {
                return false;
            }
        }
        return true;
    }
    @Override
    /*public ArrayList<PlaceDto> getAllPlaceOrder() throws SQLException {
        Connection connection= DbConnection.getInstance().getConnection();
        String sql = "SELECT \n" +
                "orders.or_id,\n" +
                "customer.cus_id,\n" +
                "customer.name,\n" +
                "payment.p_id,\n" +
                "orders.date,\n" +
                "orders.time,\n" +
                "payment.amount\n" +
                "FROM\n" +
                "orders\n" +
                "JOIN customer ON orders.cus_id = customer.cus_id\n" +
                "JOIN payment ON orders.p_id  = payment.p_id;\n" +
                " \n";



        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<PlaceDto> dtoList = new ArrayList<>();

        while(resultSet.next()){
            dtoList.add(
                    new PlaceDto(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDate(5).toLocalDate(),
                            resultSet.getTime(6).toLocalTime(),
                            resultSet.getDouble(7)
                            // resultSet.getDouble(7)
                    )
            );
        }
        return dtoList;

    }*/

    public boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException {
       /* System.out.println(placeOrderDto);

        String orId = placeOrderDto.getoId();
        LocalDate date = placeOrderDto.getDate();
        String orderType = placeOrderDto.getOrderType();
        LocalTime time = placeOrderDto.getTime();
        String pId = placeOrderDto.getpId();
        String empId = placeOrderDto.getEmpId();
        String cusId = placeOrderDto.getCusId();

        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            boolean isPaymentSaved = paymentDAO.savePayment(pId, placeOrderDto.getTotal(), date);
            if (isPaymentSaved) {
                System.out.println("payment");
                boolean isOrderSaved = orderDAO.SaveOrder(orId, date, orderType, time, pId, empId, cusId);
                // if(isOrderSaved){
                //  boolean isUpdated =  menuModel.updateMenu( placeOrderDto.getCartTmList());
                //   boolean isUpdated = cusModel.
                if (isOrderSaved) {
                    System.out.println("order");
                    boolean isOrderDetailSaved = saveOrderDetails(placeOrderDto.getoId(), placeOrderDto.getCartTmList());
                    if (isOrderDetailSaved) {
                        System.out.println("order out");
                        connection.commit();
                    }
                }
            }
            // }
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }*/

        return true;


    }

    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(PlaceOrder dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(PlaceOrder dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getGenerate() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public PlaceOrder search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getCmbId() throws SQLException {
        return null;
    }
}
