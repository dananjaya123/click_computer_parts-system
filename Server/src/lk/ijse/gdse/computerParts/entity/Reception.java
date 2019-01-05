package lk.ijse.gdse.computerParts.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reception {
    @Id
    private String rid;
    private String name;
    private String address;
    private int phoneNum;
    private String nic;
    private String pasword;
    @OneToMany(mappedBy = "reception",cascade = {CascadeType.ALL})
    private List<Orders>orders=new ArrayList<>();

    public Reception() {
    }

    public Reception(String rid, String name, String address, int phoneNum, String nic, String pasword, List<Orders> orders) {
        this.rid = rid;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.nic = nic;
        this.pasword = pasword;
        this.orders = orders;
    }

    public Reception(String rid, String name, String address, int phoneNum, String nic, String pasword) {
        this.rid = rid;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.nic = nic;
        this.pasword = pasword;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Reception{" +
                "rid='" + rid + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum=" + phoneNum +
                ", nic='" + nic + '\'' +
                ", pasword='" + pasword + '\'' +
                ", orders=" + orders +
                '}';
    }
}
