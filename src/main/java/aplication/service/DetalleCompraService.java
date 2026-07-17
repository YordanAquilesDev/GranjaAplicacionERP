package aplication.service;

import java.util.List;
import java.util.Optional;
import domain.model.DetalleCompra;
import domain.service.JlaService;

public class DetalleCompraService implements JlaService<DetalleCompra,Integer> {

    public DetalleCompraService() {


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
