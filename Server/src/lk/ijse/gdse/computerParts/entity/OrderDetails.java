package lk.ijse.gdse.computerParts.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class OrderDetails implements Serializable {
    private int qty;
    private Double unitPrice;
    private Double total;

    @Id
    @ManyToOne(cascade = {CascadeType.ALL})
    Item item;
    @Id
    @ManyToOne(cascade = {CascadeType.ALL})
    Orders orders;

    public OrderDetails() {
    }

    public OrderDetails(int qty, Double unitPrice, Double total) {
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    public OrderDetails(int qty, Double unitPrice, Double total, Item item, Orders orders) {
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
        this.item = item;
        this.orders = orders;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "qty=" + qty +
                ", total=" + total +
                ", item=" + item +
                ", orders=" + orders +
                '}';
    }
}
