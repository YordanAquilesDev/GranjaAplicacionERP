package aplication.repository;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import domain.model.DetalleCompra;
import domain.repository.JpaRepository;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import presentacion.app.ConexionPostgresSQL;

public class DetalleCompraRepository implements JpaRepository<DetalleCompra,Integer> {
    Connection conexion;

    public DetalleCompraRepository() {
        this.conexion = ConexionPostgresSQL.getConexion();
    }


    @Override
    public int saveAndFindId(DetalleCompra objeto) {
        return 0;
    }

    @Override
    public int update(DetalleCompra objeto) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public Optional<DetalleCompra> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<DetalleCompra> findAll() {
        return List.of();
    }

    @Override
    public int save(DetalleCompra beans) {
         Connection conexionPostgres= null;
        PreparedStatement preparar=null;
        int filasAfectadas = 0;
        try {
            String sql = """
                    INSERT INTO detalle_compra VALUES
                                            (?,?)
                   ;
                    """;
            conexionPostgres = ConexionPostgresSQL.getConexion();
            preparar = conexionPostgres.prepareStatement(sql);
           
            filasAfectadas = preparar.executeUpdate();
            return filasAfectadas;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;

        }finally {
            try{
                if(preparar!=null){preparar.close();}
                if(conexionPostgres!=null){conexionPostgres.close();}

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
