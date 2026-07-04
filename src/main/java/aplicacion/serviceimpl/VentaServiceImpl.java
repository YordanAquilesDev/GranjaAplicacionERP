package aplicacion.serviceimpl;

import aplicacion.repositoryimpl.VentaRepositoryImpl;
import dominio.modelos.Venta;
import dominio.servicio.JlaService;

import java.util.List;
import java.util.Optional;

public class VentaServiceImpl implements JlaService<Venta, Integer> {

    public VentaServiceImpl() {

    }

    @Override
    public int save(Venta venta) {
        return 0;
    }

    @Override
    public int update(Venta venta) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public List<Venta> findAll() {
        return List.of();
    }

    @Override
    public Optional<Venta> findById(Integer integer) {
        return Optional.empty();
    }
}
