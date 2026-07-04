package aplicacion.repositoryimpl;

import dominio.modelos.Venta;
import presentacion.app.ConexionPostgresSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaRepositoryImpl implements VentaRepository {
    private final ClienteRepository clienteRepository;
    public VentaRepositoryImpl() {
        this.clienteRepository = new ClienteRepositoryImpl();
    }
    @Override
    public Venta guardar(Venta venta) {
        return null;
    }

    @Override
    public List<Venta> listarVentas() {
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
                        clienteRepository.traerPorId(resultado.getInt(2)),
                        resultado.getDate(3),
                        resultado.getDouble(4)));

            }
            return ventas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Venta> listarMejoresVentas() {
        return List.of();
    }

    @Override
    public List<Venta> listarPorFecha(Date fecha, Date fecha2) {
        return List.of();
    }
}
