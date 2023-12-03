package lk.ijse.yummy_food_project.dto;

import java.time.LocalDate;

public class incomePaymentDto {
    private LocalDate date;
    private String PId;
    private String cId;
    private String CName;
    private double amount;

    @Override
    public String toString() {
        return "incomePaymentDto{" +
                "date=" + date +
                ", pId='" + PId + '\'' +
                ", cId='" + cId + '\'' +
                ", cName='" + CName + '\'' +
                ", amount=" + amount +
                '}';
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPId() {
        return PId;
    }

    public void setPId(String PId) {
        this.PId = PId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public incomePaymentDto(LocalDate date, String PId, String cId, String CName, double amount) {
        this.date = date;
        this.PId = PId;
        this.cId = cId;
        this.CName = CName;
        this.amount = amount;
    }
}
