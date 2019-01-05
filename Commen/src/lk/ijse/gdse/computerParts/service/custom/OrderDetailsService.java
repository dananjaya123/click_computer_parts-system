package lk.ijse.gdse.computerParts.service.custom;

import lk.ijse.gdse.computerParts.dto.OrderDetailsDTO;
import lk.ijse.gdse.computerParts.observer.Subject;
import lk.ijse.gdse.computerParts.reservation.Reservation;
import lk.ijse.gdse.computerParts.service.SuperService;

public interface OrderDetailsService extends SuperService, Reservation, Subject {
    public boolean addOrderDetail(OrderDetailsDTO orderDetailsDTO)throws Exception;
    public boolean deleteOrderDetail(OrderDetailsDTO orderDetailsDTO)throws Exception;
    public boolean updateOrderDetail(OrderDetailsDTO orderDetailsDTO)throws Exception;
}
