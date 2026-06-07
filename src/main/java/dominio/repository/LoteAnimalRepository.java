package dominio.repository;

import dominio.modelos.LoteAnimal;

public interface LoteAnimalRepository {
    LoteAnimal guardarLoteAnimal(LoteAnimal loteAnimal);

    LoteAnimal  traerPorId(int id);
  
    int updateLoteCantidadAnimalActual(int id,int cantidadActual);

}
