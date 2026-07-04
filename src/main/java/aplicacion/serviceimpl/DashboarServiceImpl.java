package aplicacion.serviceimpl;

import dominio.servicio.DashboarService;

public class DashboarServiceImpl implements DashboarService {
    private final VentaService ventaService;
    private final LoteAnimalService loteAnimalService;
    private final CompraService compraService;
    public DashboarServiceImpl(){  
        this.ventaService= new VentaServiceImpl();
        this.compraService= new CompraServiceImpl();
        this.loteAnimalService= new LoteAnimalServiceImpl();
    }

      public  double[] porcentajeEnVentas(){
        

        
        double[] porcentajes= new double[2];
        return porcentajes;
      }

   public  double[] porcentajesEnLotes(){

        
        double[] porcentajes= new double[2];
        return porcentajes;
    }

    public double[] porcentajesEnPedidos(){
            
        double[] porcentajes= new double[2];
        return porcentajes;
    }

}