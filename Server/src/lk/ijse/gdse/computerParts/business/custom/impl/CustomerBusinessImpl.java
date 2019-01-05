package lk.ijse.gdse.computerParts.business.custom.impl;

import lk.ijse.gdse.computerParts.business.custom.CustomerBusiness;
import lk.ijse.gdse.computerParts.dto.CustomerDTO;
import lk.ijse.gdse.computerParts.entity.Customer;
import lk.ijse.gdse.computerParts.repository.RepoFactory;
import lk.ijse.gdse.computerParts.repository.custom.CustomerRepo;
import lk.ijse.gdse.computerParts.resources.HibernetUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CustomerBusinessImpl implements CustomerBusiness {

    CustomerRepo customerRepo= RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.CUSTOMER);

    public CustomerBusinessImpl() {
    }

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        try (Session session= HibernetUtil.getSessionFactory().openSession()){
            customerRepo.setSession(session);
            session.getTransaction().begin();
            session.save(new Customer(customerDTO.getCid(),customerDTO.getCustName(),customerDTO.getCustAddress(),customerDTO.getPhoneNum()));
            session.getTransaction().commit();

        }
        return false;
    }

    @Override
    public boolean deleteCustomer(CustomerDTO customerDTO) throws Exception {
       try (Session session=HibernetUtil.getSessionFactory().openSession()){
           customerRepo.setSession(session);
           session.getTransaction().begin();
           session.delete(new Customer(customerDTO.getCid(),customerDTO.getCustName(),customerDTO.getCustAddress(),customerDTO.getPhoneNum()));
           session.getTransaction().commit();

       }
       return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        try (Session session=HibernetUtil.getSessionFactory().openSession()){
            customerRepo.setSession(session);
            session.getTransaction().begin();
            session.update(new Customer(customerDTO.getCid(),customerDTO.getCustName(),customerDTO.getCustAddress(),customerDTO.getPhoneNum()));
            session.getTransaction().commit();
        }
        return false;
    }

    @Override
    public CustomerDTO searshCustomer(String id) throws Exception {
        try (Session session=HibernetUtil.getSessionFactory().openSession()){
            customerRepo.setSession(session);
            session.getTransaction().begin();
            Customer search = customerRepo.search(id);
            session.getTransaction().commit();
            return new CustomerDTO(search.getCid(),search.getCustName(),search.getCustAddress(),search.getPhoneNum());
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomer() throws Exception {
        ArrayList<CustomerDTO>customerDTOS=new ArrayList<>();
        try (Session session=HibernetUtil.getSessionFactory().openSession()){
            customerRepo.setSession(session);
            session.getTransaction().begin();
            List<Customer >customers=customerRepo.getAll();
            for (Customer customer:customers){
                customerDTOS.add(new CustomerDTO(customer.getCid(),customer.getCustName(),customer.getCustAddress(),customer.getPhoneNum()));
            }
            session.getTransaction().commit();
         return customerDTOS;
        }
    }
}
