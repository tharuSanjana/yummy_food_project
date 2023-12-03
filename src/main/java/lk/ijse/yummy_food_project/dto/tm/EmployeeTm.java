package lk.ijse.yummy_food_project.dto.tm;

import lk.ijse.yummy_food_project.dto.EmployeeDto;

public class EmployeeTm extends EmployeeDto {
    private String id;
    private String name;
    private String address;
    private String tel;
    private String type;
    private String userId;


    @Override
    public String toString() {
        return "EmployeeTm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", type='" + type + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public EmployeeTm(String id, String name, String address, String tel, String type, String userId) {
        super(id,name,address,tel,type,userId);
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.type = type;
        this.userId = userId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
