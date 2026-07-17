package aplication.repository;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import domain.model.DetalleCompra;
import domain.repository.JpaRepository;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
