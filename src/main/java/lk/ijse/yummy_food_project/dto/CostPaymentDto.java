package lk.ijse.yummy_food_project.dto;

import java.time.LocalDate;

public class CostPaymentDto {
    private LocalDate date;
    private String PId;
    private String SId;
    private String SName;
    private double amount;

    @Override
    public String toString() {
        return "CostPaymentDto{" +
                "date=" + date +
                ", pId='" + PId + '\'' +
                ", sId='" + SId + '\'' +
                ", sName='" + SName + '\'' +
                ", amount='" + amount + '\'' +
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

    public String getSId() {
        return SId;
    }

    public void setSId(String SId) {
        this.SId = SId;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CostPaymentDto(LocalDate date, String PId, String SId, String SName, double amount) {
        this.date = date;
        this.PId = PId;
        this.SId = SId;
        this.SName = SName;
        this.amount = amount;
    }
}
