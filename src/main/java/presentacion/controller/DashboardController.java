package presentacion.controller;

import javafx.fxml.FXML;

import javafx.scene.chart.BarChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent; // <

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.input.ScrollEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController {

    // Instancia del controlador principal (el que maneja el menú lateral y el contenedor)
    private HomeController mainController;

    // Método setter para inyectar el controlador principal
    public void setMainController(HomeController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void navegarAnimales() {
        if (mainController != null)
            mainController.navegarAnimales();
        System.out.println(mainController);
        System.out.println("navegarAnimales");
    }

    @FXML
    private void navegarLotes() {
        if (mainController != null) mainController.navegarLotes();
    }

    @FXML
    private void navegarPedidos() {
        if (mainController != null) mainController.navegarPedidos();
    }

    @FXML
    private void navegarVentas() {
        if (mainController != null) mainController.navegarVentas();
    }

    @FXML
    private void navegarStock() {
        if (mainController != null) mainController.navegarStock();
    }

    @FXML
    private void navegarMovimientos() {
        if (mainController != null) mainController.navegarMovimientos();
    }
    @FXML
    private void navegarSanidad(MouseEvent event) {
        System.out.println("Navegando a Sanidad y Alertas...");
        // Si usas el mainController para cambiar de pantalla, sería algo como:
        // mainController.cambiarPantalla("/presentacion/fxml/Sanidad.fxml");
    }

    @FXML
    private void navegarEficiencia(MouseEvent event) {
        System.out.println("Navegando a Eficiencia Alimenticia...");
        // mainController.cambiarPantalla("/presentacion/fxml/Eficiencia.fxml");
    }

    @FXML
    private void navegarSensores(MouseEvent event) {
        System.out.println("Navegando a Control Ambiental...");
        // mainController.cambiarPantalla("/presentacion/fxml/Sensores.fxml");
    }

    @FXML
    private void navegarCompras(MouseEvent event) {

    }

    @FXML
    private void navegarFinanzas(MouseEvent event) {

    }

    @FXML
    private ScrollPane scrollPrincipal;
    // 2. Inyecta tus dos tablas pesadas
    @FXML
    private TableView<?> tblRendimientoLotes;
    @FXML
    private TableView<?> tblLotesProximos;

 // Inyecta tu gráfico si aún no lo has hecho


    /**
     * Captura el scroll del mouse sobre la tabla y lo traslada al contenedor principal,
     * evitando que la tabla consuma el evento y se genere lag.
     */
    private void vincularScrollSuave(TableView<?> tabla) {
        if (tabla == null) return;

        tabla.addEventFilter(ScrollEvent.SCROLL, event -> {
            if (scrollPrincipal != null && event.getDeltaY() != 0) {
                // Obtener la cantidad de desplazamiento vertical
                double deltaY = event.getDeltaY();

                // Obtener la altura total del contenido del ScrollPane
                double contentHeight = scrollPrincipal.getContent().getBoundsInLocal().getHeight();
                double viewportHeight = scrollPrincipal.getViewportBounds().getHeight();

                // Calcular el nuevo valor de scroll de manera proporcional
                if (contentHeight > viewportHeight) {
                    double scrollValue = scrollPrincipal.getVvalue();
                    // Ajusta el multiplicador (0.002 o 0.005) según qué tan rápido quieras que baje
                    double nuevoScroll = scrollValue - (deltaY * 0.003);

                    // Limitar los valores entre 0.0 (arriba) y 1.0 (abajo)
                    scrollPrincipal.setVvalue(Math.max(0.0, Math.min(1.0, nuevoScroll)));
                }

                // IMPORTANTE: Consumir el evento para que la tabla no intente procesarlo internamente
                event.consume();
            }
        });
    }

// Asegúrate de tener inyectado tu ScrollPane

    @FXML
    private BarChart<?, ?> chartBalance;

    @FXML
    public void initialize() {
        if (chartBalance != null) {
            chartBalance.setAnimated(false);
        }

        if (scrollPrincipal != null) {
            // CAMBIADO: Usamos addEventFilter para interceptar el evento a la fuerza
            scrollPrincipal.addEventFilter(ScrollEvent.SCROLL, event -> {
                // 1. Iniciar el cronómetro de rendimiento
                long tiempoInicio = System.nanoTime();

                double deltaY = event.getDeltaY();
                double contentHeight = scrollPrincipal.getContent().getBoundsInLocal().getHeight();
                double viewportHeight = scrollPrincipal.getViewportBounds().getHeight();
                double scrollableHeight = contentHeight - viewportHeight;

                if (scrollableHeight > 0) {
                    double vvalue = scrollPrincipal.getVvalue();

                    // Multiplicador agresivo para forzar velocidad fluida
                    double pixelesPorGiro = 100.0;
                    double desplazamiento = (deltaY > 0 ? 1 : -1) * (pixelesPorGiro / scrollableHeight);

                    double nuevoVvalue = vvalue - desplazamiento;
                    scrollPrincipal.setVvalue(Math.max(0.0, Math.min(1.0, nuevoVvalue)));
                }

                // Consumimos el evento para que el comportamiento lento por defecto no haga nada
                event.consume();

                // 2. Calcular tiempo de procesamiento
                long tiempoFin = System.nanoTime();
                double tiempoTotalMilisegundos = (tiempoFin - tiempoInicio) / 1_000_000.0;

            });
        } else {
            System.out.println("⚠️ ALERTA: 'scrollPrincipal' es NULL. Revisa si pusiste fx:id=\"scrollPrincipal\" en el FXML.");
        }
    }
}

