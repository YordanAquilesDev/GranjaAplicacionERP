package domain.repository;

import java.util.List;

public interface CrudGenerico <T,ID>{

    int save(T objeto);
    int update(T objeto);
    int delete(ID id);
    T findById(ID id);
    List<T> findAll();
    List<T> findAll(String filter);



}
