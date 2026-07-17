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
        return 0;
    }

    @Override
    public int update(Compra compra) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public List<Compra> findAll() {
        return List.of();
    }

    @Override
    public Optional<Compra> findById(Integer integer) {
        return Optional.empty();
    }
}
