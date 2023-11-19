package lk.ijse.yummy_food_project.dto.tm;

import java.time.LocalDate;

public class SavePaymentTm {
    private String id;
    private double amount;
    private String cusId;
    private String cusName;
    private LocalDate date;

    @Override
    public String toString() {
        return "SavePaymentTm{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", cusId='" + cusId + '\'' +
                ", cusName='" + cusName + '\'' +
                ", date=" + date +
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public SavePaymentTm(String id, double amount, String cusId, String cusName, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.cusId = cusId;
        this.cusName = cusName;
        this.date = date;
    }
}
