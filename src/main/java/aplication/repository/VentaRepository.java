package aplication.repository;

import aplication.service.DetalleVentaService;
import domain.model.Venta;
import domain.repository.JpaRepository;
import presentacion.app.ConexionPostgresSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VentaRepository implements JpaRepository<Venta,Integer   > {
  private final DetalleVentaService detalleVentaServiceImpl;
    public VentaRepository() {
  this.detalleVentaServiceImpl = new DetalleVentaService();
    }

// C:\Users\yorda\AppData\Local\SceneBuilder\

    @Override
    public int saveAndFindId(Venta venta) {
       PreparedStatement preparar= null;
       Connection connection = null;
       int respuesta=-1;
       try{
           String sql= """
                   insert into venta values(?,?,?)
                   """;
           connection=ConexionPostgresSQL.getConexion();
           preparar= connection.prepareStatement(sql);
           preparar.setInt(1,venta.getCliente().getIdCliente());
           preparar.setDate(2, Date.valueOf(venta.getFecha().toString()));
           preparar.setDouble(3,venta.getTotal());
           respuesta=preparar.executeUpdate();
           if(respuesta>0){
               venta.getDetalleVenta().forEach(detalleVentaServiceImpl::save);
           }
           return respuesta;
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    public int update(Venta objeto) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public Optional<Venta> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<Venta> findAll() {
        List<Venta> ventas = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        try{
            String sql= """
                    SELECT * FROM venta
                    """;
            conexion= ConexionPostgresSQL.getConexion();
            sentencia= conexion.prepareStatement(sql);
            resultado = sentencia.executeQuery();
            int temp=0;
            while(resultado.next()){

                ventas.add(new Venta(resultado.getInt(1),
                        null,
                        resultado.getDate(3),
                        resultado.getDouble(4)));

            }
            return ventas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int save(Venta beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
