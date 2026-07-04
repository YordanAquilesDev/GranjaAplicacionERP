package aplicacion.repositoryimpl;

import dominio.modelos.Proveedor;
import dominio.repository.JpaRepository;
import presentacion.app.ConexionPostgresSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProveedorRepositoryImpl implements JpaRepository<Proveedor,Integer   > {
   Connection c;
    public ProveedorRepositoryImpl() {
        this.c= ConexionPostgresSQL.getConexion();
    }

    @Override
    public Proveedor guardar(Proveedor proveedor) {
        return null;
    }

    @Override
    public Proveedor buscarPorId(long id) {
        try {
            String sql = "select * from proveedor where id_proveedor=?";
            PreparedStatement preparar= c.prepareStatement(sql);
            preparar.setLong(1,id);
            ResultSet resultado=preparar.executeQuery();
            resultado.next();
            return new Proveedor(
                    resultado.getInt("id_proveedor"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("dni"),
                    resultado.getString("telefono")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Proveedor Actualizar(Proveedor proveedor) {
        return null;
    }

    @Override
    public Proveedor Eliminar(long id) {
        return null;
    }

    @Override
    public List<Proveedor> listarProveedores() {
        return List.of();
    }

    @Override
    public int updateProveedor(Proveedor proveedor) {
        return 0;
    }

    @Override
    public int saveAndFindId(Proveedor objeto) {
        return 0;
    }

    @Override
    public int update(Proveedor objeto) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public Optional<Proveedor> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<Proveedor> findAll() {
        return List.of();
    }
}
