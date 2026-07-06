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
}
