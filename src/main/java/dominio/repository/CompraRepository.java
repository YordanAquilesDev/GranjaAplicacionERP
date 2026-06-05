package dominio.repository;

import dominio.modelos.Compra;
import dominio.modelos.DetalleCompra;

import java.sql.Date;
import java.util.List;

public interface CompraRepository {
    Compra guardarCompra(DetalleCompra detalleCompra);

    Compra traerCompraPorId(Integer id);

    List<Compra> listarCompras();

    List<Compra> listarComprasMasAltos();

    List<Compra> listarComprasPorFecha(Date fecha, Date fecha2);

}
