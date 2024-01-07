package lk.ijse.yummy_food_project.bo.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.Custom.Impl.PaymentDAOImpl;
import lk.ijse.yummy_food_project.DAO.Custom.PaymentDAO;
import lk.ijse.yummy_food_project.bo.Custom.PaymentBO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO paymentDAO = new PaymentDAOImpl();
    @Override
    public String getGeneratePaymentId() throws SQLException {
        return paymentDAO.getGeneratePaymentId();
    }

    @Override
    public boolean savePayment(String pId, double total, LocalDate date) throws SQLException {
        return paymentDAO.savePayment(pId,total,date);
    }

    @Override
    public List<String> getCmbPId() {
        return paymentDAO.getCmbPId();
    }
}
