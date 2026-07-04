package aplicacion.repositoryimpl;

import dominio.modelos.MovimientoAlmacen;
import dominio.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class MovimientoRepository implements JpaRepository< MovimientoAlmacen,Integer > {


    public int save(MovimientoAlmacen beans) {
        return 0;
    }


    @Override
    public int saveAndFindId(MovimientoAlmacen objeto) {
        return 0;
    }

    @Override
    public int update(MovimientoAlmacen objeto) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public Optional<MovimientoAlmacen> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<MovimientoAlmacen> findAll() {
        return List.of();
    }
}