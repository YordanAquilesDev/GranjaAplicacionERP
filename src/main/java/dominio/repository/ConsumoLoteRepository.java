package dominio.repository;

import dominio.modelos.Animal;
import dominio.modelos.ConsumoLote;

import java.util.List;

public interface ConsumoLoteRepository {
    ConsumoLote guardarConsumoLote(ConsumoLote consumo);

    List<ConsumoLote> listarConsumoLotes();

    ConsumoLote loteMasConsumidor();

    ConsumoLote obtenerConsumoPorId(Long id);

    List<ConsumoLote> obtenerConsumoLotePorAnimal(Animal animal);

}
