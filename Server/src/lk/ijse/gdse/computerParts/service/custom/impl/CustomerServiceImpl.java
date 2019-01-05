package lk.ijse.gdse.computerParts.service.custom.impl;

import lk.ijse.gdse.computerParts.ReservationImpl.ReservationImpl;
import lk.ijse.gdse.computerParts.business.BusinessFactory;
import lk.ijse.gdse.computerParts.business.custom.CustomerBusiness;
import lk.ijse.gdse.computerParts.dto.CustomerDTO;
import lk.ijse.gdse.computerParts.observer.Observer;
import lk.ijse.gdse.computerParts.reservation.Reservation;
import lk.ijse.gdse.computerParts.service.custom.CustomerService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {
   CustomerBusiness customerBusiness= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.CUSTOMER);
    private static ArrayList<Observer>allCustomerObservers=new ArrayList<>();
    private static ReservationImpl<CustomerService> customerServiceReservation=new ReservationImpl<>();
    public CustomerServiceImpl() throws RemoteException {

    }

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        return customerBusiness.addCustomer(customerDTO);
    }

    @Override
    public boolean deleteCustomer(CustomerDTO customerDTO) throws Exception {
        return customerBusiness.deleteCustomer(customerDTO);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return customerBusiness.updateCustomer(customerDTO);
    }

    @Override
    public CustomerDTO searshCustomer(String id) throws Exception {
        return customerBusiness.searshCustomer(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() throws Exception {
        return customerBusiness.getAllCustomer();
    }

    @Override
    public void register(Observer observer) throws Exception {
     allCustomerObservers.add(observer);
    }

    @Override
    public void unregister(Observer observer) throws Exception {
    allCustomerObservers.remove(observer);
    }

    @Override
    public void notifyAllObservers(String message) throws Exception {
    for (Observer allObserver:allCustomerObservers) {
     new Thread(() -> {
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
        return customerServiceReservation.reserve(id,this,true);
    }

    @Override
    public boolean released(Object id) throws Exception {
        return customerServiceReservation.release(id,this);
    }
}
