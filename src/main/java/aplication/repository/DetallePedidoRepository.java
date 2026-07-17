package aplication.repository;

import domain.model.DetallePedido;
import domain.repository.JpaRepository;
import presentacion.app.ConexionPostgresSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DetallePedidoRepository implements JpaRepository<DetallePedido, Integer> {
    Connection conexion;
    public DetallePedidoRepository() {
        this.conexion = ConexionPostgresSQL.getConexion();
    }

    public DetallePedido guardar(DetallePedido detallePedido) {
        try{
            String sql= """
                    INSERT INTO detalle_pedido (id_pedido,id_producto,cantidad,subtotal)
                    VALUES (?,?,?,?) RETURNING *;
                    """;

            PreparedStatement preparar= conexion.prepareStatement(sql);
            preparar.setInt(1,detallePedido.getPedido().getIdPedido());
            preparar.setInt(2,detallePedido.getProducto().getIdProducto());
            preparar.setInt(3,detallePedido.getCantidad());
            preparar.setDouble(4,detallePedido.getSubTotal());
            ResultSet resultado= preparar.executeQuery();
            if(resultado.next()){
                detallePedido.setIdDetalle(resultado.getInt("id_detalle"));
                return detallePedido;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public int saveAndFindId(DetallePedido objeto) {
        return 0;
    }

    @Override
    public int update(DetallePedido objeto) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public Optional<DetallePedido> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<DetallePedido> findAll() {
        return List.of();
    }
}
