package lk.ijse.yummy_food_project.bo.Custom;

import lk.ijse.yummy_food_project.DAO.SuperBO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PaymentBO extends SuperBO {
    String getGeneratePaymentId() throws SQLException;

    boolean savePayment(String pId, double total, LocalDate date) throws SQLException;
    List<String> getCmbPId();
   // ArrayList<incomePaymentDto> getAllIncomePayment() throws SQLException; //Join query
  //  ArrayList<CostPaymentDto> getAllCostPayment() throws SQLException; //Join query
}
