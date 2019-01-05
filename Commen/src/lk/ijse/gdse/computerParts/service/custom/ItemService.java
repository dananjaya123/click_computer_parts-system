package lk.ijse.gdse.computerParts.service.custom;

import lk.ijse.gdse.computerParts.dto.ItemDTO;
import lk.ijse.gdse.computerParts.observer.Subject;
import lk.ijse.gdse.computerParts.reservation.Reservation;
import lk.ijse.gdse.computerParts.service.SuperService;

import java.util.List;

public interface ItemService extends SuperService, Reservation, Subject {
     boolean addItem(ItemDTO itemDTO)throws Exception;
     boolean deleteItem(ItemDTO itemDTO)throws Exception;
     boolean updateItem(ItemDTO itemDTO)throws Exception;
     ItemDTO searchItem(String id)throws Exception;
     List<ItemDTO>getAllItem()throws Exception;
}
