package dominio.repository;

import dominio.modelos.Proveedor;

import java.util.List;

public interface ProveedorRepository {
    Proveedor guardar(Proveedor proveedor);
    Proveedor buscarPorId(long id);
    Proveedor Actualizar(Proveedor proveedor);
    Proveedor Eliminar(long id);
    List<Proveedor> listarProveedores();
  int updateProveedor(Proveedor proveedor);
}
