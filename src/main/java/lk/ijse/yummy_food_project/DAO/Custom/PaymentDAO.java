package lk.ijse.yummy_food_project.DAO.Custom;

import lk.ijse.yummy_food_project.DAO.CrudDAO;
import lk.ijse.yummy_food_project.entity.IncomePayment;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PaymentDAO extends CrudDAO<IncomePayment> {
     String getGeneratePaymentId() throws SQLException;

     boolean savePayment(String pId, double total, LocalDate date) throws SQLException;
     List<String> getCmbPId();
    // ArrayList<incomePaymentDto> getAllIncomePayment() throws SQLException;
     //ArrayList<CostPaymentDto> getAllCostPayment() throws SQLException;
}
