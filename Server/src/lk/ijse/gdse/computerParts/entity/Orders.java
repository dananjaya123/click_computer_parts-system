package lk.ijse.gdse.computerParts.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    private String oid;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String status;

    @ManyToOne(cascade = {CascadeType.ALL})
    Customer customer;


    @ManyToOne(cascade = {CascadeType.ALL})
    Payment payment;

    @ManyToOne(cascade = {CascadeType.ALL})
    Reception reception;

    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private List<OrderDetails>orderDetails=new ArrayList<>();

    public Orders() {
    }

    public Orders(String oid, Date date, String status) {
        this.oid = oid;
        this.date = date;
        this.status = status;
    }

    public Orders(String oid, Date date, String status, Customer customer, Payment payment, Reception reception, List<OrderDetails> orderDetails) {
        this.oid = oid;
        this.date = date;
        this.status = status;
        this.customer = customer;
        this.payment = payment;
        this.reception = reception;
        this.orderDetails = orderDetails;
    }

    public Orders(String oid, Date date, String status, Customer customer, Reception reception) {
        this.oid = oid;
        this.date = date;
        this.status = status;
        this.customer = customer;
        this.reception = reception;
    }

    public Orders(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid='" + oid + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                ", payment=" + payment +
                ", reception=" + reception +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
