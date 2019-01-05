package lk.ijse.gdse.computerParts.business.custom.impl;


import lk.ijse.gdse.computerParts.business.custom.UserSettinBusiness;
import lk.ijse.gdse.computerParts.dto.UserSettiongDTO;
import lk.ijse.gdse.computerParts.entity.UserSeting;
import lk.ijse.gdse.computerParts.repository.RepoFactory;
import lk.ijse.gdse.computerParts.repository.custom.UserSettingRepo;
import lk.ijse.gdse.computerParts.resources.HibernetUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class UserSettingBusinessImpl implements UserSettinBusiness {
    UserSettingRepo userSettingRepo= RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.USER);

    public UserSettingBusinessImpl() {
    }

    @Override
    public boolean addUser(UserSettiongDTO userSettiongDTO) throws Exception {
        try(Session session= HibernetUtil.getSessionFactory().openSession()) {
            userSettingRepo.setSession(session);
            session.getTransaction().begin();
            session.save(new UserSeting(userSettiongDTO.getName(),userSettiongDTO.getPassword(),userSettiongDTO.getSolt()));
            session.getTransaction().commit();

        }
        return false;
    }

    @Override
    public ArrayList<UserSettiongDTO> getAllUser() throws Exception {
        ArrayList<UserSettiongDTO>userSettiongDTOS=new ArrayList<>();
        try (Session session=HibernetUtil.getSessionFactory().openSession()){
            userSettingRepo.setSession(session);
            session.getTransaction().begin();
            List<UserSeting>userSetings=userSettingRepo.getAll();
            for (UserSeting userSeting:userSetings){
                userSettiongDTOS.add(new UserSettiongDTO(userSeting.getName(),userSeting.getPassword(),userSeting.getSolt()));
            }
            session.getTransaction().commit();
        }
        return userSettiongDTOS;
    }
}
