package dominio.repository;

import java.sql.Date;

public interface DetalleVentaRepository{

    int save(DetalleVenta  beans);

    List<DetalleVenta> finAll();

    List<DetalleVenta> finAllByDate(Date fecha1,Date fecha2);

}