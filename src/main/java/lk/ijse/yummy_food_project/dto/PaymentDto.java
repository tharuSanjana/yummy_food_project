package lk.ijse.yummy_food_project.dto;

import java.time.LocalDate;

public class PaymentDto {
    private String id;
    private double amount;
    private LocalDate date;
    private String cusId;
    private String cusName;

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

    @Override
    public String toString() {
        return "PaymentDto{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", cusId='" + cusId + '\'' +
                ", cusName='" + cusName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
//public PaymentDto(String id, double amount, String cusId, String cusName, LocalDate date){}
    public PaymentDto(String id, double amount, String cusId, String cusName,LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.cusId = cusId;
        this.cusName = cusName;
        this.date = date;
    }
}
