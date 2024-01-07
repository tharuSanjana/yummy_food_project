package lk.ijse.yummy_food_project.model;

public class PlaceOrderModel {
   /* private OrderModel orderModel = new OrderModel();
    private MenuModel menuModel = new MenuModel();
    private OrderDetailModel orderDetailModel = new OrderDetailModel();
    private CustomerModel cusModel = new CustomerModel();
    private PaymentModel pModel = new PaymentModel();
    OrderDetailDAOImpl orderDetailDAO = new OrderDetailDAOImpl();
    OrderDAOImpl orderDAO = new OrderDAOImpl();
    PaymentDAOImpl paymentDAO = new PaymentDAOImpl();

    public boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException {
        System.out.println(placeOrderDto);

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
                    boolean isOrderDetailSaved = orderDetailDAO.saveOrderDetails(placeOrderDto.getoId(), placeOrderDto.getCartTmList());
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
        }

        return true;


    }*/


}
