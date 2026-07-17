package aplication.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import domain.model.Cliente;
import domain.repository.JpaRepository;
import presentacion.app.ConexionPostgresSQL;

public class ClienteRepository implements JpaRepository<Cliente, Integer> {
  

    @Override
    public int saveAndFindId(Cliente cliente) {
        int filaAfecta = -1;
        Connection conexion= null;
        PreparedStatement  preparar= null;
        try {
            String sql = """
                    INSERT INTO cliente
                        (nombre,apellido,dni,celular,direccion)
                    VALUES
                                            (?,?,?,?,?) RETURNING id_cliente;
                    """;
            
            conexion= ConexionPostgresSQL.getConexion();
         preparar = conexion.prepareStatement(sql);
            preparar.setString(1, cliente.getNombre());
            preparar.setString(2, cliente.getApellido());
            preparar.setString(3, cliente.getDni());
            preparar.setString(4, cliente.getCelular());
            preparar.setString(5, cliente.getDireccion());
            filaAfecta = preparar.executeUpdate();

            return filaAfecta;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return filaAfecta;
    }

    @Override
    public int update(Cliente objeto) {
        PreparedStatement preparar= null;
         Connection conexion= null;
        int filaAfecta = -1;
        try {
            String sql = """
                    UPDATE cliente
                    SET nombre=?,apellido=?,dni=?,celular=?,direccion=?
                    WHERE id_cliente = ?;
                    """;
            conexion= ConexionPostgresSQL.getConexion();
            preparar = conexion.prepareStatement(sql);
            filaAfecta = preparar.executeUpdate();
            return filaAfecta;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    @Override
    public int delete(Integer id) {
        Connection conexionPostgres= null;
        PreparedStatement preparar=null;
        try{
            String sql = """
                  DELETE FROM cliente WHERE id_cliente = ?;
                  
            """;
            conexionPostgres = ConexionPostgresSQL.getConexion();
            preparar= conexionPostgres.prepareStatement(sql);
            preparar.setInt(1, id);

            return preparar.executeUpdate();
        } catch (SQLException e) {
            return -1;
        }finally {
            try{
                if(preparar!=null){preparar.close();}
                if(conexionPostgres!=null){conexionPostgres.close();}

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
         PreparedStatement preparar= null;
         Connection conexion= null;
        try {
            String sql = """
                    SELECT * FROM cliente WHERE id_cliente = ?;
                    """;
              conexion= ConexionPostgresSQL.getConexion();
             preparar = conexion.prepareStatement(sql);
            preparar.setInt(1, id);
            ResultSet resultado = preparar.executeQuery();
            resultado.next();
            return Optional.of(new Cliente(
                    resultado.getInt("id_cliente"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("celular"),
                    resultado.getString("dni"),
                    resultado.getString("direccion")));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public List<Cliente> findAll() {
         PreparedStatement preparar= null;
         Connection conexion= null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            String sql = """
                            SELECT * FROM cliente;


                    """;
            conexion= ConexionPostgresSQL.getConexion();
            preparar = conexion.prepareStatement(sql);
            ResultSet resultado = preparar.executeQuery();
            while (resultado.next()) {
                clientes.add(new Cliente(
                        resultado.getInt("id_cliente"),
                        resultado.getString("nombre"),
                        resultado.getString("apellido"),
                        resultado.getString("dni"),
                        resultado.getString("celular"),
                        resultado.getString("direccion")));

            }
            return clientes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int save(Cliente beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
