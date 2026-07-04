package aplicacion.serviceimpl;


import dominio.modelos.DetalleVenta;
import dominio.servicio.JlaService;

import java.util.List;
import java.util.Optional;

public class DetalleVentaServiceImpl implements JlaService<DetalleVenta,Integer> {

    public DetalleVentaServiceImpl() {
    }


    @Override
    public int save(DetalleVenta detalleVenta) {
        return 0;
    }

    @Override
    public int update(DetalleVenta detalleVenta) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public List<DetalleVenta> findAll() {
        return List.of();
    }

    @Override
    public Optional<DetalleVenta> findById(Integer integer) {
        return Optional.empty();
    }
}
