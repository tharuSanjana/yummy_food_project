package lk.ijse.yummy_food_project.dto;

import lk.ijse.yummy_food_project.dto.tm.SupplierTm;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDto {
    private String id;
    private String name;

    private String tel;


    @Override
    public String toString() {
        return "SupplierDto{" +
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



    public SupplierDto(String id, String name,  String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;

    }
}
