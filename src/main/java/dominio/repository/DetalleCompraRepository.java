package dominio.repository;

import dominio.modelos.DetalleCompra;

import java.sql.Date;
import java.util.List;

public interface DetalleCompraRepository {
    DetalleCompra Guardar(DetalleCompra detalleCompra);

    DetalleCompra ObtenerPorId(Long id);

    List<DetalleCompra> Listar();

    List<DetalleCompra> listarPorFecha(Date fecha, Date fecha2);

}
