package aplicacion.repositoryimpl;

import aplicacion.serviceimpl.ProductoServiceImpl;
import aplicacion.serviceimpl.VentaServiceImpl;
import dominio.modelos.DetalleVenta;
import dominio.repository.DetalleVentaRepository;
import dominio.servicio.ProductoService;
import dominio.servicio.VentaService;
import presentacion.app.ConexionPostgresSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaRepositoryImpl implements DetalleVentaRepository {
    private final VentaService ventaService;
    private final ProductoService productoService;
    public DetalleVentaRepositoryImpl() {
        this.ventaService =new VentaServiceImpl();
        this.productoService= new ProductoServiceImpl();
    }
    @Override
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
    public List<DetalleVenta> finAll() {
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
                       ventaService.obtenerUnaVentaPorId(resultado.getInt(2)),
                       productoService.obtenerUnProductoPorId(resultado.getInt(3)),
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
    public List<DetalleVenta> finAllByDate(Date fecha1, Date fecha2) {
        PreparedStatement sentencia = null;
        Connection conexion = null;
        ResultSet resultado = null;
        List<DetalleVenta> detalleVentas = new ArrayList<>();

        try{
            String sql = """
                    SELECT * FROM detalle_venta dv
                    JOIN Venta v ON dv.id_venta= v.id_venta
                    WHERE v.fecha BETWEEN ? AND ?;
                    
                    """;
            conexion= ConexionPostgresSQL.getConexion();
            sentencia=conexion.prepareStatement(sql);
            sentencia.setDate(1, fecha1);
            sentencia.setDate(2, fecha2);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                detalleVentas.add(new DetalleVenta(resultado.getInt(1),
                        ventaService.obtenerUnaVentaPorId(resultado.getInt(2)),
                        productoService.obtenerUnProductoPorId(resultado.getInt(3)),
                        resultado.getInt(4),
                        resultado.getDouble(5)
                ));
            }
            return detalleVentas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
