package lk.ijse.gdse.computerParts.business.custom;

import lk.ijse.gdse.computerParts.business.SuperBusiness;
import lk.ijse.gdse.computerParts.dto.CustomerDTO;

import java.util.List;

public interface CustomerBusiness extends SuperBusiness {
    public boolean addCustomer(CustomerDTO customerDTO)throws Exception;
    public boolean deleteCustomer(CustomerDTO customerDTO)throws Exception;
    public boolean updateCustomer(CustomerDTO customerDTO)throws Exception;
    public CustomerDTO searshCustomer(String id)throws Exception;
    public List<CustomerDTO> getAllCustomer()throws Exception;
}
