package aplication.repository;

import domain.model.Pedido;
import domain.repository.JpaRepository;
import presentacion.app.ConexionPostgresSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoRepository implements JpaRepository<Pedido,Integer   > {

    Connection conexion;


    public PedidoRepository() {
        this.conexion = ConexionPostgresSQL.getConexion();
    }

    public List<Pedido> listarPedidos() {
        List<Pedido> listaPedidos = new ArrayList<>();
        try {
            String sql = """
                    SELECT * FROM pedido
                    """;

            PreparedStatement preparar = conexion.prepareStatement(sql);
            ResultSet resultado = preparar.executeQuery();
            while (resultado.next()) {
                listaPedidos.add(new Pedido(
                        resultado.getInt("id_pedido"),
                        resultado.getDate("fecha"),
                       null,
                        resultado.getString("estado"),
                        resultado.getDouble("total")
                ));

            }
            return listaPedidos;

        } catch (SQLException e) {
            System.out.println("ERROR EN "+ e);
            throw new RuntimeException(e);
        }catch(Exception e){
             System.out.println("ERROR EN "+ e);
            return null;
        }
    }


    @Override
    public int saveAndFindId(Pedido objeto) {
        return 0;
    }

    @Override
    public int update(Pedido objeto) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public Optional<Pedido> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<Pedido> findAll() {
        List<Pedido> listaPedidos = new ArrayList<>();
        try {
            String sql = """
                    SELECT * FROM pedido
                    """;

            PreparedStatement preparar = conexion.prepareStatement(sql);
            ResultSet resultado = preparar.executeQuery();
            while (resultado.next()) {
                listaPedidos.add(new Pedido(
                        resultado.getInt("id_pedido"),
                        resultado.getDate("fecha"),
                        null,
                        resultado.getString("estado"),
                        resultado.getDouble("total")
                ));

            }
            return listaPedidos;

        } catch (SQLException e) {
            System.out.println("ERROR EN "+ e);
            throw new RuntimeException(e);
        }catch(Exception e){
            System.out.println("ERROR EN "+ e);
            return null;
        }
    }

    @Override
    public int save(Pedido beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
