package lk.ijse.yummy_food_project.dto.tm;

import lk.ijse.yummy_food_project.dto.CustomerDto;

public class CustomerTm extends CustomerDto {
    private String id;
    private String name;
    private String address;
    private String tel;
    private  String userId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public CustomerTm(String id, String name, String address, String tel, String userId) {
        super(id, name, address, tel, userId);
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
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

  /* public CustomerTm(){
      // super(id, name, orderType, time, cusId, driverId);
   }*/

    @Override
    public String toString() {
        return "CustomerTm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
