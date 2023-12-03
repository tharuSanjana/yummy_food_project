package lk.ijse.yummy_food_project.dto.tm;

import lk.ijse.yummy_food_project.dto.incomePaymentDto;

import java.time.LocalDate;

public class IncomePaymentTm extends incomePaymentDto {
    private LocalDate date;
    private String PId;
    private String CId;
    private String CName;
    private double amount;

    @Override
    public String toString() {
        return "IncomePaymentTm{" +
                "date=" + date +
                ", pId='" + PId + '\'' +
                ", cId='" + CId + '\'' +
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

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
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

    public IncomePaymentTm(LocalDate date, String PId, String CId, String CName, double amount) {
        super(date,PId,CId,CName,amount);
        this.date = date;
        this.PId = PId;
        this.CId = CId;
        this.CName = CName;
        this.amount = amount;
    }
}
