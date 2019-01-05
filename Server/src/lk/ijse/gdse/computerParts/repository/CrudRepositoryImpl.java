package lk.ijse.gdse.computerParts.repository;

import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class CrudRepositoryImpl<T,ID extends Serializable>implements CrudRepository<T,ID>{
    protected Session session;
    private Class<T> type;

    public CrudRepositoryImpl() {
        type=(Class<T>)((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
    }

    @Override
    public boolean add(T enty) throws Exception {
        session.save(enty);
        return true;
    }

    @Override
    public boolean delete(T enty) throws Exception {
        session.delete(enty);
        return true;
    }

    @Override
    public boolean update(T enty) throws Exception {
        session.update(enty);
        return true;
    }

    @Override
    public T search(ID id) throws Exception {
        return session.get(type,id);
    }

    @Override
    public List<T> getAll() throws Exception {
        return session.createQuery(" From "+type.getName()).list();
    }

    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }
}
