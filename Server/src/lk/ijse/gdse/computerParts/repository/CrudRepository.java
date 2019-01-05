package lk.ijse.gdse.computerParts.repository;

import java.util.List;

public interface CrudRepository<T,ID>extends SuperRepository {
    public boolean add(T enty)throws Exception;
    public boolean delete(T enty)throws Exception;
    public boolean update(T enty)throws Exception;
    public T search(ID id)throws Exception;
    public List<T>getAll()throws Exception;
}
