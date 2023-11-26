package lk.ijse.yummy_food_project.dto.tm;

import lk.ijse.yummy_food_project.dto.SupplierDto;

import java.awt.*;

public class SupplierTm extends SupplierDto {
    private String id;
    private String name;

    private String tel;

    @Override
    public String toString() {
        return "SupplierTm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
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

    public SupplierTm(String id, String name, String tel) {
        super(id,name,tel);
        this.id = id;
        this.name = name;
        this.tel = tel;
    }
}
