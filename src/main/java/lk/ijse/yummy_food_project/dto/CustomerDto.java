package lk.ijse.yummy_food_project.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CustomerDto {
    private String id;
    private String name;
    private String address;
    private String tel;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public CustomerDto(){}

    public CustomerDto(String id, String name, String address, String tel, String userId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


}
