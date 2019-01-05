package lk.ijse.gdse.computerParts.service.custom.impl;

import lk.ijse.gdse.computerParts.ReservationImpl.ReservationImpl;
import lk.ijse.gdse.computerParts.business.BusinessFactory;
import lk.ijse.gdse.computerParts.business.custom.ReceptionBusiness;
import lk.ijse.gdse.computerParts.dto.ReceptionDTO;
import lk.ijse.gdse.computerParts.entity.Reception;
import lk.ijse.gdse.computerParts.observer.Observer;
import lk.ijse.gdse.computerParts.service.custom.ReceptionService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ReceptionServiceImpl extends UnicastRemoteObject implements ReceptionService {
    ReceptionBusiness receptionBusiness= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.RECEPTION);
    private static ArrayList<Observer>allReceptionObserver=new ArrayList<>();
    private static ReservationImpl<ReceptionService>receptionServiceReservation=new ReservationImpl<>();
    public ReceptionServiceImpl() throws RemoteException {
    }

    @Override
    public boolean addReception(ReceptionDTO receptionDTO) throws Exception {
         boolean add= receptionBusiness.addReception(receptionDTO);
         if (add){
             notifyAllObservers("add");
             return true;
         }
         return false;
    }

    @Override
    public boolean deleteReception(ReceptionDTO receptionDTO) throws Exception {
        return receptionBusiness.deleteReception(receptionDTO);
    }

    @Override
    public boolean updateReception(ReceptionDTO receptionDTO) throws Exception {
        return receptionBusiness.updateReception(receptionDTO);
    }

    @Override
    public ReceptionDTO searchReception(String id) throws Exception {
        return receptionBusiness.searchReception(id);
    }

    @Override
    public List<ReceptionDTO> getAllReception() throws Exception {
        ArrayList<ReceptionDTO>receptionDTOS=receptionBusiness.getAllReception();
        return receptionDTOS;
    }

    @Override
    public void register(Observer observer) throws Exception {
        allReceptionObserver.add(observer);

    }

    @Override
    public void unregister(Observer observer) throws Exception {
        allReceptionObserver.remove(observer);

    }

    @Override
    public void notifyAllObservers(String message) throws Exception {
      for (Observer allObserver:allReceptionObserver){
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
        return receptionServiceReservation.reserve(id,this,true);
    }

    @Override
    public boolean released(Object id) throws Exception {
        return receptionServiceReservation.release(id,this);
    }
}
