package dominio.repository;

import dominio.modelos.MovimientoAlmacen;

import java.sql.Date;
import java.util.List;

public interface MovimientoAlmacenRepository {
    int save(MovimientoAlmacen beans);

    List<MovimientoAlmacen> finAll();
    
    List<MovimientoAlmacen> finAllDate(Date fecha1, Date fecha2);
}