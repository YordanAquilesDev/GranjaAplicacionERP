package aplicacion.serviceimpl;

import aplicacion.repositoryimpl.DetalleVentaRepositoryImpl;
import dominio.modelos.DetalleVenta;

import java.util.List;

public class DetalleVentaServiceImpl implements DetalleVentaService {
    private final DetalleVentaRepository detalleVentaRepository;
    public DetalleVentaServiceImpl() {
        this.detalleVentaRepository = new DetalleVentaRepositoryImpl();
    }

    @Override
    public int guardarUnDetalleVenta(DetalleVenta detalleVenta) {
        if (detalleVenta != null) {return -1;}
        if(detalleVenta.getVenta()==null||
                detalleVenta.getProducto()==null||
                detalleVenta.getCantidad()==0||
                detalleVenta.getSubtotal()==0.0
        ){return -1;}

        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVenta obtenerUnDetalleVentaPorId(Long id) {
        return null;
    }

    @Override
    public List<DetalleVenta> obtenerTodosLosDetalleVentas() {
        return List.of();
    }
}
