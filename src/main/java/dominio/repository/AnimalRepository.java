package dominio.repository;

import dominio.modelos.Animal;

import java.util.List;

public interface AnimalRepository {
    Animal guardarAnimal(Animal animal);
    Animal traerAnimalPorId(Integer id);
    List<Animal> traerAnimalesPorConsumo();
    List<Animal> traerTodosAnimales();

}
