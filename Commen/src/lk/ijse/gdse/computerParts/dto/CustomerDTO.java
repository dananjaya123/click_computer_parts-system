package lk.ijse.gdse.computerParts.dto;

public class CustomerDTO implements SuperDTO{
    private String cid;
    private String custName;
    private String custAddress;
    private int phoneNum;

    public CustomerDTO() {
    }

    public CustomerDTO(String cid, String custName, String custAddress, int phoneNum) {
        this.cid = cid;
        this.custName = custName;
        this.custAddress = custAddress;
        this.phoneNum = phoneNum;
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

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "cid='" + cid + '\'' +
                ", custName='" + custName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", phoneNum=" + phoneNum +
                '}';
    }
}
