package lk.ijse.gdse.computerParts.service.custom.impl;

import lk.ijse.gdse.computerParts.ReservationImpl.ReservationImpl;
import lk.ijse.gdse.computerParts.business.BusinessFactory;
import lk.ijse.gdse.computerParts.business.custom.OrderBusiness;
import lk.ijse.gdse.computerParts.dto.CommenDTO;
import lk.ijse.gdse.computerParts.dto.OrdersDTO;
import lk.ijse.gdse.computerParts.observer.Observer;
import lk.ijse.gdse.computerParts.service.custom.OrderService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class OderServiceImpl extends UnicastRemoteObject implements OrderService {
    OrderBusiness orderBusiness= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.ORDER);
    private static ArrayList<Observer> allOderObservers=new ArrayList<>();
    private static ReservationImpl<OrderService>orderServiceReservation=new ReservationImpl<>();

    public OderServiceImpl() throws RemoteException {
    }


    @Override
    public boolean addOder(CommenDTO commenDTO) throws Exception {
        boolean add= orderBusiness.addOder(commenDTO);
        if (add){
            notifyAllObservers("add");
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteOder(OrdersDTO ordersDTO) throws Exception {
        return orderBusiness.deleteOder(ordersDTO);
    }

    @Override
    public boolean updateOder(OrdersDTO ordersDTO) throws Exception {
        return orderBusiness.updateOder(ordersDTO);
    }

    @Override
    public OrdersDTO searchOder(String id) throws Exception {
        return orderBusiness.searchOder(id);
    }

    @Override
    public List<OrdersDTO> getAllOder() throws Exception {
        List<OrdersDTO>ordersDTOS=orderBusiness.getAllOder();
        return ordersDTOS;
    }

    @Override
    public void register(Observer observer) throws Exception {
        allOderObservers.add(observer);
    }

    @Override
    public void unregister(Observer observer) throws Exception {
        allOderObservers.remove(observer);
    }

    @Override
    public void notifyAllObservers(String message) throws Exception {
        for (Observer allObserver:allOderObservers){
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
        return orderServiceReservation.reserve(id,this,true);
    }

    @Override
    public boolean released(Object id) throws Exception {
        return orderServiceReservation.release(id,this);
    }
}
