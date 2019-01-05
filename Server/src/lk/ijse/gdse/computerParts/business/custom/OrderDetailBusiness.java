package lk.ijse.gdse.computerParts.business.custom;

import lk.ijse.gdse.computerParts.business.SuperBusiness;
import lk.ijse.gdse.computerParts.dto.OrderDetailsDTO;

public interface OrderDetailBusiness extends SuperBusiness {
    public boolean addOrderDetail(OrderDetailsDTO orderDetailsDTO)throws Exception;
    public boolean deleteOrderDetail(OrderDetailsDTO orderDetailsDTO)throws Exception;
    public boolean updateOrderDetail(OrderDetailsDTO orderDetailsDTO)throws Exception;
}
