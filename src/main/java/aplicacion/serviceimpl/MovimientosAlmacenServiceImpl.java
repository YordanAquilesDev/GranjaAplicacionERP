package aplicacion.serviceimpl;

import dominio.modelos.MovimientoAlmacen;

import java.sql.Date;
import java.util.List;

public class MovimientosAlmacenServiceImpl implements MovimientoGranjaService {
    @Override
    public MovimientoAlmacen guardarUnMovimiento(MovimientoAlmacen movimiento) {
        return null;
    }

    @Override
    public MovimientoAlmacen obtenerUnMovimientoPorId(Long id) {
        return null;
    }

    @Override
    public List<MovimientoAlmacen> obtenerTodosLosMovimientos() {
        return List.of();
    }

    @Override
    public List<MovimientoAlmacen> obtenerMovimientosPorFecha(Date fecha1, Date fecha2) {
        return List.of();
    }
}
