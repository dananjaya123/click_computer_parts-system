package lk.ijse.gdse.computerParts.dto;

import java.util.Date;

public class PaymentDTO implements SuperDTO {
    private String pid;
    private Double payment;
    private Date date;


    public PaymentDTO() {
    }

    public PaymentDTO(String pid, Double payment, Date date) {
        this.pid = pid;
        this.payment = payment;
        this.date = date;
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

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "pid='" + pid + '\'' +
                ", payment=" + payment +
                ", date=" + date +
                '}';
    }
}
