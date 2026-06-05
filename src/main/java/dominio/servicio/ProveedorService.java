package dominio.servicio;

import dominio.modelos.Proveedor;

import java.util.List;

public interface ProveedorService {
    Proveedor guardarUnProveedor(Proveedor proveedor);

    Proveedor obtenerUnProveedorPorId(Long id);

    List<Proveedor> obtenerTodosLosProveedores();

    List<Proveedor> obtenerProveedoresActivos();

}
