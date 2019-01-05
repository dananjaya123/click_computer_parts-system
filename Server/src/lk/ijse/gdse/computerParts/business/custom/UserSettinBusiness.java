package lk.ijse.gdse.computerParts.business.custom;

import lk.ijse.gdse.computerParts.business.SuperBusiness;
import lk.ijse.gdse.computerParts.dto.UserSettiongDTO;

import java.util.ArrayList;

public interface UserSettinBusiness extends SuperBusiness {
    public boolean addUser(UserSettiongDTO userSettiongDTO)throws Exception;
    public ArrayList<UserSettiongDTO>getAllUser()throws Exception;
}
