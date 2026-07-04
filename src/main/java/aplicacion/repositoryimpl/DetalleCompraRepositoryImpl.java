package aplicacion.repositoryimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dominio.modelos.DetalleCompra;
import dominio.modelos.Producto;
import dominio.repository.JpaRepository;
import presentacion.app.ConexionPostgresSQL;

public class DetalleCompraRepositoryImpl implements JpaRepository<DetalleCompra,Integer> {
    Connection conexion;

    private final ProductoRepository productoRepository;

    public DetalleCompraRepositoryImpl() {
        this.conexion = ConexionPostgresSQL.getConexion();
        this.productoRepository = new ProductoRepositoryImpl();
    }


    public DetalleCompra Guardar(DetalleCompra nuevoDetalle) {
        String sql = """
                INSERT INTO detalle_compra (id_compra, id_producto, cantidad, subtotal)
                VALUES (?, ?, ?, ?) RETURNING *
                """;

        try {
            int i = 0;

            for (Producto p : nuevoDetalle.getProductos()) {
                PreparedStatement preparar = conexion.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
                preparar.setInt(1, nuevoDetalle.getCompra().getIdCompra());
                preparar.setInt(2, p.getIdProducto());
                preparar.setInt(3, nuevoDetalle.getCantidad().get(i));
                preparar.setDouble(4, nuevoDetalle.getSubtotal().get(i));
                preparar.executeUpdate();
                int filasAfectadas = preparar.getUpdateCount();
                if (filasAfectadas > 0) {
                    try (ResultSet rs = preparar.getGeneratedKeys()) {
                        if (rs.next()) {
                            int idGenerado = rs.getInt(1);

                            nuevoDetalle.setIdDetalle(idGenerado);
                        }
                    }

                }

            }
            return nuevoDetalle;

        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el detalle de compra", e);
        }
    }


    public DetalleCompra ObtenerPorId(Long id) {
        List<Producto> productos = new ArrayList<>();
        List<Integer> cantidades = new ArrayList<>();
        List<Double > subtotals = new ArrayList<>();
        try {
            String sql = """
                    SELECT * FROM detalle_compra
                    WHERE id_detalle= ?
                    """;
            PreparedStatement preparar = conexion.prepareStatement(sql);
            preparar.setLong(1, id);
            ResultSet rs = preparar.executeQuery();
            if (rs.next()) {
                productos.add(productoRepository.buscarPorId(rs.getInt("id_producto")));
                cantidades.add(rs.getInt("cantidad"));
                subtotals.add(rs.getDouble("subtotal"));
                if (rs.next()) {
                    return new DetalleCompra(
                            rs.getInt("id_detalle"), // entero
                           null,
                            productos,
                            cantidades,
                            subtotals);

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DetalleCompra> Listar() {
        List<DetalleCompra> detalles = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();
        List<Integer> cantidades = new ArrayList<>();
        List<Double > subtotals = new ArrayList<>();
        try {
            String sql = """
                    SELECT * FROM detalle_compra
                    """;
            PreparedStatement preparar = conexion.prepareStatement(sql);
            ResultSet rs = preparar.executeQuery();
            int temp = 1;
            while (rs.next()) {
                productos.add(productoRepository.buscarPorId(rs.getInt("id_producto")));
                cantidades.add(rs.getInt("cantidad"));
                subtotals.add(rs.getDouble("subtotal"));
                if (temp < rs.getInt("id_detalle")) {
                    detalles.add(new DetalleCompra(
                            rs.getInt("id_detalle"),
                            null,
                            productos,
                            cantidades,
                            subtotals));

                    temp = rs.getInt("id_detalle");
                    productos = new ArrayList<>();
                    cantidades = new ArrayList<>();
                }
            }
            return detalles;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
}
