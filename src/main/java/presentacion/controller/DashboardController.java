package presentacion.controller;

import aplicacion.serviceimpl.CompraServiceImpl;
import aplicacion.serviceimpl.VentaServiceImpl;
import dominio.modelos.Compra;
import dominio.modelos.Venta;
import dominio.servicio.CompraService;
import dominio.servicio.VentaService;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import presentacion.util.CreadorGraficoLineChar;

import java.util.List;

public class DashboardController {
    private final CompraService compraService;
    private final VentaService ventaService;
    public DashboardController() {
        this.compraService = new CompraServiceImpl();
        this.ventaService = new VentaServiceImpl();
    }

    @FXML
    private LineChart<String, Number> graficoBalance;

    @FXML
    public void initialize() {
        if (graficoBalance.getYAxis() instanceof NumberAxis) {
            NumberAxis yAxis = (NumberAxis) graficoBalance.getYAxis();

            // 1. Apagamos el cálculo automático para tomar el control de los pasos
            yAxis.setAutoRanging(false);

            // 2. Definimos los límites rígidos del eje
            yAxis.setLowerBound(0);         // Empieza en 0
            yAxis.setUpperBound(500000);    // El techo máximo será 500K

            // 3. ¡ESTA ES LA CLAVE! Forzamos a que aparezca una línea guía EXACTAMENTE cada 100,000
            yAxis.setTickUnit(100000);

            // 4. Le damos el formato compacto 'K' para que no sature la pantalla de ceros
            yAxis.setTickLabelFormatter(new javafx.util.StringConverter<Number>() {
                @Override
                public String toString(Number object) {
                    double valor = object.doubleValue();
                    if (valor >= 1000) {
                        return String.format("%.0fK", valor / 1000); // Transforma 100000 en 100K
                    }
                    return String.format("%.0f", valor);
                }

                @Override
                public Number fromString(String string) {
                    return 0;
                }
            });
        }
        List<Compra> compras = compraService.obtenerTodasLasCompras();
        List<Venta> ventas = ventaService.obtenerTodasLasVentas();

        // Tus validaciones de consola (¡Excelente para hacer debug!)
        if (compras.isEmpty()) {
            System.out.println("Compras no encontrado");
        }
        if (ventas.isEmpty()) {
            System.out.println("Ventas no encontrado");
        }

        for (Compra compra : compras) {
            System.out.println("ID Compra cargada: " + compra.getIdCompra());
        }
        for (Venta venta : ventas) {
            System.out.println("ID Venta cargada: " + venta.getIdVenta());
        }

        // =======================================================================
        // 🌟 LO QUE FALTABA: Mapear y procesar las listas cronológicamente
        // =======================================================================

        // Procesamos la lista de ventas usando la nueva función con comodín (?) para la fecha
        XYChart.Series<String, Number> serieVentas = CreadorGraficoLineChar.mapearListaASerie(
                "Ventas Totales",
                ventas,
                Venta::getFecha,
                Venta::getTotal
        );

        // Procesamos la lista de compras
        XYChart.Series<String, Number> serieCompras = CreadorGraficoLineChar.mapearListaASerie(
                "Compras / Inversión",
                compras,
                Compra::getFecha,
                Compra::getTotal
        );

        // =======================================================================
        // 🎨 RENDERIZAR LAS SERIES PROCESADAS EN EL GRÁFICO
        // =======================================================================

        // Ahora sí pasamos las variables 'serieVentas' y 'serieCompras' (¡Ya no las listas directas!)
        CreadorGraficoLineChar.graficarMultiplesLineas(
                graficoBalance,
                "Balance Financiero: Ingresos vs Egresos",
                serieVentas,
                serieCompras
        );

        // Optimizamos el eje Y para que no se aplasten las curvas
        if (graficoBalance.getYAxis() instanceof NumberAxis) {
            NumberAxis yAxis = (NumberAxis) graficoBalance.getYAxis();
            yAxis.setAutoRanging(true);
            yAxis.setForceZeroInRange(true);
        }
    }
}
