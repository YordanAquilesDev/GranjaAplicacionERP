

import java.util.List;

import aplicacion.repositoryimpl.ConsumoLoteRepositoryImpl;
import dominio.modelos.Animal;
import dominio.modelos.ConsumoLote;
import dominio.modelos.LoteAnimal;

public class ConsumoServiceImpl implements ConsumoLoteService {

    private final ConsumoLoteRepository consumoLoteRepository;

    public ConsumoServiceImpl() {
        this.consumoLoteRepository = new ConsumoLoteRepositoryImpl();
    }

    // ok
    public ConsumoLote guardarConsumoLote(ConsumoLote consumoLote) {
        return consumoLoteRepository.guardarConsumoLote(consumoLote);
    }

    // ok
    public List<ConsumoLote> obtenerConsumosPorLote(LoteAnimal lote) {
        return consumoLoteRepository.listarConsumoLotes();
    }

    // ok
    public ConsumoLote obtenerConsumoPorId(Long id) {
        return consumoLoteRepository.obtenerConsumoPorId(id);
    }

    // ok
    public List<ConsumoLote> obtenerConsumoLotePorAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("El animal no puede ser nulo");
        }
        if (animal.getIdAnimal() <= 0) {
            throw new IllegalArgumentException("El id del animal debe ser mayor a cero");
        }
        return consumoLoteRepository.obtenerConsumoLotePorAnimal(animal);
    }
}
