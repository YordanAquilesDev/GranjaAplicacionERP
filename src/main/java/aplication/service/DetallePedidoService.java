package aplication.service;


import domain.model.DetallePedido;
import domain.service.JlaService;

import java.util.List;
import java.util.Optional;

public class DetallePedidoService implements JlaService<DetallePedido,Integer> {


    public DetallePedidoService() {

    }
    @Override
    public int save(DetallePedido detallePedido) {
        return 0;
    }

    @Override
    public int update(DetallePedido detallePedido) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public List<DetallePedido> findAll() {
        return List.of();
    }

    @Override
    public Optional<DetallePedido> findById(Integer integer) {
        return Optional.empty();
    }
}
