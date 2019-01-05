package lk.ijse.gdse.computerParts.service.custom;

import lk.ijse.gdse.computerParts.dto.CustomerDTO;
import lk.ijse.gdse.computerParts.observer.Subject;
import lk.ijse.gdse.computerParts.reservation.Reservation;
import lk.ijse.gdse.computerParts.service.SuperService;

import java.util.List;

public interface CustomerService extends SuperService, Reservation, Subject {
    public boolean addCustomer(CustomerDTO customerDTO)throws Exception;
    public boolean deleteCustomer(CustomerDTO customerDTO)throws Exception;
    public boolean updateCustomer(CustomerDTO customerDTO)throws Exception;
    public CustomerDTO searshCustomer(String id)throws Exception;
    public List<CustomerDTO>getAllCustomer()throws Exception;
}
