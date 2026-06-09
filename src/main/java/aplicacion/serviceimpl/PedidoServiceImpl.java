package aplicacion.serviceimpl;

import aplicacion.repositoryimpl.PedidoRepositoryImpl;
import dominio.modelos.Pedido;
import dominio.repository.PedidoRepository;
import dominio.servicio.PedidoService;

import java.util.List;

public class PedidoServiceImpl implements PedidoService {
    private PedidoRepository pedidoRepository;
    public PedidoServiceImpl() {
        this.pedidoRepository = new PedidoRepositoryImpl();
    }
    @Override
    public Pedido guardarUnPedido(Pedido pedido) {
        return null;
    }

    @Override
    public Pedido obtenerUnPedidoPorId(Long id) {
        return null;
    }

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.listarTodosLosPedidos();
    }

    @Override
    public List<Pedido> obtenerPedidosEntregados() {
        return pedidoRepository.listarPedidosEntregados();
    }

    @Override
    public List<Pedido> obtenerPedidosNoEntregados() {

        return pedidoRepository.listarPedidosNoEntregados();
    }
}
