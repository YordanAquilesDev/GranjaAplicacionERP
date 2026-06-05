package dominio.servicio;

import dominio.modelos.MovimientoAlmacen;

import java.sql.Date;
import java.util.List;

public interface MovimientoGranjaService {
    MovimientoAlmacen guardarUnMovimiento(MovimientoAlmacen movimiento);

    MovimientoAlmacen obtenerUnMovimientoPorId(Long id);

    List<MovimientoAlmacen> obtenerTodosLosMovimientos();

    List<MovimientoAlmacen> obtenerMovimientosPorFecha(Date fecha1, Date fecha2);

}
