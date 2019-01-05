package lk.ijse.gdse.computerParts.service.custom.impl;

import lk.ijse.gdse.computerParts.dto.PaymentDTO;
import lk.ijse.gdse.computerParts.observer.Observer;
import lk.ijse.gdse.computerParts.service.custom.PaymentService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class PaymentServiceImpl extends UnicastRemoteObject implements PaymentService {

    public PaymentServiceImpl() throws RemoteException {
    }

    @Override
    public boolean addPayment(PaymentDTO paymentDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deletePayment(PaymentDTO paymentDTO) throws Exception {
        return false;
    }

    @Override
    public boolean updatePayment(PaymentDTO paymentDTO) throws Exception {
        return false;
    }

    @Override
    public PaymentDTO searchPayment(String id) throws Exception {
        return null;
    }

    @Override
    public List<PaymentDTO> getAllPayment() throws Exception {
        return null;
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
