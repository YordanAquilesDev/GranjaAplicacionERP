package aplication.service;

import java.util.List;
import java.util.Optional;

import aplication.repository.AnimalRepository;
import domain.model.Animal;
import domain.repository.JpaRepository;
import domain.service.JlaService;

public class AnimalService implements JlaService<Animal, Integer> {
    private final JpaRepository <Animal,Integer> animalRepository;
    public AnimalService() {
        this.animalRepository  = new AnimalRepository();

    }
    @Override
    public int save(Animal animal) {
        if (animal == null) {
            return -1;
        }
        if (animal.getRaza() == null || animal.getEspecie() == null) {
            return -1;
        } else {
            return  animalRepository.saveAndFindId(animal);
        }
    }

    @Override
    public int update(Animal animal) {
        if (animal == null) {return -1;}
        if (animal.getRaza() == null || animal.getEspecie() == null) {return -1;}
        return animalRepository.update(animal);
    }

    @Override
    public int delete(Integer id) {
        if (id < 0) {return -1;}
        return animalRepository.delete(id);
    }

    @Override
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    @Override
    public Optional<Animal> findById(Integer id) {
        if (id < 0) {return null;}
        return animalRepository.findById(id);
    }
}
