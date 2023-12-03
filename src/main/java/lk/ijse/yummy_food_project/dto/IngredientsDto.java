package lk.ijse.yummy_food_project.dto;

public class IngredientsDto {
    private String id;
    private String name;
    private double price;
    private double qty;
    private String pId;

    public void setQty(double qty) {
        this.qty = qty;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }
// private Button btn;


    @Override
    public String toString() {
        return "IngredientsDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", pId='" + pId + '\'' +
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
//public IngredientsDto(String id, String name, double price, double qty){}

  /*  public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }*/

    public IngredientsDto(String id, String name, double price, double qty,String pId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.pId = pId;
    }
}
