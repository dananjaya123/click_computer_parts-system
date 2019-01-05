package lk.ijse.gdse.computerParts.dto;

public class ReceptionDTO implements SuperDTO {
    private String rid;
    private String name;
    private String address;
    private int phoneNum;
    private String nic;
    private String pasword;


    public ReceptionDTO() {
    }

    public ReceptionDTO(String rid, String name, String address, int phoneNum, String nic, String pasword) {
        this.rid = rid;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.nic = nic;
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

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    @Override
    public String toString() {
        return "ReceptionDTO{" +
                "rid='" + rid + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum=" + phoneNum +
                ", nic='" + nic + '\'' +
                ", pasword='" + pasword + '\'' +
                '}';
    }
}
