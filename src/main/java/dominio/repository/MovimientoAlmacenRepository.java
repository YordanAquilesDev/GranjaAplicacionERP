package dominio.repository;

import dominio.modelos.MovimientoAlmacen;

public interface  MoviminetoAlmacenRepository{
    int save(MovimientoAlmacen beans);

    List<MovimientoAlmacen> finAll();
    
    List<MovimientoAlmacen> finAllDate(Date fecha1,Date fecha2);
}