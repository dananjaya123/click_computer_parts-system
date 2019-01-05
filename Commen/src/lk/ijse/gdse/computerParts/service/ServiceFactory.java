package lk.ijse.gdse.computerParts.service;

import java.rmi.Remote;

public interface ServiceFactory extends Remote {
    public enum ServiceTypes{
        CUSTOMER,ITEM,ODER,PAYMENT,RECEPTION,ORDERdETAILS,USER
    }
    public <T>T getSuperService(ServiceTypes types)throws Exception;
}
