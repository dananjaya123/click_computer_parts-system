package lk.ijse.gdse.computerParts.dto;

import java.util.List;

public class CommenDTO implements SuperDTO {
    private OrdersDTO ordersDTO;
    private PaymentDTO paymentDTO;
    private List<OrderDetailsDTO>orderDetailsDTOS;

    public CommenDTO() {
    }

    public CommenDTO(OrdersDTO ordersDTO, PaymentDTO paymentDTO) {
        this.ordersDTO = ordersDTO;
        this.paymentDTO = paymentDTO;
    }

    public CommenDTO(OrdersDTO ordersDTO, PaymentDTO paymentDTO, List<OrderDetailsDTO> orderDetailsDTOS) {
        this.ordersDTO = ordersDTO;
        this.paymentDTO = paymentDTO;
        this.orderDetailsDTOS = orderDetailsDTOS;
    }

    public OrdersDTO getOrdersDTO() {
        return ordersDTO;
    }

    public void setOrdersDTO(OrdersDTO ordersDTO) {
        this.ordersDTO = ordersDTO;
    }

    public PaymentDTO getPaymentDTO() {
        return paymentDTO;
    }

    public void setPaymentDTO(PaymentDTO paymentDTO) {
        this.paymentDTO = paymentDTO;
    }

    public List<OrderDetailsDTO> getOrderDetailsDTOS() {
        return orderDetailsDTOS;
    }

    public void setOrderDetailsDTOS(List<OrderDetailsDTO> orderDetailsDTOS) {
        this.orderDetailsDTOS = orderDetailsDTOS;
    }

    @Override
    public String toString() {
        return "CommenDTO{" +
                "ordersDTO=" + ordersDTO +
                ", paymentDTO=" + paymentDTO +
                ", orderDetailsDTOS=" + orderDetailsDTOS +
                '}';
    }
}
