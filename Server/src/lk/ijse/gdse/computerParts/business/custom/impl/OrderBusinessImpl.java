package lk.ijse.gdse.computerParts.business.custom.impl;

import lk.ijse.gdse.computerParts.business.custom.OrderBusiness;
import lk.ijse.gdse.computerParts.dto.CommenDTO;
import lk.ijse.gdse.computerParts.dto.OrderDetailsDTO;
import lk.ijse.gdse.computerParts.dto.OrdersDTO;
import lk.ijse.gdse.computerParts.entity.*;
import lk.ijse.gdse.computerParts.repository.RepoFactory;
import lk.ijse.gdse.computerParts.repository.custom.OrderDetailRepo;
import lk.ijse.gdse.computerParts.repository.custom.OrderRepo;
import lk.ijse.gdse.computerParts.repository.custom.PaymentRepo;
import lk.ijse.gdse.computerParts.resources.HibernetUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderBusinessImpl implements OrderBusiness {
    OrderRepo orderRepo= RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.ORDER);
    PaymentRepo paymentRepo=RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.PAYMENT);
    OrderDetailRepo orderDetailRepo=RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.ORDERDETAIL);
    public OrderBusinessImpl() {
    }

    @Override
    public boolean addOder(CommenDTO commenDTO) throws Exception {
        List<OrderDetails>orderDetails=new ArrayList<>();
        try (Session session= HibernetUtil.getSessionFactory().openSession()){
            Customer customer=session.get(Customer.class,commenDTO.getOrdersDTO().getCid());
            Reception reception=session.get(Reception.class,commenDTO.getOrdersDTO().getRid());

            paymentRepo.setSession(session);
            orderRepo.setSession(session);
            orderDetailRepo.setSession(session);

            session.beginTransaction();

            Orders orders=new Orders(commenDTO.getOrdersDTO().getOid(),new Date(),commenDTO.getOrdersDTO().getStatus(),customer,reception);
            Payment payment=new Payment(commenDTO.getPaymentDTO().getPid(),commenDTO.getPaymentDTO().getPayment(),new Date());

            orderRepo.add(orders);
            orders.setPayment(payment);
            paymentRepo.add(payment);

            for (OrderDetailsDTO orderDetailsDTO: commenDTO.getOrderDetailsDTOS()){
                Orders orders1=new Orders(orderDetailsDTO.getOid());
                Item item=new Item(orderDetailsDTO.getIid());
                int  qty=orderDetailsDTO.getQty();//oder ui eken ganna qty eka
                System.out.println(qty);

                Item item1=session.get(Item.class,orderDetailsDTO.getIid());
                int qua=item1.getQty();//item tble eke thina qty eka
                System.out.println(qua);

                double unitPrice=orderDetailsDTO.getUnitPrice();

                int quantity=qua-qty;//ui eke qty eken adu karanawa item table eke qty eka
                Query query = session.createSQLQuery("UPDATE item SET qty='"+ quantity+"' " + " where iid='"+ orderDetailsDTO.getIid() +"'");//Item table eke update eka
                query.executeUpdate();


                OrderDetails orderDetails1=new OrderDetails(qty,unitPrice,orderDetailsDTO.getTotal(),item,orders1);
                orderDetailRepo.add(orderDetails1);
            }
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteOder(OrdersDTO ordersDTO) throws Exception {
        return false;
    }

    @Override
    public boolean updateOder(OrdersDTO ordersDTO) throws Exception {
        return false;
    }

    @Override
    public OrdersDTO searchOder(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrdersDTO> getAllOder() throws Exception {
        ArrayList<OrdersDTO>ordersDTOS=new ArrayList<>();
        try (Session session=HibernetUtil.getSessionFactory().openSession()){
            orderRepo.setSession(session);
            session.getTransaction().begin();
            List<Orders>orders=orderRepo.getAll();
            for (Orders orders1:orders){
                ordersDTOS.add(new OrdersDTO(orders1.getOid(),orders1.getDate(),orders1.getStatus(),orders1.getCustomer().getCid(),orders1.getPayment().getPid(),orders1.getReception().getRid()));
            }

            session.getTransaction().commit();

        }
        return ordersDTOS;
    }
}
