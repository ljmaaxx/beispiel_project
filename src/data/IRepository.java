package data;

import java.util.ArrayList;
import java.util.List;

public interface IRepository<T> {
    void create(T obj);
    List<T> read();
    void update(T oldObj, T newObj);
    void delete(T obj);
    boolean exist(T obj);
    ArrayList<T> search(String obj);
    void saveArchive();
}
