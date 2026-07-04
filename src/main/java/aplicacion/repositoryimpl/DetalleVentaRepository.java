package aplicacion.repositoryimpl;

import aplicacion.serviceimpl.ProductoServiceImpl;
import aplicacion.serviceimpl.VentaServiceImpl;
import dominio.modelos.DetalleVenta;
import dominio.repository.JpaRepository;
import presentacion.app.ConexionPostgresSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetalleVentaRepository implements JpaRepository<DetalleVenta,Integer   > {

    public DetalleVentaRepository() {

    }

    public int save(DetalleVenta beans) {
        PreparedStatement sentencia = null;
        Connection conexion = null;
        try{
            String sql= """
                    INSERT INTO detalle_venta (id_venta,id_producto,cantidad,subtotal)
                    VALUES (?,?,?,?);
                    """;
            conexion= ConexionPostgresSQL.getConexion();
            sentencia=conexion.prepareStatement(sql);
            sentencia.setInt(1,beans.getVenta().getIdVenta());
            sentencia.setInt(2,beans.getProducto().getIdProducto());
            sentencia.setInt(3,beans.getCantidad());
            sentencia.setDouble(4,beans.getSubtotal());
            return sentencia.executeUpdate();

        } catch (SQLException e) {
            return -1;

        }finally{
            try{
                if(sentencia!=null){sentencia.close();}
                if(conexion!=null){conexion.close();}
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<DetalleVenta> findAll() {
        List<DetalleVenta> detalleVentas = new ArrayList<>();
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Connection conexion = null;
        try{
            String sql= """
                    SELECT * FROM detalle_venta;
                    """;
            conexion= ConexionPostgresSQL.getConexion();
            sentencia= conexion.prepareStatement(sql);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
               detalleVentas.add(new DetalleVenta(resultado.getInt(1),
                       null,
                       null,
                       resultado.getInt(4),
                       resultado.getDouble(5)
               ));
            }
            return detalleVentas;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            try{
                if(conexion!=null){conexion.close();}
                if(sentencia!=null){sentencia.close();}
                if(resultado!=null){resultado.close();}
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }


    @Override
    public int saveAndFindId(DetalleVenta objeto) {
        return 0;
    }

    @Override
    public int update(DetalleVenta objeto) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public Optional<DetalleVenta> findById(Integer integer) {
        return Optional.empty();
    }


}
