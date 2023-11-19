package lk.ijse.yummy_food_project.dto.tm;

import lk.ijse.yummy_food_project.dto.FoodDto;

public class FoodTm extends FoodDto {
    private String id;
    private String name;
    private double price;
    private String desc;

    @Override
    public String toString() {
        return "FoodTm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public FoodTm(String id, String name, Double price, String desc) {
        super(id,name,price,desc);
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }
}
