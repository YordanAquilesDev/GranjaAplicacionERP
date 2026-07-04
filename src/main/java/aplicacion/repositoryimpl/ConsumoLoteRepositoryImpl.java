package aplicacion.repositoryimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dominio.modelos.Animal;
import dominio.modelos.ConsumoLote;
import dominio.modelos.LoteAnimal;
import dominio.modelos.Producto;
import dominio.repository.JpaRepository;
import dominio.servicio.JlaService;
import presentacion.app.ConexionPostgresSQL;

public class ConsumoLoteRepositoryImpl implements JpaRepository<ConsumoLote, Integer> {
    Connection conexion;

    public ConsumoLoteRepositoryImpl() {

        this.conexion = ConexionPostgresSQL.getConexion();

    }



    public List<ConsumoLote> listarConsumoLotes() {
        List<ConsumoLote> consumos = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();
        try {
            String sql = """
                    SELECT * FROM consumo_lote;
                    """;
            PreparedStatement preparar = conexion.prepareStatement(sql);
            ResultSet resultado = preparar.executeQuery();
            boolean Cambia = false;
            int temp = 1;
            while (resultado.next()) {
                int valorAnterior = resultado.getInt("id_consumo");
                if (valorAnterior > temp) {
                    Cambia = true;
                }
                if (Cambia) {
                    consumos.add(new ConsumoLote(
                            resultado.getInt("id_consumo"),
                            null,
                            resultado.getInt("cantidad"),
                            null,
                            resultado.getDate("fecha")

                    ));
                    productos = new ArrayList<>();

                }
                productos.add(null);
                temp = valorAnterior;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return List.of();
    }



    public ConsumoLote obtenerConsumoPorId(Long id) {
        try {
            String sql = """
                    SELECT * FROM consumo_lote
                    WHERE id_consumo= ?
                    """;
            PreparedStatement preparar = conexion.prepareStatement(sql);
            preparar.setLong(1, id);
            ResultSet resultado = preparar.executeQuery();
            if (resultado.next()) {
                return new ConsumoLote(
                        resultado.getInt("id_consumo"),
                        null,
                        resultado.getInt("cantidad"),
                        null,
                        resultado.getDate("fecha"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<ConsumoLote> obtenerConsumoLotePorAnimal(Animal animal) {
        try {
            String sql = """
                    SELECT * FROM consumo_lote cl
                    JOIN lote_animal la ON cl.id_lote = la.id_lote
                    WHERE la.id_animal = ?
                    """;
            PreparedStatement preparar = conexion.prepareStatement(sql);
            preparar.setInt(1, animal.getIdAnimal());
            ResultSet resultado = preparar.executeQuery();
            List<ConsumoLote> consumos = new ArrayList<>();
            while (resultado.next()) {
                consumos.add(new ConsumoLote(
                        resultado.getInt("id_consumo"),
                       null,
                        resultado.getInt("cantidad"),
                        null,
                        resultado.getDate("fecha")));
            }
            return consumos;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }


    @Override
    public int saveAndFindId(ConsumoLote objeto) {
        try {
            String sql = """
                    INSERT INTO consumo_lote VALUES
                    (?,?,?,?)

                    """;
            PreparedStatement preparar = conexion.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ResultSet resultado = preparar.executeQuery();
            return resultado.getInt("id_consumo");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(ConsumoLote objeto) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public Optional<ConsumoLote> findById(Integer id) {
        try {
            String sql = """
                    SELECT * FROM consumo_lote
                    WHERE id_consumo= ?
                    """;
            PreparedStatement preparar = conexion.prepareStatement(sql);
            preparar.setLong(1, id);
            ResultSet resultado = preparar.executeQuery();
            if (resultado.next()) {
                return Optional.of(new ConsumoLote(
                        resultado.getInt("id_consumo"),
                        null,
                        resultado.getInt("cantidad"),
                        null,
                        resultado.getDate("fecha")));
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ConsumoLote> findAll() {
        return List.of();
    }
}
