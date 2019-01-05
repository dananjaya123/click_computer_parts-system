package lk.ijse.gdse.computerParts.dto;

public class ItemDTO implements SuperDTO {
    private String iid;
    private String itemName;
    private String itemBrand;
    private String discription;
    private int qty;
    private Double unitPrice;

    public ItemDTO() {
    }

    public ItemDTO(String iid, String itemName, String itemBrand, String discription, int qty, Double unitPrice) {
        this.iid = iid;
        this.itemName = itemName;
        this.itemBrand = itemBrand;
        this.discription = discription;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getItemName() { return itemName;   }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "iid='" + iid + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemBrand='" + itemBrand + '\'' +
                ", discription='" + discription + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
