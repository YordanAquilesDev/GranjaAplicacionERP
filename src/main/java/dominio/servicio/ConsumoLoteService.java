package dominio.servicio;

import dominio.modelos.Animal;
import dominio.modelos.ConsumoLote;
import dominio.modelos.LoteAnimal;

import java.util.List;

public interface ConsumoLoteService {

    ConsumoLote guardarConsumoLote(ConsumoLote consumoLote);

    List<ConsumoLote> obtenerConsumosPorLote(LoteAnimal lote);

    ConsumoLote obtenerConsumoPorId(Long id);

    List<ConsumoLote> obtenerConsumoLotePorAnimal(Animal animal);

}
