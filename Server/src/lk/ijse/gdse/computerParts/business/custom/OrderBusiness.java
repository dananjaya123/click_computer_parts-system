package lk.ijse.gdse.computerParts.business.custom;

import lk.ijse.gdse.computerParts.business.SuperBusiness;
import lk.ijse.gdse.computerParts.dto.CommenDTO;
import lk.ijse.gdse.computerParts.dto.OrdersDTO;

import java.util.ArrayList;

public interface OrderBusiness extends SuperBusiness {
    public boolean addOder(CommenDTO commenDTO)throws Exception;
    public boolean deleteOder(OrdersDTO ordersDTO)throws  Exception;
    public boolean updateOder(OrdersDTO ordersDTO)throws Exception;
    public OrdersDTO searchOder(String id)throws Exception;
    public ArrayList<OrdersDTO> getAllOder()throws Exception;
}
