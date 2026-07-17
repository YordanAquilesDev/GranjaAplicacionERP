package aplication.service;

import java.util.List;
import java.util.Optional;

import aplication.repository.CompraRepository;
import domain.model.Compra;
import domain.service.JlaService;

public class CompraService implements JlaService<Compra,Integer> {
    private final CompraRepository compraRepository;

    public CompraService() {
        this.compraRepository = new CompraRepository();
    }

    @Override
    public int save(Compra compra) {
        
       return compraRepository.save(compra);
    }

    @Override
    public int update(Compra compra) {
         return compraRepository.update(compra);
    }

    @Override
    public int delete(Integer id) {
         return compraRepository.delete(id);
    }

    @Override
    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    @Override
    public Optional<Compra> findById(Integer id) {
         return compraRepository.findById(id);
    }
}
