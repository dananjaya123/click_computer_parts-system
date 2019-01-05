package lk.ijse.gdse.computerParts.repository;

import org.hibernate.Session;

public interface SuperRepository {
    public void setSession(Session session)throws Exception;
}
