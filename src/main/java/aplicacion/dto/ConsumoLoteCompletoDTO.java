package aplicacion.dto;

import aplicacion.serviceimpl.ConsumoLoteService;
import dominio.modelos.ConsumoLote;
import dominio.modelos.LoteAnimal;
import dominio.modelos.Producto;
import dominio.servicio.JlaService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ConsumoLoteCompletoDTO {
    List<ConsumoLote> consumoLote= new ArrayList<>();
    public void addConsumoLote(Producto producto, LoteAnimal lote,int cantidad, Date fecha) {
      ConsumoLote consumo = new ConsumoLote();
      consumo.setProducto(producto);
      consumo.setCantidad(cantidad);
      consumo.setLote(lote);
      consumo.setFecha(fecha);
        this.consumoLote.add(consumo);
    }

}

class  guardarConsumoLote{
    private final JlaService<ConsumoLote,Integer> consumoLoteService;
    public guardarConsumoLote(JlaService<ConsumoLote, Integer> consumoLoteService, ConsumoLoteCompletoDTO consumoLote) {
        this.consumoLoteService = consumoLoteService;

        this.consumoLote = consumoLote;
    }

    private final ConsumoLoteCompletoDTO consumoLote;

    public void anadirConsumoLote(){
        LoteAnimal loteCosumidor= new LoteAnimal();
        Producto producto= new Producto();
        consumoLote.addConsumoLote(
                new Producto(),
                new LoteAnimal(),
                10,
                new Date(20,10,10)
        );
    }

}
