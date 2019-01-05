package lk.ijse.gdse.computerParts.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Payment {
    @Id
    private String pid;
    private Double payment;
    @Temporal(TemporalType.DATE)
    private Date date;


    @OneToMany(mappedBy = "payment",cascade = {CascadeType.ALL})
    private List<Orders>orders=new ArrayList<>();

    public Payment() {
    }

    public Payment(String pid, Double payment, Date date) {
        this.pid = pid;
        this.payment = payment;
        this.date = date;
    }

    public Payment(String pid, Double payment, Date date, List<Orders> orders) {
        this.pid = pid;
        this.payment = payment;
        this.date = date;
        this.orders = orders;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "pid='" + pid + '\'' +
                ", payment=" + payment +
                ", date=" + date +
                ", orders=" + orders +
                '}';
    }
}
