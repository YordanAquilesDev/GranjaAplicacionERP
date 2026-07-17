package aplication.repository;

import domain.model.Proveedor;
import domain.repository.JpaRepository;
import presentacion.app.ConexionPostgresSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProveedorRepository implements JpaRepository<Proveedor,Integer   > {
   Connection c;
    public ProveedorRepository() {
        this.c= ConexionPostgresSQL.getConexion();
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
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public Optional<Proveedor> findById(Integer id) {
        try {
            String sql = "select * from proveedor where id_proveedor=?";
            PreparedStatement preparar= c.prepareStatement(sql);
            preparar.setInt(1,id);
            ResultSet resultado=preparar.executeQuery();
            resultado.next();
            return Optional.of(new Proveedor(
                    resultado.getInt("id_proveedor"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("dni"),
                    resultado.getString("telefono")
            ));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Proveedor> findAll() {
        return List.of();
    }
}
