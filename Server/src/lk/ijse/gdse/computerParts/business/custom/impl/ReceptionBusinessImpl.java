package lk.ijse.gdse.computerParts.business.custom.impl;

import lk.ijse.gdse.computerParts.business.custom.ReceptionBusiness;
import lk.ijse.gdse.computerParts.dto.ReceptionDTO;
import lk.ijse.gdse.computerParts.entity.Reception;
import lk.ijse.gdse.computerParts.repository.RepoFactory;
import lk.ijse.gdse.computerParts.repository.custom.ReceptionRepo;
import lk.ijse.gdse.computerParts.resources.HibernetUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ReceptionBusinessImpl implements ReceptionBusiness {
    ReceptionRepo receptionRepo= RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.RECEPTION);
    public ReceptionBusinessImpl() {
    }

    @Override
    public boolean addReception(ReceptionDTO receptionDTO) throws Exception {
        try (Session session= HibernetUtil.getSessionFactory().openSession()){
            receptionRepo.setSession(session);
            session.getTransaction().begin();
            session.save(new Reception(receptionDTO.getRid(),receptionDTO.getName(),receptionDTO.getAddress(),receptionDTO.getPhoneNum(),receptionDTO.getNic(),receptionDTO.getPasword()));
            session.getTransaction().commit();

        }
        return true;
    }

    @Override
    public boolean deleteReception(ReceptionDTO receptionDTO) throws Exception {
        try (Session session=HibernetUtil.getSessionFactory().openSession()){
            receptionRepo.setSession(session);
            session.getTransaction().begin();
            session.delete(new Reception(receptionDTO.getRid(),receptionDTO.getName(),receptionDTO.getAddress(),receptionDTO.getPhoneNum(),receptionDTO.getNic(),receptionDTO.getPasword()));
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public boolean updateReception(ReceptionDTO receptionDTO) throws Exception {
        try (Session session=HibernetUtil.getSessionFactory().openSession()){
            receptionRepo.setSession(session);
            session.getTransaction().begin();
            session.update(new Reception(receptionDTO.getRid(),receptionDTO.getName(),receptionDTO.getAddress(),receptionDTO.getPhoneNum(),receptionDTO.getNic(),receptionDTO.getPasword()));
            session.getTransaction().commit();

        }
        return true;
    }

    @Override
    public ReceptionDTO searchReception(String id) throws Exception {
        try (Session session=HibernetUtil.getSessionFactory().openSession()){
            receptionRepo.setSession(session);
            session.getTransaction().begin();
            Reception search = receptionRepo.search(id);
            session.getTransaction().commit();

            return new ReceptionDTO(search.getRid(),search.getName(),search.getAddress(),search.getPhoneNum(),search.getNic(),search.getPasword());
        }

    }

    @Override
    public ArrayList<ReceptionDTO> getAllReception() throws Exception {
        ArrayList<ReceptionDTO>receptionDTOS=new ArrayList<>();
        try (Session session=HibernetUtil.getSessionFactory().openSession()){
            receptionRepo.setSession(session);
            session.getTransaction().begin();

            List<Reception>receptions=receptionRepo.getAll();
            for (Reception reception:receptions){
                receptionDTOS.add(new ReceptionDTO(reception.getRid(),reception.getName(),reception.getAddress(),reception.getPhoneNum(),reception.getNic(),reception.getPasword()));
            }

            session.getTransaction().commit();
        }
        return receptionDTOS;
    }
}
