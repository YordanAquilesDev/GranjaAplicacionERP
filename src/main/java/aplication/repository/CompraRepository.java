package aplication.repository;

import aplication.service.DetalleCompraService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import aplication.service.ProveedorService;
import domain.model.Compra;
import domain.model.DetalleCompra;
import domain.model.Proveedor;
import domain.repository.JpaRepository;
import domain.service.JlaService;
import java.sql.Statement;
import presentacion.app.ConexionPostgresSQL;

public class CompraRepository implements JpaRepository<Compra,Integer> {
   
    private final JlaService<Proveedor,Integer> proveedorService;
    private final JlaService<DetalleCompra,Integer>  detalleCompraService;

    public CompraRepository() {
        this.proveedorService = new ProveedorService();
        this.detalleCompraService= new DetalleCompraService();
      
    }


   @Override
public int saveAndFindId(Compra objeto) {
    Connection conexion = null;
    PreparedStatement preparar = null;
    ResultSet rs = null; // Necesario para leer el ID generado
    int idGenerado = -1;
    try {
       String sql = "INSERT INTO compra (id_proveedor, fecha, total) VALUES (?, ?, ?)";
        conexion = ConexionPostgresSQL.getConexion(); 
        preparar = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        int filasAfectadas = preparar.executeUpdate();
 
        if (filasAfectadas > 0) {
            rs = preparar.getGeneratedKeys(); 
            if (rs.next()) {
                idGenerado = rs.getInt(1); 
            }
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try { if (rs != null) rs.close(); 
        if (preparar != null) preparar.close(); 
         if (conexion != null) conexion.close(); 
        } catch (SQLException e) { 
            e.printStackTrace(); }
    }
    
    return idGenerado;
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
        Connection conexion= null;
        PreparedStatement preparar= null;
        try {
            String sql = """
                            SELECT * FROM compra
                            WHERE id_compra=?
                    """;
            conexion= ConexionPostgresSQL.getConexion();
            preparar = conexion.prepareStatement(sql);
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
          Connection conexion= null;
               PreparedStatement preparar= null;
        try {
            String sql = """
                    SELECT * FROM compra
                    """;
            conexion= ConexionPostgresSQL.getConexion();
            preparar = conexion.prepareStatement(sql);
            ResultSet resultado = preparar.executeQuery();
            while (resultado.next()) {
      
                compras.add(new Compra(
                        resultado.getInt("id_compra"),
                        resultado.getDate("fecha"),
                        proveedorService.findById( resultado.getInt("id_proveedor")).orElse(null),
                        resultado.getDouble("total")));
            }
            return compras;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int save(Compra beans) {
        int respuesta=-1;
        try{
        int idGenerado= saveAndFindId(beans);
        beans.getDetalleCompras().forEach(detalle->{
            detalle.getCompra().setIdCompra(idGenerado);
            detalleCompraService.save(detalle);
        });
        return 1;
        }catch(Exception e){
            
        }
       
        return respuesta;
    }
}
