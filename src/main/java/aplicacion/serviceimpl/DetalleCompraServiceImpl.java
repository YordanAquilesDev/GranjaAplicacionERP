package aplicacion.serviceimpl;

import java.util.List;

import aplicacion.repositoryimpl.DetalleCompraRepositoryImpl;
import dominio.modelos.DetalleCompra;

public class DetalleCompraServiceImpl implements DetalleCompraService {
    private final DetalleCompraRepository detalleCompraRepository;

    public DetalleCompraServiceImpl() {
        this.detalleCompraRepository = new DetalleCompraRepositoryImpl();

    }

    public DetalleCompra guardarUnDetalleCompra(DetalleCompra detalleCompra) {
        return detalleCompraRepository.Guardar(detalleCompra);
    }

    public DetalleCompra obtenerUnDetalleCompraPorId(Long id) {
        return detalleCompraRepository.ObtenerPorId(id);
    }

    public List<DetalleCompra> obtenerTodosLosDetalleCompras() {
        return detalleCompraRepository.Listar();
    }
}
