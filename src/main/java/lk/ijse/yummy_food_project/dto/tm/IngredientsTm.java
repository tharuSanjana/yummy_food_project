package lk.ijse.yummy_food_project.dto.tm;

import lk.ijse.yummy_food_project.dto.IngredientsDto;

public class IngredientsTm extends IngredientsDto {
    private String id;
    private String name;
    private double price;
    private double qty;
    private String pId;


    @Override
    public String toString() {
        return "IngredientsTm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", pId='" + pId + '\'' +
                '}';
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getQty() {
        return qty;
    }

    @Override
    public void setQty(double qty) {
        this.qty = qty;
    }

    @Override
    public String getpId() {
        return pId;
    }

    @Override
    public void setpId(String pId) {
        this.pId = pId;
    }

    public IngredientsTm(String id, String name, double price, double qty, String pId) {
        super(id, name, price, qty, pId);
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.pId = pId;
    }
}
