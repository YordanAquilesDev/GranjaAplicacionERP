package dominio.servicio;

import dominio.modelos.Animal;
import dominio.modelos.LoteAnimal;

import java.util.List;

public interface LoteAnimalService {
    LoteAnimal guardarUnLote(LoteAnimal lote);

    LoteAnimal obtenerUnLotePorId(Long id);

    List<LoteAnimal> obtenerTodosLosLotesPorAnimal(Animal animal);

}
