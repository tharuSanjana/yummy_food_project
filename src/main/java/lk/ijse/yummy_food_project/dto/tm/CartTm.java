package lk.ijse.yummy_food_project.dto.tm;

import java.time.LocalDate;
import java.time.LocalTime;
import javafx.scene.control.Button;

public class CartTm {
    //private String oId;
    private LocalDate date;
    private LocalTime time;
    private String foodId;
    private String foodName;
    private double price;
    private String description;
    private int qty;
    private double total;
    private Button btn;

    public CartTm(LocalDate date, LocalTime time, String foodId, String foodName, double price, String desc, int qty, double total, Button btn) {

        this.date = date;
        this.time = time;
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.description = desc;
        this.qty = qty;
        this.total = total;
        this.btn = btn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CartTm{" +
                "date=" + date +
                ", time=" + time +
                ", foodId='" + foodId + '\'' +
                ", foodName='" + foodName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", qty=" + qty +
                ", total=" + total +
                ", btn=" + btn +
                '}';
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }



}
