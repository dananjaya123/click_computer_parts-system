package lk.ijse.gdse.computerParts.business.custom;

import lk.ijse.gdse.computerParts.business.SuperBusiness;
import lk.ijse.gdse.computerParts.dto.PaymentDTO;

import java.util.List;

public interface PaymentBusiness extends SuperBusiness {
    public boolean addPayment(PaymentDTO paymentDTO)throws Exception;
    public boolean deletePayment(PaymentDTO paymentDTO)throws Exception;
    public boolean updatePayment(PaymentDTO paymentDTO)throws Exception;
    public PaymentDTO searchPayment(String id)throws Exception;
    public List<PaymentDTO> getAllPayment()throws Exception;
}
