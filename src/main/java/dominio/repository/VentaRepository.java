package dominio.repository;

import dominio.modelos.Venta;

import java.sql.Date;
import java.util.List;

public interface VentaRepository {
    Venta guardar(Venta venta);
    List<Venta> listarVentas();
    List<Venta> listarMejoresVentas();
    List<Venta> listarPorFecha(Date fecha, Date fecha2);

}
