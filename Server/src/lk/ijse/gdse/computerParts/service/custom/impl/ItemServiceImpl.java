package lk.ijse.gdse.computerParts.service.custom.impl;

import lk.ijse.gdse.computerParts.ReservationImpl.ReservationImpl;
import lk.ijse.gdse.computerParts.business.BusinessFactory;
import lk.ijse.gdse.computerParts.business.custom.ItemBusiness;
import lk.ijse.gdse.computerParts.dto.ItemDTO;
import lk.ijse.gdse.computerParts.observer.Observer;
import lk.ijse.gdse.computerParts.service.custom.ItemService;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl extends UnicastRemoteObject implements ItemService {

    ItemBusiness itemBusiness= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.ITEM);
    private static ArrayList<Observer> allItemObservers=new ArrayList<>();
    private static ReservationImpl<ItemService>itemServiceReservation=new ReservationImpl<>();

   public ItemServiceImpl() throws Exception {

    }

    @Override
    public boolean addItem(ItemDTO itemDTO) throws Exception {
        boolean add = itemBusiness.addItem(itemDTO);
        if (add){
            notifyAllObservers("add");
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteItem(ItemDTO itemDTO) throws Exception {
        return itemBusiness.deleteItem(itemDTO);
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws Exception {
        return itemBusiness.updateItem(itemDTO);
    }

    @Override
    public ItemDTO searchItem(String id) throws Exception {
        return itemBusiness.searchItem(id);
    }

    @Override
    public List<ItemDTO> getAllItem() throws Exception {
       ArrayList<ItemDTO>itemDTOS=itemBusiness.getAllItem();
       return itemDTOS;


    }

    @Override
    public void register(Observer observer) throws Exception {
        allItemObservers.add(observer);
    }

    @Override
    public void unregister(Observer observer) throws Exception {
       allItemObservers.remove(observer);
    }

    @Override
    public void notifyAllObservers(String message) throws Exception {
        for (Observer allObserver:allItemObservers){
            new Thread(()->{
                try {
                    allObserver.update(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    @Override
    public boolean reserved(Object id) throws Exception {
        return itemServiceReservation.reserve(id,this,true);
    }

    @Override
    public boolean released(Object id) throws Exception {
        return itemServiceReservation.release(id,this);
    }
}
