package aplicacion.serviceimpl;

import dominio.modelos.Proveedor;
import dominio.servicio.ProveedorService;

import java.util.List;

public class ProveedorServiceImpl implements ProveedorService {
    @Override
    public Proveedor guardarUnProveedor(Proveedor proveedor) {
        return null;
    }

    @Override
    public Proveedor obtenerUnProveedorPorId(Long id) {
        return null;
    }

    @Override
    public List<Proveedor> obtenerTodosLosProveedores() {
        return List.of();
    }

    @Override
    public List<Proveedor> obtenerProveedoresActivos() {
        return List.of();
    }
}
