package dominio.repository;

import dominio.modelos.Pedido;

import java.util.List;

public interface PedidoRepository {

    Pedido ActualizarPedido(Pedido pedido);
    List<Pedido> listarPedidosEntregados();
    List<Pedido> listarPedidosNoEntregados();
    List<Pedido> listarTodosLosPedidos();
    int updatePedido(Pedido pedido);


}
