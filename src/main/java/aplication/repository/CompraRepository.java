package aplication.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import aplication.service.ProveedorService;
import domain.model.Compra;
import domain.model.Proveedor;
import domain.repository.JpaRepository;
import domain.service.JlaService;
import presentacion.app.ConexionPostgresSQL;

public class CompraRepository implements JpaRepository<Compra,Integer> {
    Connection conexion;
    private final JlaService<Proveedor,Integer> proveedorService;

    public CompraRepository() {
        this.proveedorService = new ProveedorService();
        this.conexion = ConexionPostgresSQL.getConexion();
    }



    @Override
    public int saveAndFindId(Compra objeto) {
        return 0;
    }

    @Override
    public int update(Compra objeto) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public Optional<Compra> findById(Integer id) {
        try {
            String sql = """
                            SELECT * FROM compra
                            WHERE id_compra=?
                    """;
            PreparedStatement preparar = conexion.prepareStatement(sql);
            preparar.setInt(1, id);
            ResultSet resultado = preparar.executeQuery();
            if (resultado.next()) {
                return Optional.of(new Compra(
                        resultado.getInt("id_compra"),
                        resultado.getDate("fecha"),
                        proveedorService.findById(resultado.getInt("id_proveedor")).orElse(null),
                        resultado.getDouble("total")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Compra> findAll() {
        List<Compra> compras = new ArrayList<>();
        try {
            String sql = """
                    SELECT * FROM compra
                    """;

            PreparedStatement preparar = conexion.prepareStatement(sql);
            ResultSet resultado = preparar.executeQuery();
            while (resultado.next()) {
                Proveedor p;
                p = proveedorService.findById(
                        resultado.getInt("id_proveedor")).orElse(null);

                compras.add(new Compra(
                        resultado.getInt("id_compra"),
                        resultado.getDate("fecha"),
                        p,
                        resultado.getDouble("total")));
            }
            return compras;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
