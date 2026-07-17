package domain.service;

import java.util.List;
import java.util.Optional;

public interface JlaService<T,ID> {
    int save(T t);
    int update(T t);
    int delete(ID id);
    List<T> findAll();
    Optional<T> findById(ID id);

}
