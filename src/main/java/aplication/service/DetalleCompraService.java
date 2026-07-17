package aplication.service;

import aplication.repository.DetalleCompraRepository;
import java.util.List;
import java.util.Optional;
import domain.model.DetalleCompra;
import domain.service.JlaService;

public class DetalleCompraService implements JlaService<DetalleCompra,Integer> {
 
    private final DetalleCompraRepository detalleCompraRepository;
    public DetalleCompraService() {
    this.detalleCompraRepository= new DetalleCompraRepository();

    }

    @Override
    public int save(DetalleCompra detalleCompra) {
        return detalleCompraRepository.save(detalleCompra);
    }

    @Override
    public int update(DetalleCompra detalleCompra) {
         return detalleCompraRepository.update(detalleCompra);
    }

    @Override
    public int delete(Integer integer) {
        return detalleCompraRepository.delete(integer);
    }

    @Override
    public List<DetalleCompra> findAll() {
        return detalleCompraRepository.findAll();
    }

    @Override
    public Optional<DetalleCompra> findById(Integer integer) {
         return detalleCompraRepository.findById(integer);
    }
}
