package dominio.repository;

import dominio.modelos.Pedido;
import dominio.modelos.Producto;

import java.util.List;

public interface ProductoRepository {
    Producto buscarPorId(long id);
    List<Producto> listarProductos();
    List<Producto> listaProductosPorAcavar();
    int updateProducto(Pedido pedido);

}
