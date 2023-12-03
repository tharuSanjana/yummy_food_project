package lk.ijse.yummy_food_project.dto.tm;

import lk.ijse.yummy_food_project.dto.CostPaymentDto;

import java.time.LocalDate;

public class CostPaymentTm extends CostPaymentDto {

    private LocalDate date;
    private String PId;
    private String SId;
    private String sName;
    private double amount;

    @Override
    public String toString() {
        return "CostPaymentTm{" +
                "date=" + date +
                ", pId='" + PId + '\'' +
                ", sId='" + SId + '\'' +
                ", sName='" + sName + '\'' +
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

    public void setpId(String pId) {
        this.PId = PId;
    }

    public String getSId() {
        return SId;
    }

    public void setSId(String sId) {
        this.SId = SId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CostPaymentTm(LocalDate date, String PId, String SId, String sName, double amount) {
        super(date,PId,SId,sName,amount);
        this.date = date;
        this.PId = PId;
        this.SId = SId;
        this.sName = sName;
        this.amount = amount;
    }
}
