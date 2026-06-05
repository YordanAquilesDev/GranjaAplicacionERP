package dominio.servicio;

import dominio.modelos.Venta;

import java.util.List;

public interface VentaService {
    Venta guardarUnaVenta(Venta venta);

    Venta obtenerUnaVentaPorId(Long id);

    List<Venta> obtenerTodasLasVentas();

}
