package dominio.repository;

import dominio.modelos.Animal;

import java.util.List;

public interface AnimalRepository {

    int save(Animal animal);
    int update(Animal animal);
    int delete(int id);
    Animal finById(Integer id);
    List<Animal> traerAnimalesPorConsumo();
    List<Animal> finAll();

}
