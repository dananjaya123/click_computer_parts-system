package lk.ijse.gdse.computerParts.service.custom.impl;

import lk.ijse.gdse.computerParts.business.BusinessFactory;
import lk.ijse.gdse.computerParts.business.custom.OrderDetailBusiness;
import lk.ijse.gdse.computerParts.dto.OrderDetailsDTO;
import lk.ijse.gdse.computerParts.observer.Observer;
import lk.ijse.gdse.computerParts.service.custom.OrderDetailsService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OrderDetailServiceImpl extends UnicastRemoteObject implements OrderDetailsService {

    OrderDetailBusiness orderDetailBusiness= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.ORDERDETAILS);

    public OrderDetailServiceImpl() throws RemoteException {
    }

    @Override
    public boolean addOrderDetail(OrderDetailsDTO orderDetailsDTO) throws Exception {
        return orderDetailBusiness.addOrderDetail(orderDetailsDTO);
    }

    @Override
    public boolean deleteOrderDetail(OrderDetailsDTO orderDetailsDTO) throws Exception {
        return orderDetailBusiness.deleteOrderDetail(orderDetailsDTO);
    }

    @Override
    public boolean updateOrderDetail(OrderDetailsDTO orderDetailsDTO) throws Exception {
        return orderDetailBusiness.updateOrderDetail(orderDetailsDTO);
    }

    @Override
    public void register(Observer observer) throws Exception {

    }

    @Override
    public void unregister(Observer observer) throws Exception {

    }

    @Override
    public void notifyAllObservers(String message) throws Exception {

    }

    @Override
    public boolean reserved(Object id) throws Exception {
        return false;
    }

    @Override
    public boolean released(Object id) throws Exception {
        return false;
    }
}
