package aplication.service;

import java.util.List;
import java.util.Optional;

import domain.model.ConsumoLote;
import domain.service.JlaService;

public class ConsumoLoteService implements JlaService<ConsumoLote,Integer> {



    @Override
    public int save(ConsumoLote consumoLote) {
        return 0;
    }

    @Override
    public int update(ConsumoLote consumoLote) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public List<ConsumoLote> findAll() {
        return List.of();
    }

    @Override
    public Optional<ConsumoLote> findById(Integer integer) {
        return Optional.empty();
    }
}
