package aplicacion.serviceimpl;


import dominio.modelos.DetallePedido;
import dominio.servicio.JlaService;

import java.util.List;
import java.util.Optional;

public class DetallePedidoServiceImpl implements JlaService<DetallePedido,Integer> {


    public DetallePedidoServiceImpl() {

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
