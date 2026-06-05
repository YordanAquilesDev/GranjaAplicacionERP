package dominio.servicio;

import dominio.modelos.DetallePedido;

import java.util.List;

public interface DetallePedidoService {
    DetallePedido guardarUnDetallePedido(DetallePedido detallePedido);

    DetallePedido obtenerUnDetallePedidoPorId(Long id);

    List<DetallePedido> obtenerTodosLosDetallePedidos();

}
