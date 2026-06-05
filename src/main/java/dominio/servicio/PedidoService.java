package dominio.servicio;

import dominio.modelos.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido guardarUnPedido(Pedido pedido);

    Pedido obtenerUnPedidoPorId(Long id);

    List<Pedido> obtenerTodosLosPedidos();

    List<Pedido> obtenerPedidosEntregados();

    List<Pedido> obtenerPedidosNoEntregados();

}
