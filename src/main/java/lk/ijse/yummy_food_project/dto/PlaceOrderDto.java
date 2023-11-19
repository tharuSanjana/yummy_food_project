package lk.ijse.yummy_food_project.dto;

import lk.ijse.yummy_food_project.dto.tm.CartTm;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderDto {
    private String oId;
    private LocalDate date;
    private String orderType;
    private LocalTime time;
    private String pId;
    private String empId;
    private String cusId;


    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
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

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    private List<CartTm> cartTmList = new ArrayList<>();
    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PlaceOrderDto{" +
                "oId='" + oId + '\'' +
                ", date=" + date +
                ", orderType='" + orderType + '\'' +
                ", time=" + time +
                ", pId='" + pId + '\'' +
                ", empId='" + empId + '\'' +
                ", cusId='" + cusId + '\'' +
                ", cartTmList=" + cartTmList +
                ", total=" + total +
                '}';
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public List<CartTm> getCartTmList() {
        return cartTmList;
    }

    public void setCartTmList(List<CartTm> cartTmList) {
        this.cartTmList = cartTmList;
    }
public PlaceOrderDto(){}


    public PlaceOrderDto(String oId, LocalDate date, String orderType, LocalTime time, String pId, String empId, String cusId, List<CartTm> cartTmList, double total) {
        this.oId = oId;
        this.date = date;
        this.orderType = orderType;
        this.time = time;
        this.pId = pId;
        this.empId = empId;
        this.cusId = cusId;
        this.cartTmList = cartTmList;
        this.total = total;
    }
}
