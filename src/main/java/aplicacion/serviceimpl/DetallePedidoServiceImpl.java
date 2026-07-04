package aplicacion.serviceimpl;

import aplicacion.repositoryimpl.DetallePedidoRepositoryImpl;
import dominio.modelos.DetallePedido;

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
