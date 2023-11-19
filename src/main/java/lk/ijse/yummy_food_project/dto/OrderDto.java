package lk.ijse.yummy_food_project.dto;

import lk.ijse.yummy_food_project.dto.tm.CartTm;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class OrderDto {
    private String id;
    private LocalDate date;
    private String orderType;
    private LocalTime time;
    private String cusId;
    private String empId;
public OrderDto (String orderType, String cusId, String empId, List<CartTm> cartTmList){}
    public OrderDto(String id, LocalDate date, String orderType, LocalTime time, String cusId, String empId) {
        this.id = id;
        this.date = date;
        this.orderType = orderType;
        this.time = time;
        this.cusId = cusId;
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", orderType='" + orderType + '\'' +
                ", time=" + time +
                ", cusId='" + cusId + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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
}
