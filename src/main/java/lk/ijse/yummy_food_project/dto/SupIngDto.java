package lk.ijse.yummy_food_project.dto;

public class SupIngDto {
    private String pId;
    private String sId;
    private String supName;
    private String indId;
    private String ingName;
    private double qty;
    private double unitePrice;
    private double total;

    public SupIngDto(String pId, String sId, String supName, String indId, String ingName, double qty, double unitePrice, double total) {
        this.pId = pId;
        this.sId = sId;
        this.supName = supName;
        this.indId = indId;
        this.ingName = ingName;
        this.qty = qty;
        this.unitePrice = unitePrice;
        this.total = total;
    }

    @Override
    public String toString() {
        return "SupIngDto{" +
                "pId='" + pId + '\'' +
                ", sId='" + sId + '\'' +
                ", supName='" + supName + '\'' +
                ", indId='" + indId + '\'' +
                ", ingName='" + ingName + '\'' +
                ", qty=" + qty +
                ", unitePrice=" + unitePrice +
                ", total=" + total +
                '}';
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

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
}
