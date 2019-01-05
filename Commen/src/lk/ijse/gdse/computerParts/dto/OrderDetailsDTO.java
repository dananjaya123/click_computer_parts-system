package lk.ijse.gdse.computerParts.dto;

public class OrderDetailsDTO implements SuperDTO {
    private String oid;
    private String iid;
    private int qty;
    private Double unitPrice;
    private Double total;


    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(String oid, String iid, int qty, Double unitPrice) {
        this.oid = oid;
        this.iid = iid;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public OrderDetailsDTO(String oid, String iid, int qty, Double unitPrice, Double total) {
        this.oid = oid;
        this.iid = iid;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }



    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" +
                "oid='" + oid + '\'' +
                ", iid='" + iid + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ", total=" + total +
                '}';
    }
}
