package lk.ijse.gdse.computerParts.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    private String cid;
    private String custName;
    private String custAddress;
    private int phoneNum;
    @OneToMany(mappedBy ="customer",cascade ={CascadeType.ALL})
    private List<Orders>orders=new ArrayList<>();

    public Customer() {
    }

    public Customer(String cid, String custName, String custAddress, int phoneNum) {
        this.cid = cid;
        this.custName = custName;
        this.custAddress = custAddress;
        this.phoneNum = phoneNum;
    }

    public Customer(String cid, String custName, String custAddress, int phoneNum, List<Orders> orders) {
        this.cid = cid;
        this.custName = custName;
        this.custAddress = custAddress;
        this.phoneNum = phoneNum;
        this.orders = orders;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid='" + cid + '\'' +
                ", custName='" + custName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", phoneNum=" + phoneNum +
                ", orders=" + orders +
                '}';
    }
}
