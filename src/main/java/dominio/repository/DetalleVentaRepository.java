package dominio.repository;

import dominio.modelos.DetalleVenta;

import java.sql.Date;
import java.util.List;

public interface DetalleVentaRepository{

    int save(DetalleVenta  beans);

    List<DetalleVenta> finAll();

    List<DetalleVenta> finAllByDate(Date fecha1,Date fecha2);

}