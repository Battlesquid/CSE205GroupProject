package spring.model;

public class OrderItem {
    private String id;
    private int qty;

    public String getId() {
        return id;
    }

    public int getQty() {
        return qty;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
