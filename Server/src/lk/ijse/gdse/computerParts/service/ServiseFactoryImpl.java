package lk.ijse.gdse.computerParts.service;


import lk.ijse.gdse.computerParts.repository.custom.impl.ReceptionRepoImpl;
import lk.ijse.gdse.computerParts.repository.custom.impl.UserSettingRepoImpl;
import lk.ijse.gdse.computerParts.service.custom.impl.*;

import java.rmi.server.UnicastRemoteObject;

public class ServiseFactoryImpl extends UnicastRemoteObject implements ServiceFactory {

    public ServiseFactoryImpl() throws Exception{
    }
    private static ServiseFactoryImpl serviseFactory;

    public static ServiseFactoryImpl getInstance()throws Exception{
        if (serviseFactory == null){
            serviseFactory = new ServiseFactoryImpl();
        }
        return serviseFactory;
    }

    @Override
    public <T> T getSuperService(ServiceTypes types) throws Exception {
        switch (types){
            case CUSTOMER:
                return (T)new CustomerServiceImpl();

            case ITEM:
                return (T)new ItemServiceImpl();

            case ODER:
                return (T)new OderServiceImpl();

            case PAYMENT:
                return (T)new PaymentServiceImpl();

            case RECEPTION:
                return (T)new ReceptionServiceImpl();

            case ORDERdETAILS:
                return (T)new OrderDetailServiceImpl();

            case USER:
                return (T) new UserSettingServiceImpl();

                default:
                    return null;
        }
    }
}
