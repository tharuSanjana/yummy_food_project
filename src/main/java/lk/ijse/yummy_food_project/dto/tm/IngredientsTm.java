package lk.ijse.yummy_food_project.dto.tm;

import javafx.scene.control.Button;
import lk.ijse.yummy_food_project.dto.IngredientsDto;

public class IngredientsTm extends IngredientsDto {
    private String id;
    private String name;
    private double price;
    private double qty;
    //private double total;
   // private Button btn;


    @Override
    public String toString() {
        return "IngredientsTm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                //", total=" + total +
               // ", btn=" + btn +
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

    public void setQty(double qty) {
        this.qty = qty;
    }





    public IngredientsTm(String id, String name, double price, double qty) {
        super(id, name, price, qty);
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        //this.total = total;
       // this.btn = btn;
    }
}
