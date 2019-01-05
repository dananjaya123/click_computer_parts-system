package lk.ijse.gdse.computerParts.business.custom.impl;

import lk.ijse.gdse.computerParts.business.custom.PaymentBusiness;
import lk.ijse.gdse.computerParts.dto.PaymentDTO;
import lk.ijse.gdse.computerParts.repository.RepoFactory;
import lk.ijse.gdse.computerParts.repository.custom.PaymentRepo;

import java.util.List;

public class PaymentBusinessImpl implements PaymentBusiness {
    PaymentRepo paymentRepo= RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.PAYMENT);
    public PaymentBusinessImpl() {
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
}
