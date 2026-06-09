package presentacion.util;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import java.util.List;
import dominio.modelos.Pedido; // Asegúrate de apuntar a tu paquete correcto de Pedido

public class CrearGraficoCircular {

    /**
     * Genera un gráfico circular (PieChart) basado en el estado de una lista de pedidos.
     * * @param listaPedidos Lista completa de pedidos obtenidos de la base de datos o controlador.
     * @return Un objeto PieChart configurado listo para ser añadido a la interfaz.
     */
    public static PieChart generarGraficoPedidos(List<Pedido> listaPedidos) {

        // 1. Contar los pedidos por cada estado usando Streams de Java
        long entregados = listaPedidos.stream()
                .filter(p -> p.getEstado() != null && p.getEstado().equalsIgnoreCase("Entregados"))
                .count();

        long noEntregados = listaPedidos.stream()
                .filter(p -> p.getEstado() != null && p.getEstado().equalsIgnoreCase("No Entregados"))
                .count();

        long cancelados = listaPedidos.stream()
                .filter(p -> p.getEstado() != null && p.getEstado().equalsIgnoreCase("Cancelados"))
                .count();

        // 2. Crear los datos del gráfico circular mapeando Nombre -> Cantidad
        ObservableList<PieChart.Data> datosGrafico = FXCollections.observableArrayList(
                new PieChart.Data("Entregados (" + entregados + ")", entregados),
                new PieChart.Data("No Entregados (" + noEntregados + ")", noEntregados),
                new PieChart.Data("Cancelados (" + cancelados + ")", cancelados)
        );

        // 3. Instanciar y configurar el componente PieChart
        PieChart graficoCircular = new PieChart(datosGrafico);
        graficoCircular.setTitle("Estado Actual de Pedidos");
        graficoCircular.setClockwise(true);
        graficoCircular.setLabelLineLength(15);
        graficoCircular.setLabelsVisible(true); // Muestra las etiquetas flotantes

        return graficoCircular;
    }
}
