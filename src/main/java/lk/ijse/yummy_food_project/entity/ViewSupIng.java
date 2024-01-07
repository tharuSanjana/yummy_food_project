package lk.ijse.yummy_food_project.entity;

public class ViewSupIng {
    private String supId;
    private String ingId;
    private String supName;
    private String ingName;
    private double total;
    private String PId;

    @Override
    public String toString() {
        return "ViewSupIngDto{" +
                "supId='" + supId + '\'' +
                ", ingId='" + ingId + '\'' +
                ", supName='" + supName + '\'' +
                ", ingName='" + ingName + '\'' +
                ", total=" + total +
                ", pId='" + PId + '\'' +
                '}';
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public String getIngId() {
        return ingId;
    }

    public void setIngId(String ingId) {
        this.ingId = ingId;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getIngName() {
        return ingName;
    }

    public void setIngName(String ingName) {
        this.ingName = ingName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPId() {
        return PId;
    }

    public void setPId(String PId) {
        this.PId = PId;
    }

    public ViewSupIng(String supId, String ingId, String supName, String ingName, double total, String PId) {
        this.supId = supId;
        this.ingId = ingId;
        this.supName = supName;
        this.ingName = ingName;
        this.total = total;
        this.PId = PId;
    }
}
