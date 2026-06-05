package dominio.repository;

import dominio.modelos.Producto;

import java.util.List;

public interface ProductoRepository {
    Producto buscarPorId(long id);
    List<Producto> listarProductos();
    List<Producto> listaProductosPorAcavar();


}
