package lk.ijse.yummy_food_project.dto.tm;

import lk.ijse.yummy_food_project.dto.SupplierDto;

public class SupplierTm extends SupplierDto {
    private String id;
    private String name;

    private String tel;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SupplierTm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public SupplierTm(String id, String name, String tel, String email) {
        super(id, name, tel,email);
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.email = email;
    }
}
