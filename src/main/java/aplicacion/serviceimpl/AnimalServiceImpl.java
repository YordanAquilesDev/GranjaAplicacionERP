package aplicacion.serviceimpl;

import java.util.List;

import aplicacion.repositoryimpl.AnimalRepositoryImpl;
import dominio.modelos.Animal;
import dominio.servicio.AnimalService;
import dominio.repository.AnimalRepository;

public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalServiceImpl() {
        this.animalRepository = new AnimalRepositoryImpl();
    }

    @Override
    public int guardarAnimal(Animal animal) {
        if (animal == null) {
            return -1;
        }
        if (animal.getRaza() == null || animal.getEspecie() == null) {
            return -1;
        } else {
            return animalRepository.save(animal);

        }
    }

    @Override
    public int actualizarAnimal(Animal animal) {
        if (animal == null) {return -1;}
        if (animal.getRaza() == null || animal.getEspecie() == null) {return -1;}
        return animalRepository.update(animal);
    }

    @Override
    public int eliminarAnimal(int id) {
        if (id < 0) {return -1;}
        return animalRepository.delete(id);
    }

    @Override
    public Animal obtenerAnimalPorId(int id) {
        if (id < 0) {return null;}
        return animalRepository.finById(id);
    }

    @Override
    public List<Animal> obtenerTodosLosAnimales() {
        return animalRepository.finAll();
    }

    @Override
    public List<Animal> traerPorConsumo(){
        return animalRepository.traerAnimalesPorConsumo();
    }

}
