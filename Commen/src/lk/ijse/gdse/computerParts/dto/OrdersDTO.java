package lk.ijse.gdse.computerParts.dto;

import java.util.Date;

public class OrdersDTO implements SuperDTO {
    private String oid;
    private Date date;
    private String status;
    private String cid;
    private String pid;
    private String rid;

    public OrdersDTO() {
    }

    public OrdersDTO(String oid, Date date, String status, String cid, String pid, String rid) {
        this.oid = oid;
        this.date = date;
        this.status = status;
        this.cid = cid;
        this.pid = pid;
        this.rid = rid;
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

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "oid='" + oid + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", cid='" + cid + '\'' +
                ", pid='" + pid + '\'' +
                ", rid='" + rid + '\'' +
                '}';
    }
}
