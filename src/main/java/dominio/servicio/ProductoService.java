package dominio.servicio;

import dominio.modelos.Producto;

import java.util.List;

public interface ProductoService {
    Producto guardarUnProducto(Producto producto);

    Producto obtenerUnProductoPorId(int id);

    List<Producto> obtenerTodosLosProductos();

    List<Producto> obtenerProductosPorCategoria(String categoria);

    List<Producto> obtenerProductosPorAcabar();

}
