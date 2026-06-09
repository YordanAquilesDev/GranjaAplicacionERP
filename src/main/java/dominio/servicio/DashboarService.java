package dominio.servicio;

import java.util.List;
import dominio.modelos.*;

public interface DashboarService {

    double[] porcentajeEnVentas();

    double[] porcentajesEnLotes();

    double[] porcentajesEnPedidos();


}