package lk.ijse.yummy_food_project.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class PlaceDto {
    private String or_id;
    private String customerId;
    private String customerName;
    private String paymentId;
    private LocalDate date;
    private LocalTime time;
    private double amount;

    @Override
    public String toString() {
        return "PlaceDto{" +
                "or_id='" + or_id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", PaymentId='" + paymentId + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", amount=" + amount +
                '}';
    }

    public String getOr_id() {
        return or_id;
    }

    public void setOr_id(String or_id) {
        this.or_id = or_id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public PlaceDto(String or_id, String customerId, String customerName, String paymentId, LocalDate date, LocalTime time, double amount) {
        this.or_id = or_id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.paymentId = paymentId;
        this.date = date;
        this.time = time;
        this.amount = amount;
    }
    public PlaceDto(){}
}
