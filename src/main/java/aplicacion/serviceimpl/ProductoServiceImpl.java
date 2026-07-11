package aplicacion.serviceimpl;

import aplicacion.repositoryimpl.ProductoRepository;
import dominio.modelos.Producto;
import dominio.servicio.JlaService;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements JlaService<Producto,Integer> {
  private final ProductoRepository productoRepository;
  public ProductoServiceImpl() {
      this.productoRepository = new ProductoRepository();
  }
    @Override
    public int save(Producto producto) {
        return 0;
    }

    @Override
    public int update(Producto producto) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();

    }

    @Override
    public Optional<Producto> findById(Integer integer) {
        return Optional.empty();
    }
}
