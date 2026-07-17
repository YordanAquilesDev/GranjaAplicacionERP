package aplication.service;

import aplication.repository.LoteAnimalRepository;
import domain.model.LoteAnimal;
import domain.repository.JpaRepository;
import domain.service.JlaService;

import java.util.List;
import java.util.Optional;

public class LoteAnimalService implements JlaService<LoteAnimal,Integer> {
 private final JpaRepository<LoteAnimal,Integer> loteAnimalRepository;
 public LoteAnimalService() {
     this.loteAnimalRepository= new  LoteAnimalRepository();
 }
    @Override
    public int save(LoteAnimal loteAnimal) {
        return 0;
    }

    @Override
    public int update(LoteAnimal loteAnimal) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public List<LoteAnimal> findAll() {
        return  loteAnimalRepository.findAll();
    }

    @Override
    public Optional<LoteAnimal> findById(Integer integer) {
        return Optional.empty();
    }
}
