package aplicacion.serviceimpl;

import dominio.modelos.Producto;
import dominio.servicio.ProductoService;

import java.util.List;

public class ProductoServiceImpl implements ProductoService {
    @Override
    public Producto guardarUnProducto(Producto producto) {
        return null;
    }

    @Override
    public Producto obtenerUnProductoPorId(int id) {
        return null;
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return List.of();
    }

    @Override
    public List<Producto> obtenerProductosPorCategoria(String categoria) {
        return List.of();
    }

    @Override
    public List<Producto> obtenerProductosPorAcabar() {
        return List.of();
    }
}
