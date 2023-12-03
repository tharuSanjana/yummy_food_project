package lk.ijse.yummy_food_project.dto.tm;
import javafx.scene.control.Button;
import java.awt.*;

public class SupIngTm {
    //private String pId;
    //private String sId;
    private String supName;
    private String indId;
    private String ingName;
    private double qty;
    private double unitePrice;
    private double total;
    private Button btn;



    @Override
    public String toString() {
        return "SupIngTm{" +

                ", supName='" + supName + '\'' +
                ", indId='" + indId + '\'' +
                ", ingName='" + ingName + '\'' +
                ", qty=" + qty +
                ", unitePrice=" + unitePrice +
                ", total=" + total +
                ", btn=" + btn +
                '}';
    }

    public SupIngTm( String supName, String indId, String ingName, double qty, double unitePrice, double total, Button btn) {

        this.supName = supName;
        this.indId = indId;
        this.ingName = ingName;
        this.qty = qty;
        this.unitePrice = unitePrice;
        this.total = total;
        this.btn = btn;
    }
public SupIngTm(){}


    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getIndId() {
        return indId;
    }

    public void setIndId(String indId) {
        this.indId = indId;
    }

    public String getIngName() {
        return ingName;
    }

    public void setIngName(String ingName) {
        this.ingName = ingName;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(double unitePrice) {
        this.unitePrice = unitePrice;
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
