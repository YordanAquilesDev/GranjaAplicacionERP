package dominio.servicio;

import dominio.modelos.Animal;

import java.util.List;

public interface AnimalService {
    Animal guardarAnimal(Animal animal);

    Animal obtenerAnimalPorId(Long id);

    List<Animal> obtenerTodosLosAnimales();

}
