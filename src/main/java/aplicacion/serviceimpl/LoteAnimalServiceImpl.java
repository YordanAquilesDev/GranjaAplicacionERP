package aplicacion.serviceimpl;

import dominio.modelos.Animal;
import dominio.modelos.LoteAnimal;
import dominio.servicio.LoteAnimalService;

import java.util.List;

public class LoteAnimalServiceImpl implements LoteAnimalService {
    @Override
    public LoteAnimal guardarUnLote(LoteAnimal lote) {
        return null;
    }

    @Override
    public LoteAnimal obtenerUnLotePorId(Long id) {
        return null;
    }

    @Override
    public List<LoteAnimal> obtenerTodosLosLotesPorAnimal(Animal animal) {
        return List.of();
    }
}
