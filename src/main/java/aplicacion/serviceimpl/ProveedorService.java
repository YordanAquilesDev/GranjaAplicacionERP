package aplicacion.serviceimpl;

import dominio.modelos.Proveedor;
import dominio.servicio.JlaService;

import java.util.List;
import java.util.Optional;

public class ProveedorService implements JlaService<Proveedor,Integer> {

    @Override
    public int save(Proveedor proveedor) {
        return 0;
    }

    @Override
    public int update(Proveedor proveedor) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public List<Proveedor> findAll() {
        return List.of();
    }

    @Override
    public Optional<Proveedor> findById(Integer integer) {
        return Optional.empty();
    }
}
