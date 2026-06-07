package dominio.servicio;

import dominio.modelos.DetalleVenta;

import java.util.List;

public interface DetalleVentaService {
    int  guardarUnDetalleVenta(DetalleVenta detalleVenta);

    DetalleVenta obtenerUnDetalleVentaPorId(Long id);

    List<DetalleVenta> obtenerTodosLosDetalleVentas();

}
