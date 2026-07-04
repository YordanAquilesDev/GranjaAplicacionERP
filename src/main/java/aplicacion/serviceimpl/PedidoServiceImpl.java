package aplicacion.serviceimpl;

import dominio.modelos.Pedido;
import dominio.servicio.JlaService;

import java.util.List;
import java.util.Optional;

public class PedidoServiceImpl implements JlaService<Pedido,Integer> {

    public PedidoServiceImpl() {

    }


    @Override
    public int save(Pedido pedido) {
        return 0;
    }

    @Override
    public int update(Pedido pedido) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public List<Pedido> findAll() {
        return List.of();
    }

    @Override
    public Optional<Pedido> findById(Integer integer) {
        return Optional.empty();
    }
}
