package lk.ijse.gdse.computerParts.service.custom;

import lk.ijse.gdse.computerParts.dto.UserSettiongDTO;
import lk.ijse.gdse.computerParts.service.SuperService;

import java.util.ArrayList;

public interface UserSettingService extends SuperService {
    public boolean addUser(UserSettiongDTO userSettiongDTO)throws Exception;
    public ArrayList<UserSettiongDTO> getAllUser()throws Exception;
}
