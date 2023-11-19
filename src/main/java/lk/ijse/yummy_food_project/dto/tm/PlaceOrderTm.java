package lk.ijse.yummy_food_project.dto.tm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PlaceOrderTm {
    private String oId;
    private String cusId;
    private String cusName;
    private String paymentId;
    private LocalDate date;
    private LocalTime time;
    private double amount;

    @Override
    public String toString() {
        return "PlaceOrderTm{" +
                "oId='" + oId + '\'' +
                ", cusId='" + cusId + '\'' +
                ", cusName='" + cusName + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", amount=" + amount +
                '}';
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PlaceOrderTm(String oId, String cusId, String cusName, String paymentId, LocalDate date, LocalTime time, double amount) {
        this.oId = oId;
        this.cusId = cusId;
        this.cusName = cusName;
        this.paymentId = paymentId;
        this.date = date;
        this.time = time;
        this.amount = amount;
    }
}
