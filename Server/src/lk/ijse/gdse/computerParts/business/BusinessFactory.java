package lk.ijse.gdse.computerParts.business;

import lk.ijse.gdse.computerParts.business.custom.CustomerBusiness;
import lk.ijse.gdse.computerParts.business.custom.impl.*;

public class BusinessFactory {
    public static BusinessFactory businessFactory;

    public static BusinessFactory getInstance(){
        if (businessFactory==null){
            businessFactory=new BusinessFactory();
        }
        return businessFactory;
    }
    public enum BusinessTypes{
        CUSTOMER,ITEM,ORDER,PAYMENT,RECEPTION,ORDERDETAILS,USER
    }
    public <T>T getBusinessFor(BusinessTypes types){
        switch (types){
            case CUSTOMER:
                return(T)new CustomerBusinessImpl();

            case ITEM:
                return (T)new ItemBusinessImpl();

            case ORDER:
                return (T)new OrderBusinessImpl();

            case PAYMENT:
                return (T)new PaymentBusinessImpl();

            case RECEPTION:
                return (T)new ReceptionBusinessImpl();

            case ORDERDETAILS:
                return (T)new OrderDetailBusinessImpl();

            case USER:
                return (T)new UserSettingBusinessImpl();

               default:
                   return null;
        }
    }
}
