package lk.ijse.yummy_food_project.dto;

public class IngredientsDto {
    private String id;
    private String name;
    private double price;
    private double qty;
   // private Button btn;


    @Override
    public String toString() {
        return "IngredientsDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", qty='" + qty + '\'' +
               // ", btn=" + btn +
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
public IngredientsDto(String id, String name, double price, double qty){}

  /*  public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }*/

    public IngredientsDto(String id, String name, double price, double qty, String pId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
      //  this.btn = btn;
    }
}
