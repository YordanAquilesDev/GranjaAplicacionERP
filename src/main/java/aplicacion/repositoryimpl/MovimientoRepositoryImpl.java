package aplicacion.repositoryimpl;

import dominio.modelos.MovimientoAlmacen;
import dominio.repository.MovimientoAlmacenRepository;

import java.sql.Date;
import java.util.List;

public class MovimientoRepositoryImpl implements MovimientoAlmacenRepository {

    @Override
    public int save(MovimientoAlmacen beans) {
        return 0;
    }

    @Override
    public List<MovimientoAlmacen> finAll() {
        return null;
    }

    @Override
    public List<MovimientoAlmacen> finAllDate(Date fecha1, Date fecha2) {
        return null;
    }
}