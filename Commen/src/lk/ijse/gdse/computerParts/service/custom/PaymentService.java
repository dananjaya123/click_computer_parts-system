package lk.ijse.gdse.computerParts.service.custom;

import lk.ijse.gdse.computerParts.dto.PaymentDTO;
import lk.ijse.gdse.computerParts.observer.Subject;
import lk.ijse.gdse.computerParts.reservation.Reservation;
import lk.ijse.gdse.computerParts.service.SuperService;

import java.util.List;

public interface PaymentService extends SuperService, Reservation, Subject {
    public boolean addPayment(PaymentDTO paymentDTO)throws Exception;
    public boolean deletePayment(PaymentDTO paymentDTO)throws Exception;
    public boolean updatePayment(PaymentDTO paymentDTO)throws Exception;
    public PaymentDTO searchPayment(String id)throws Exception;
    public List<PaymentDTO> getAllPayment()throws Exception;
}
