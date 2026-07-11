package aplicacion.serviceimpl;

import aplicacion.repositoryimpl.LoteAnimalRepository;
import dominio.modelos.Animal;
import dominio.modelos.LoteAnimal;
import dominio.repository.JpaRepository;
import dominio.servicio.JlaService;

import java.util.List;
import java.util.Optional;

public class LoteAnimalServiceImpl implements JlaService<LoteAnimal,Integer> {
 private final JpaRepository<LoteAnimal,Integer> loteAnimalRepository;
 public LoteAnimalServiceImpl() {
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
