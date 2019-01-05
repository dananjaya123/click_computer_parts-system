package lk.ijse.gdse.computerParts.repository;

import lk.ijse.gdse.computerParts.repository.custom.impl.*;

public class RepoFactory {
    public static RepoFactory repoFactory;


    public static RepoFactory getInstance(){
        if (repoFactory==null){
            repoFactory=new RepoFactory();
        }
        return repoFactory;
    }

    public enum RepoTypes{
        CUSTOMER,ITEM ,ORDER,PAYMENT,RECEPTION,ORDERDETAIL,USER
    }
    public <T>T getRepositoryFor(RepoTypes types){
    switch (types){
        case CUSTOMER:
            return (T) new CustomerRepoImpl();

        case ITEM:
            return (T) new ItemRepoImpl();

        case ORDER:
            return (T) new OrderRepoImpl();

        case PAYMENT:
            return (T) new PaymentRepoImpl();

        case RECEPTION:
            return (T)new ReceptionRepoImpl();

        case ORDERDETAIL:
            return (T)new OrderDetailRepoImpl();

        case USER:
            return (T)new UserSettingRepoImpl();
         default:
                return null;

        }
    }

}