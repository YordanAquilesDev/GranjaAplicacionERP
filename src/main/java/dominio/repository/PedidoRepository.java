package dominio.repository;

import dominio.modelos.Pedido;

import java.util.List;

public interface PedidoRepository {

    Pedido ActualizarPedido(Pedido pedido);
    List<Pedido> listarPedidosEntregados();
    List<Pedido> listarPedidosNoEntregados();
    int updatePedido(Pedido pedido);


}
