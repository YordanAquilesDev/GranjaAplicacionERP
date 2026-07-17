package aplication.repository;

import aplication.service.LoteAnimalService;
import aplication.service.ProductoService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import domain.model.Animal;
import domain.model.ConsumoLote;
import domain.model.LoteAnimal;
import domain.model.Producto;
import domain.repository.JpaRepository;
import domain.service.JlaService;
import presentacion.app.ConexionPostgresSQL;

public class ConsumoLoteRepository implements JpaRepository<ConsumoLote, Integer> {
    Connection conexion;
    private final JlaService<LoteAnimal,Integer>  loteAnimalService;
    private final JlaService<Producto,Integer>  productoService;

    public ConsumoLoteRepository() {

        this.loteAnimalService= new LoteAnimalService();
        this.conexion = ConexionPostgresSQL.getConexion();
        this.productoService= new ProductoService();

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
          List<ConsumoLote> consumos = new ArrayList<>();
     
        try {
            String sql = """
                    SELECT * FROM consumo_lote;
                    """;
            PreparedStatement preparar = conexion.prepareStatement(sql);
            ResultSet rs = preparar.executeQuery();
         
            while (rs.next()) {
             consumos.add(new ConsumoLote(
                     rs.getInt("id_consumo" ),
                     loteAnimalService.findById(rs.getInt("id_lote")).orElse(null),
                     rs.getInt("cantidad"),
                     productoService.findById(rs.getInt("id_producto")).orElse(null),
                     rs.getDate("fecha")                  
             ));
            }
            return consumos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
      
    }

    @Override
    public int save(ConsumoLote beans) {
          Connection conexion= null;
               PreparedStatement preparar= null;
               int respuesta;
          try {
            String sql = """
                    INSERT INTO consumo_lote VALUES
                    (?,?,?,?)

                    """;
            conexion= ConexionPostgresSQL.getConexion(); 
            preparar = conexion.prepareStatement(sql);
            // 1.  el lote  que consumio
            preparar.setInt(1, beans.getLote().getIdLote());
            // 2. que consumio
            preparar.setInt(2, beans.getProducto().getIdProducto());
            // 3. cuanto consumio
            preparar.setInt(3,beans.getCantidad());
            // 4. cuando consumio
            preparar.setDate(4, beans.getFecha());
            
            respuesta=preparar.executeUpdate();
          

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
          return respuesta;
    }
}
