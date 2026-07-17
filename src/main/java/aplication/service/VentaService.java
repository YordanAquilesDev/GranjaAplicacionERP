package aplication.service;

import aplication.repository.VentaRepository;
import domain.model.Venta;
import domain.repository.JpaRepository;
import domain.service.JlaService;

import java.util.List;
import java.util.Optional;

public class VentaService implements JlaService<Venta, Integer> {
 private final JpaRepository<Venta,Integer> ventaRepository;
    public VentaService() {
 this.ventaRepository = new VentaRepository();
    }

    @Override
    public int save(Venta venta) {

      return ventaRepository.saveAndFindId(venta);
    }

    @Override
    public int update(Venta venta) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public List<Venta> findAll() {
        return List.of();
    }

    @Override
    public Optional<Venta> findById(Integer integer) {
        return Optional.empty();
    }
}
