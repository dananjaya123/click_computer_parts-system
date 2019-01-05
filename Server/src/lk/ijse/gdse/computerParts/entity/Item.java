package lk.ijse.gdse.computerParts.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @Id
    private String iid;
    private String itemName;
    private String itemBrand;
    private String discription;
    private int qty;
    private Double unitPrice;


    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private List<OrderDetails>orderDetails=new ArrayList<>();

    public Item() {
    }

    public Item(String iid, String itemName, String itemBrand, String discription, int qty, Double unitPrice) {
        this.iid = iid;
        this.itemName = itemName;
        this.itemBrand = itemBrand;
        this.discription = discription;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public Item(String iid, String itemName, String itemBrand, String discription, int qty, Double unitPrice, List<OrderDetails> orderDetails) {
        this.iid = iid;
        this.itemName = itemName;
        this.itemBrand = itemBrand;
        this.discription = discription;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.orderDetails = orderDetails;
    }

    public Item(String iid) {
        this.iid = iid;
    }


    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getItemName() {
        return itemName;
    }

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

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }
//
    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "ItemRepo{" +
                "iid='" + iid + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemBrand='" + itemBrand + '\'' +
                ", discription='" + discription + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
