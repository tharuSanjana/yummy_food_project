package lk.ijse.yummy_food_project.dto.tm;

import lk.ijse.yummy_food_project.dto.PaymentDto;

import java.time.LocalDate;

public class PaymentTm extends PaymentDto {
    private String id;
    private double amount;
    private LocalDate date;
    private String cusId;
    private String cusName;

    @Override
    public String toString() {
        return "PaymentTm{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", cusId='" + cusId + '\'' +
                ", cusName='" + cusName + '\'' +
                '}';
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String getCusId() {
        return cusId;
    }

    @Override
    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    @Override
    public String getCusName() {
        return cusName;
    }

    @Override
    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public PaymentTm(String id, double amount, String cusId, String cusName, LocalDate date) {
        super(id, amount, cusId, cusName, date);
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.cusId = cusId;
        this.cusName = cusName;
    }
}
//}
