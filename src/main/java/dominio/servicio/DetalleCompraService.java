package dominio.servicio;

import dominio.modelos.DetalleCompra;

import java.util.List;

public interface DetalleCompraService {
    DetalleCompra guardarUnDetalleCompra(DetalleCompra detalleCompra);

    DetalleCompra obtenerUnDetalleCompraPorId(Long id);

    List<DetalleCompra> obtenerTodosLosDetalleCompras();

}
