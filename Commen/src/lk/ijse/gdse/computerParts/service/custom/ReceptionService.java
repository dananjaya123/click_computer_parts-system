package lk.ijse.gdse.computerParts.service.custom;

import lk.ijse.gdse.computerParts.dto.ReceptionDTO;
import lk.ijse.gdse.computerParts.observer.Subject;
import lk.ijse.gdse.computerParts.reservation.Reservation;
import lk.ijse.gdse.computerParts.service.SuperService;

import java.util.List;

public interface ReceptionService extends SuperService, Reservation, Subject {
    public boolean addReception(ReceptionDTO receptionDTO)throws Exception;
    public boolean deleteReception(ReceptionDTO receptionDTO)throws Exception;
    public boolean updateReception(ReceptionDTO receptionDTO)throws Exception;
    public ReceptionDTO searchReception(String id)throws Exception;
    public List<ReceptionDTO> getAllReception()throws Exception;
}
