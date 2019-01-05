package lk.ijse.gdse.computerParts.business.custom;

import lk.ijse.gdse.computerParts.business.SuperBusiness;
import lk.ijse.gdse.computerParts.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemBusiness extends SuperBusiness {
    public boolean addItem(ItemDTO itemDTO)throws Exception;
    public boolean deleteItem(ItemDTO itemDTO)throws Exception;
    public boolean updateItem(ItemDTO itemDTO)throws Exception;
    public ItemDTO searchItem(String id)throws Exception;
    public ArrayList<ItemDTO> getAllItem()throws Exception;
}
