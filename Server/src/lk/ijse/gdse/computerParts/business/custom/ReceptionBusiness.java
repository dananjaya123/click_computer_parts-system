package lk.ijse.gdse.computerParts.business.custom;

import lk.ijse.gdse.computerParts.business.SuperBusiness;
import lk.ijse.gdse.computerParts.dto.ReceptionDTO;

import java.util.ArrayList;

public interface ReceptionBusiness extends SuperBusiness {
    public boolean addReception(ReceptionDTO receptionDTO)throws Exception;
    public boolean deleteReception(ReceptionDTO receptionDTO)throws Exception;
    public boolean updateReception(ReceptionDTO receptionDTO)throws Exception;
    public ReceptionDTO searchReception(String id)throws Exception;
    public ArrayList<ReceptionDTO> getAllReception()throws Exception;
}
