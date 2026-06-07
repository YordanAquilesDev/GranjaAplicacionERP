package aplicacion.serviceimpl;

import aplicacion.repositoryimpl.VentaRepositoryImpl;
import dominio.modelos.Venta;
import dominio.repository.VentaRepository;
import dominio.servicio.VentaService;

import java.util.List;

public class VentaServiceImpl implements VentaService {
    private final VentaRepository ventaRepository;
    public VentaServiceImpl() {
        this.ventaRepository =  new VentaRepositoryImpl();

    }
    @Override
    public Venta guardarUnaVenta(Venta venta) {
        return null;
    }

    @Override
    public Venta obtenerUnaVentaPorId(int id) {
        return null;
    }

    @Override
    public List<Venta> obtenerTodasLasVentas() {
        System.out.println("estamos en Ventaslistas service");
        return ventaRepository.listarVentas();
    }
}
