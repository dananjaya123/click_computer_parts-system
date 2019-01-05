package lk.ijse.gdse.computerParts.service.custom;

import lk.ijse.gdse.computerParts.dto.CommenDTO;
import lk.ijse.gdse.computerParts.dto.OrdersDTO;
import lk.ijse.gdse.computerParts.observer.Subject;
import lk.ijse.gdse.computerParts.reservation.Reservation;
import lk.ijse.gdse.computerParts.service.SuperService;

import java.util.List;

public interface OrderService extends SuperService, Reservation, Subject {
    public boolean addOder(CommenDTO commenDTO)throws Exception;
    public boolean deleteOder(OrdersDTO ordersDTO)throws  Exception;
    public boolean updateOder(OrdersDTO ordersDTO)throws Exception;
    public OrdersDTO searchOder(String id)throws Exception;
    public List<OrdersDTO>getAllOder()throws Exception;
}
