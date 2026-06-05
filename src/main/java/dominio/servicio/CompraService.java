package dominio.servicio;

import dominio.modelos.Compra;
import dominio.modelos.DetalleCompra;

import java.sql.Date;
import java.util.List;

public interface CompraService {

    Compra guardarCompra(DetalleCompra detalleCompra);

    Compra obtenerCompraPorId(Long id);

    List<Compra> obtenerTodasLasCompras();

    List<Compra> obtenerComprasPorFecha(Date fecha, Date fecha2);

}
