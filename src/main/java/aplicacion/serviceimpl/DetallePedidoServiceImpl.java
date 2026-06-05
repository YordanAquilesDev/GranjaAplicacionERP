package aplicacion.serviceimpl;

import aplicacion.repositoryimpl.DetallePedidoRepositoryImpl;
import aplicacion.repositoryimpl.PedidoRepositoryImpl;
import dominio.modelos.DetallePedido;
import dominio.modelos.Pedido;
import dominio.servicio.DetallePedidoService;
import dominio.repository.DetallePedidoRepository;
import dominio.repository.PedidoRepository;

import java.util.List;

public class DetallePedidoServiceImpl implements DetallePedidoService {

    private final DetallePedidoRepository detallePedidoRepository;
    public DetallePedidoServiceImpl() {
        this.detallePedidoRepository = new DetallePedidoRepositoryImpl();
    }
    @Override
    public DetallePedido guardarUnDetallePedido(DetallePedido detallePedido) {
        if(detallePedido== null){
            return  null;
        }

        if(detallePedido.getIdDetalle()==-1||
                detallePedido.getCantidad()==0||
                detallePedido.getProducto().getIdProducto()==-1||
                detallePedido.getPedido().getIdPedido()==-1){
            return  null;
        }
        return detallePedidoRepository.guardar(detallePedido);
    }

    @Override
    public DetallePedido obtenerUnDetallePedidoPorId(Long id) {
        return null;
    }

    @Override
    public List<DetallePedido> obtenerTodosLosDetallePedidos() {
        return List.of();
    }
}
