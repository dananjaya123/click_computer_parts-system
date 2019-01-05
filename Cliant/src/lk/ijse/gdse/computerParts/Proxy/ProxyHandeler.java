package lk.ijse.gdse.computerParts.Proxy;

import lk.ijse.gdse.computerParts.service.ServiceFactory;
import lk.ijse.gdse.computerParts.service.custom.*;

import java.rmi.Naming;

public class ProxyHandeler implements ServiceFactory {


    private static ProxyHandeler proxyHandeler;
    private CustomerService customerService;
    private ItemService itemService;
    private OrderService orderService;
    private PaymentService paymentService;
    private ReceptionService receptionService;
    private OrderDetailsService orderDetailsService;
    private UserSettingService userSettingService;

    public static ProxyHandeler getInstance()throws Exception{
        if(proxyHandeler==null){
            proxyHandeler=new ProxyHandeler();
        }
        return proxyHandeler;
    }

    public ProxyHandeler()throws Exception{
        ServiceFactory serviceFactory=(ServiceFactory) Naming.lookup("rmi://localhost:5060/ijse");
        try {
            customerService=serviceFactory.getSuperService(ServiceTypes.CUSTOMER);
            itemService=serviceFactory.getSuperService(ServiceTypes.ITEM);
            orderService=serviceFactory.getSuperService(ServiceTypes.ODER);
            paymentService=serviceFactory.getSuperService(ServiceTypes.PAYMENT);
            receptionService=serviceFactory.getSuperService(ServiceTypes.RECEPTION);
            orderDetailsService=serviceFactory.getSuperService(ServiceTypes.ORDERdETAILS);
            userSettingService=serviceFactory.getSuperService(ServiceTypes.USER);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public <T> T getSuperService(ServiceTypes types) throws Exception {
       switch (types){
           case CUSTOMER:
               return (T) customerService;

           case ITEM:
               return (T) itemService;

           case ODER:
               return (T) orderService;

           case PAYMENT:
               return (T) paymentService;

           case RECEPTION:
               return (T) receptionService;

           case ORDERdETAILS:
               return (T) orderDetailsService;

           case USER:
               return (T) userSettingService;

               default:
                   return null;
       }
    }
}
