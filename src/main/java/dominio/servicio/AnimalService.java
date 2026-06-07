package dominio.servicio;

import dominio.modelos.Animal;

import java.util.List;

public interface AnimalService {
    int  guardarAnimal(Animal animal);

    int actualizarAnimal(Animal animal);

    int eliminarAnimal(int animal);

    Animal obtenerAnimalPorId(int id);

    List<Animal> obtenerTodosLosAnimales();

    List<Animal> traerPorConsumo();

}
