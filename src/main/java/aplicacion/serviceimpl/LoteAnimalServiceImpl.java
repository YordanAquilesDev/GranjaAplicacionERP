package aplicacion.serviceimpl;

import dominio.modelos.Animal;
import dominio.modelos.LoteAnimal;
import dominio.servicio.JlaService;

import java.util.List;
import java.util.Optional;

public class LoteAnimalServiceImpl implements JlaService<LoteAnimal,Integer> {

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
        return List.of();
    }

    @Override
    public Optional<LoteAnimal> findById(Integer integer) {
        return Optional.empty();
    }
}
