package presentacion.controller;

import domain.model.Pedido;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import presentacion.util.CrearGraficoCircular; // Asegúrate de importar tu clase utilitaria

import java.util.List;

public class PedidoController {


    // Inyectamos el contenedor que agregamos en el FXML
    @FXML
    private VBox contenedorGrafico;

    // Las listas se declaran aquí, pero NO se cargan directamente para evitar el NullPointerException
    private List<Pedido> todosLosPedidos;

    // Constructor: Aquí inicializas el servicio de forma segura
    public PedidoController(){
    }

    @FXML
    public void initialize() {
        try {
            // 1. Cargamos los datos desde el servicio de manera segura una vez instanciado

            // 2. Validamos que la lista no venga vacía o nula para evitar crashes
            if (todosLosPedidos != null && !todosLosPedidos.isEmpty()) {

                // 3. Generamos el PieChart usando tu clase utilitaria
                PieChart graficoCircular = CrearGraficoCircular.generarGraficoPedidos(todosLosPedidos);

                // 4. Limpiamos cualquier residuo visual e inyectamos el gráfico al contenedor
                contenedorGrafico.getChildren().clear();
                contenedorGrafico.getChildren().add(graficoCircular);

            } else {
                System.out.println("No hay pedidos registrados para graficar.");
            }

        } catch (Exception e) {
            System.err.println("Error al cargar el gráfico estadístico de pedidos.");
            e.printStackTrace();
        }
    }
}