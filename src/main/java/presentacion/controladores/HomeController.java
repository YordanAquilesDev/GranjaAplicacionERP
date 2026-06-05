package presentacion.controladores;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Pos;

public class HomeController {

    // Capturamos el contenedor central del FXML
    @FXML private AnchorPane contentArea;

    // Capturamos los botones para saber cuál fue presionado
    @FXML private Button btnDashboard;
    @FXML private Button btnAnimales;
    @FXML private Button btnLotes;
    @FXML private Button btnVentas;

    @FXML
    public void initialize() {
        // Aquí se ejecuta lógica al arrancar la vista (ej. cargar datos iniciales o estilos por defecto)
        System.out.println("Cascarón de la Granja cargado exitosamente.");
    }

    @FXML
    private void handleNavegacion(ActionEvent event) {
        Button botonPresionado = (Button) event.getSource();

        // Limpiamos el área central para meter el nuevo "DOM"
        contentArea.getChildren().clear();

        // Creamos una vista temporal simulada (Cascarón MVP) en lugar de cargar archivos .fxml externos inexistentes aún
        VBox vistaSimulada = new VBox();
        vistaSimulada.setAlignment(Pos.CENTER);
        vistaSimulada.setSpacing(15.0);

        // Estiramos la vista simulada para que llene todo el contentArea
        AnchorPane.setTopAnchor(vistaSimulada, 0.0);
        AnchorPane.setBottomAnchor(vistaSimulada, 0.0);
        AnchorPane.setLeftAnchor(vistaSimulada, 0.0);
        AnchorPane.setRightAnchor(vistaSimulada, 0.0);

        Label tituloSeccion = new Label();
        tituloSeccion.setFont(new Font("System Bold", 22));

        Label descripcionSeccion = new Label("Cargando servicios de la capa de aplicación...");
        descripcionSeccion.setStyle("-fx-text-fill: #888888;");

        // Evaluamos cuál botón se clickeó y mutamos el contenido dinámicamente
        if (botonPresionado == btnDashboard) {
            tituloSeccion.setText("📊 Panel Estadístico (Dashboard)");
            descripcionSeccion.setText("Aquí se incrustará el GridPane con los gráficos analíticos.");
        } else if (botonPresionado == btnAnimales) {
            tituloSeccion.setText("🐖 Módulo de Animales");
            descripcionSeccion.setText("Interfaz para registrar, listar y controlar pesajes/vacunas.");
        } else if (botonPresionado == btnLotes) {
            tituloSeccion.setText("📦 Módulo de Lotes");
            descripcionSeccion.setText("Control y trazabilidad de los lotes de producción de la granja.");
        } else if (botonPresionado == btnVentas) {
            tituloSeccion.setText("💰 Módulo de Ventas");
            descripcionSeccion.setText("Registro de facturas, pedidos de clientes y flujos de caja.");
        }

        // Metemos los componentes generados al vuelo en nuestro contenedor estático central
        vistaSimulada.getChildren().addAll(tituloSeccion, descripcionSeccion);
        contentArea.getChildren().add(vistaSimulada);
    }
}