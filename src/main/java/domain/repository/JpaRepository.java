package domain.repository;

import java.util.List;
import java.util.Optional;

public interface JpaRepository<T,ID> {
    int saveAndFindId (T objeto);
    int update(T objeto);
    int delete(ID id);
    Optional<T> findById(ID id);
    List<T> findAll();

}
