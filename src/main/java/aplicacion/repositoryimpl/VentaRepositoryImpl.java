package aplicacion.repositoryimpl;

import dominio.modelos.Venta;
import dominio.repository.JpaRepository;
import presentacion.app.ConexionPostgresSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VentaRepositoryImpl implements JpaRepository<Venta,Integer   > {

    public VentaRepositoryImpl() {


    }



    @Override
    public int saveAndFindId(Venta objeto) {
        return 0;
    }

    @Override
    public int update(Venta objeto) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public Optional<Venta> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<Venta> findAll() {
        List<Venta> ventas = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        try{
            String sql= """
                    SELECT * FROM venta
                    """;
            conexion= ConexionPostgresSQL.getConexion();
            sentencia= conexion.prepareStatement(sql);
            resultado = sentencia.executeQuery();
            int temp=0;
            while(resultado.next()){

                ventas.add(new Venta(resultado.getInt(1),
                        null,
                        resultado.getDate(3),
                        resultado.getDouble(4)));

            }
            return ventas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
