package presentacion.controladores;


import aplicacion.serviceimpl.CompraServiceImpl;
import aplicacion.serviceimpl.VentaServiceImpl;
import dominio.modelos.Compra;
import dominio.modelos.Venta;
import dominio.servicio.CompraService;
import dominio.servicio.VentaService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import presentacion.app.App;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import presentacion.util.CreadorGraficoLineChar;
import javafx.scene.chart.NumberAxis;
import java.io.IOException;
import java.util.List;

public class HomeController {
       private final CompraService compraService;
       private final VentaService ventaService;
       public HomeController() {
           this.compraService = new CompraServiceImpl();
           this.ventaService = new VentaServiceImpl();
       }
    // Capturamos el contenedor central del FXML
    @FXML private AnchorPane contentArea;
    // Capturamos los botones para saber cuál fue presionado
    @FXML private Button btnDashboard;
    @FXML private Button btnAnimales;
    @FXML private Button btnLotes;
    @FXML private Button btnVentas;

    @FXML
    private StackPane contenedorPrincipal; // El contenedor intermedio de tu FXML base

    // 🛠️ El método mágico que limpia el contenedor e inyecta el nuevo FXML
    private void cambiarPantalla(String rutaFxml) {
        try {
            // Cargar el archivo FXML dinámicamente
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFxml));
            Parent nuevaVista = loader.load();

            // Limpiamos lo que haya en el contenedor (evita acumular memoria)
            contenedorPrincipal.getChildren().clear();

            // Inyectamos la nueva pantalla
            contenedorPrincipal.getChildren().add(nuevaVista);

        } catch (IOException e) {
            System.err.println("Error al cargar la pantalla dinámicamente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //ACCIONES DE NAVEGACION
    @FXML
    private void navegarAnimales(ActionEvent event) throws IOException {
        System.out.println("PRESIONO EL BOTON DE NAVEGAR A ANIMALES");
        cambiarPantalla("/presentacion/fxml/Animal.fxml");
    }

    @FXML
    private void navegarClientes(ActionEvent event) throws IOException {
        System.out.println(" ");
        cambiarPantalla("/presentacion/fxml/Cliente.fxml");
    }
    @FXML
    private void navegarCompras(ActionEvent event) throws IOException {
        System.out.println(" ");
        cambiarPantalla("/presentacion/fxml/Compra.fxml");

    }
    @FXML
    private void navegarHome(ActionEvent event) throws IOException {
        System.out.println(" ");
        cambiarPantalla("/presentacion/fxml/Home.fxml");
    }
    @FXML
    private void navegarPedidos(ActionEvent event) throws IOException {
        System.out.println(" ");
        cambiarPantalla("/presentacion/fxml/Pedidos.fxml");

    }
    @FXML
    private void navegarLotes(ActionEvent event) throws IOException {
        System.out.println(" ");
        cambiarPantalla("/presentacion/fxml/ConsumoLote.fxml");

    }
    @FXML
    private void navegarGranja(ActionEvent event) throws IOException {
        System.out.println(" ");
        cambiarPantalla("/presentacion/fxml/Granja.fxml");
    }
    @FXML
    private void navegarMovimientos(ActionEvent event) throws IOException {
        System.out.println(" ");
        cambiarPantalla("/presentacion/fxml/MovimientosGranja.fxml");
    }
    @FXML
    private void navegarVentas(ActionEvent event) throws IOException {
        System.out.println(" ");
        cambiarPantalla("/presentacion/fxml/Venta.fxml");
    }
    @FXML
    private void navegarProveedores(ActionEvent event) throws IOException {
        System.out.println(" ");
        cambiarPantalla("/presentacion/fxml/Proveedor.fxml");
    }
    @FXML
    private void navegarCargaDatos(ActionEvent event) throws IOException {
        System.out.println(" ");
        cambiarPantalla("/presentacion/fxml/CargaDatos.fxml");
    }
    @FXML
    private void navegarStock(ActionEvent event) throws IOException {
        System.out.println(" ");
        cambiarPantalla("/presentacion/fxml/Stock.fxml");
    }
    @FXML
    private void Salir(ActionEvent event) throws IOException {
        System.out.println("Saliendo.. del programa");
        System.exit(0);
    }
// FIN DE ACCIONES DE NAVEGACION





    @FXML
    // este es un metodo que se llama segun el boton presionada 
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