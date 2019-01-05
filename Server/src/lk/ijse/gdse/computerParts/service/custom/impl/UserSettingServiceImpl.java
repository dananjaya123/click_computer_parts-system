package lk.ijse.gdse.computerParts.service.custom.impl;

import lk.ijse.gdse.computerParts.business.BusinessFactory;
import lk.ijse.gdse.computerParts.business.custom.UserSettinBusiness;
import lk.ijse.gdse.computerParts.dto.UserSettiongDTO;
import lk.ijse.gdse.computerParts.service.custom.UserSettingService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class UserSettingServiceImpl extends UnicastRemoteObject implements UserSettingService {
    UserSettinBusiness userSettinBusiness= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.USER);

    public UserSettingServiceImpl() throws RemoteException {

    }

    @Override
    public boolean addUser(UserSettiongDTO userSettiongDTO) throws Exception {
        return userSettinBusiness.addUser(userSettiongDTO);

    }

    @Override
    public ArrayList<UserSettiongDTO> getAllUser() throws Exception {
        ArrayList<UserSettiongDTO>userSettiongDTOS=userSettinBusiness.getAllUser();
        return userSettiongDTOS;
    }
}
