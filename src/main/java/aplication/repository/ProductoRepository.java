package aplication.repository;

import domain.model.Producto;
import domain.repository.JpaRepository;
import presentacion.app.ConexionPostgresSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoRepository implements JpaRepository< Producto, Integer  > {
    Connection conexion;
    public ProductoRepository() {
        this.conexion = ConexionPostgresSQL.getConexion();
    }


    @Override
    public int saveAndFindId(Producto objeto) {
        return 0;
    }

    @Override
    public int update(Producto objeto) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        try{
            String sql = """
                    SELECT * FROM producto WHERE id_producto = ?;
                    
                    """;
            PreparedStatement preparar= conexion.prepareStatement(sql);
            preparar.setLong(1, id);
            ResultSet resultado = preparar.executeQuery();
            resultado.next();
            return Optional.of(new Producto(
                    resultado.getInt("id_producto"),
                    resultado.getInt("stock_actual"),
                    resultado.getString("unidad_medida"),
                    resultado.getString("nombre"),
                    resultado.getString("tipo_producto"),
                    resultado.getDouble("precio_unidad")
            ));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Producto> findAll() {
        List<Producto> productos = new ArrayList<>();
        try{
            String sql= """
                    SELECT * FROM Producto
                    """;
            PreparedStatement preparar=conexion.prepareStatement(sql);
            ResultSet resultado=preparar.executeQuery();
            while(resultado.next()){
                productos.add(new Producto(
                        resultado.getInt("id_producto"),
                        resultado.getInt("stock_actual"),
                        resultado.getString("unidad_medida"),
                        resultado.getString("nombre"),
                        resultado.getString("tipo_producto"),
                        resultado.getDouble("precio_unidad")
                ));
            }
            return productos;

        }catch(Exception e){
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public int save(Producto beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
