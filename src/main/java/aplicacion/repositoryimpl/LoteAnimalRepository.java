package aplicacion.repositoryimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import aplicacion.serviceimpl.AnimalServiceImpl;
import dominio.modelos.Animal;
import dominio.modelos.LoteAnimal;
import dominio.repository.JpaRepository;
import dominio.servicio.JlaService;
import presentacion.app.ConexionPostgresSQL;

public class LoteAnimalRepository implements JpaRepository< LoteAnimal , Integer  > {
    Connection conexion;
    private final JlaService<Animal, Integer> animalService;

    public LoteAnimalRepository () {

        this.conexion = ConexionPostgresSQL.getConexion();
        this.animalService= new AnimalServiceImpl();
    }


    public LoteAnimal guardarLoteAnimal(LoteAnimal loteAnimal) {
        try {
            String sql = """
                    INSERT INTO lote_animal VALUES (?,?,?,?,?,?)
                    """;
            PreparedStatement preparar = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparar.setInt(1, loteAnimal.getAnimal().getIdAnimal());
            preparar.setDate(2, loteAnimal.getFechaInicio());
            preparar.setInt(3, loteAnimal.getCantidadInicio());
            preparar.setInt(4, loteAnimal.getCantidadActual());
            preparar.setDouble(5, loteAnimal.getPesoPromedio());
            preparar.setString(6, loteAnimal.getEstadoLote());
            ResultSet resultado = preparar.executeQuery();
            resultado.next();
            int idGenerado = resultado.getInt("id_animal");
            loteAnimal.setIdLote(idGenerado);
            return loteAnimal;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public int updateLoteCantidadAnimalActual(int cantidadActual){
        try{
            String sql="""
                UPDATE lote_animal
                SET cantidad= ?

            """;
            PreparedStatement preparar = conexion.prepareStatement(sql);
            preparar.setInt(1,cantidadActual);
            return  preparar.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int saveAndFindId(LoteAnimal objeto) {
        return 0;
    }

    @Override
    public int update(LoteAnimal objeto) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public Optional<LoteAnimal> findById(Integer id) {
        try {
            String sql ="""
                    SELECT * FROM lote_animal
                    WHERE id_lote=?
                    """;
            PreparedStatement preparar = conexion.prepareStatement(sql);
            preparar.setInt(1, id);
            ResultSet resultado = preparar.executeQuery();
            resultado.next();
            return Optional.of(new LoteAnimal(
                    resultado.getInt("id_lote"),
                    null,
                    resultado.getDate("fecha_inicio"),
                    resultado.getInt("cantidad_inicio"),
                    resultado.getInt("cantidad_actual"),
                    resultado.getDouble("peso_promedio"),
                    resultado.getString("estado_lote")));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<LoteAnimal> findAll() {
        List<LoteAnimal> loteAnimals = new ArrayList<>();
        ResultSet resultado = null;

        try {
            String sql ="""
                    SELECT * FROM lote_animal
               
                    """;
            PreparedStatement preparar = conexion.prepareStatement(sql);
            resultado = preparar.executeQuery();
            resultado.next();
            while(resultado.next()){
                loteAnimals.add(new LoteAnimal(
                        resultado.getInt("id_lote"),
                        animalService.findAll().get(resultado.getInt("id_animal")),
                        resultado.getDate("fecha_inicio"),
                        resultado.getInt("cantidad_inicio"),
                        resultado.getInt("cantidad_actual"),
                        resultado.getDouble("peso_promedio"),
                        resultado.getString("estado")));

            }
            System.out.println(loteAnimals.size());
            return loteAnimals;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
