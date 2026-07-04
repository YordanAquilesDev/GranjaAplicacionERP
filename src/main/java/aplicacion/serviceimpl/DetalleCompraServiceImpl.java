package aplicacion.serviceimpl;

import java.util.List;
import java.util.Optional;
import dominio.modelos.DetalleCompra;
import dominio.servicio.JlaService;

public class DetalleCompraServiceImpl implements JlaService<DetalleCompra,Integer> {

    public DetalleCompraServiceImpl() {


    }

    @Override
    public int save(DetalleCompra detalleCompra) {
        return 0;
    }

    @Override
    public int update(DetalleCompra detalleCompra) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public List<DetalleCompra> findAll() {
        return List.of();
    }

    @Override
    public Optional<DetalleCompra> findById(Integer integer) {
        return Optional.empty();
    }
}
