package aplicacion.serviceimpl;

import java.util.List;
import java.util.Optional;

import aplicacion.repositoryimpl.ConsumoLoteRepository;
import dominio.modelos.Animal;
import dominio.modelos.ConsumoLote;
import dominio.modelos.LoteAnimal;
import dominio.servicio.JlaService;

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
