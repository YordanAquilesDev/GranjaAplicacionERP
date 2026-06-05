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

    // Funciona Correctamente
    // Cumple con su Objetivo de guardar en la DB
    // Faltaria aser pruevas más específico para decubrir
    // algún error
    public Animal guardarAnimal(Animal animal) {
        /*
         * El metodo guardarAnimal resive
         * objeto de la Clase Animal
         * para guardarlo en la Base de Datos
         */
        if (animal == null) {
            return null;
        }

        if (animal.getRaza() == null || animal.getEspecie() == null) {
            return null;

        } else {
            return animalRepository.guardarAnimal(animal);

        }
    }

    // Funciona Correctamente
    // Cumple con su Objetivo de guardar en la DB
    // Faltaria aser pruevas más específico para decubrir
    // algún error
    public Animal obtenerAnimalPorId(Long id) {
        /*
         * El metodo obtenerAnimalPorId recive como parametro un
         * Long que será usado en el metodo
         * traerAnimalPorId este retorna un Objeto Animal de la
         * clase Animal
         */
        Integer idNativo = Integer.parseInt(id.toString());
        return animalRepository.traerAnimalPorId(idNativo);
    }

    // Funciona Correctamente
    // Cumple con su Objetivo de guardar en la DB
    // Faltaria aser pruevas más específico para decubrir
    // algún error
    public List<Animal> obtenerTodosLosAnimales() {
        /*
         * El metodo obtenerTodosLosAnimales
         * trae todas las filas de la tabla animal
         * de la base de datos granjadb
         */
        return animalRepository.traerTodosAnimales();
    }

}
