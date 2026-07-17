package presentacion.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HomeController {

    @FXML private Button btnMovim;
    @FXML private Button btnAnimales;
    @FXML private Button btnLote;
    @FXML private Button btnVenta;
    @FXML private Button btnHome;
    @FXML private Button btnPedidos;
    @FXML private Button btnGranja;
    @FXML private Button btnCompra;
    @FXML private Button btnClientes;
    @FXML private Button btnProveedor;
    @FXML private Button btnCarga;
    @FXML private Button btnStock;
    @FXML private Button btnConsumo;
    @FXML private Button btnSalir;

    @FXML private StackPane contenedorPrincipal;

    private final Map<Button, String> mapasNavegacion = new HashMap<>();

    @FXML
    public void initialize() {
        // Inicialización de rutas
        mapasNavegacion.put(btnHome, "/presentacion/fxml/Dashboar.fxml");
        mapasNavegacion.put(btnPedidos, "/presentacion/fxml/Pedidos.fxml");
        mapasNavegacion.put(btnLote, "/presentacion/fxml/LoteAnimal.fxml");
        mapasNavegacion.put(btnGranja, "/presentacion/fxml/Granja.fxml");
        mapasNavegacion.put(btnMovim, "/presentacion/fxml/MovimientosGranja.fxml");
        mapasNavegacion.put(btnCompra, "/presentacion/fxml/Compra.fxml");
        mapasNavegacion.put(btnAnimales, "/presentacion/fxml/Animal.fxml");
        mapasNavegacion.put(btnVenta, "/presentacion/fxml/prueva.fxml");
        mapasNavegacion.put(btnClientes, "/presentacion/fxml/Cliente.fxml");
        mapasNavegacion.put(btnProveedor, "/presentacion/fxml/Proveedor.fxml");
        mapasNavegacion.put(btnCarga, "/presentacion/fxml/CargaDatos.fxml");
        mapasNavegacion.put(btnStock, "/presentacion/fxml/Stock.fxml");
        mapasNavegacion.put(btnConsumo, "/presentacion/fxml/ConsumoLote.fxml");

        // Fuerza a que la aplicación inicie mostrando el Dashboard por defecto
        navegarHome();
    }

    public void cambiarPantalla(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent nodoHijo = loader.load();
            

            // === VÍNCULO CRÍTICO ENTRE CONTROLADORES ===
            // Obtenemos el controlador de la vista que se acaba de cargar en memoria
            Object controladorHijo = loader.getController();

            // Si la vista que cargamos es la del Dashboard, le pasamos este HomeController
            if (controladorHijo instanceof DashboardController) {
                ((DashboardController) controladorHijo).setMainController(this);
            }
            // ===========================================

            // Limpiar e inyectar el nodo en la interfaz
            contenedorPrincipal.getChildren().clear();
            contenedorPrincipal.getChildren().add(nodoHijo);

            // TRUCO DE FLUIDEZ: Forzar a que el contenido hijo se acople sin recalcular tamaños raros
            if (nodoHijo instanceof ScrollPane) {
                ((ScrollPane) nodoHijo).setFitToWidth(true);
            }

        } catch (IOException e) {
            System.out.println("Error al cargar la pantalla dinámicamente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void gestionarNavegacion(Button botonPresionado) {
        if (botonPresionado == null) return;

        mapasNavegacion.keySet().forEach(btn -> {
            if (btn != null) {
                btn.getStyleClass().removeAll("menu-button", "menu-button-active");
                if (btn == botonPresionado) {
                    btn.getStyleClass().add("menu-button-active");
                } else {
                    btn.getStyleClass().add("menu-button");
                }
            }
        });

        String rutaFxml = mapasNavegacion.get(botonPresionado);
        System.out.println("rutaFxml: " + rutaFxml);
        if (rutaFxml != null) {
            cambiarPantalla(rutaFxml);
        }
    }

    // Métodos públicos para cambiar de pantalla (invocables desde el menú lateral o desde controladores externos)
    @FXML public void navegarHome() { gestionarNavegacion(btnHome); }
    @FXML public void navegarPedidos() { gestionarNavegacion(btnPedidos); }
    @FXML public void navegarLotes() { gestionarNavegacion(btnLote); }
    @FXML public void navegarGranja() { gestionarNavegacion(btnGranja); }
    @FXML public void navegarMovimientos() { gestionarNavegacion(btnMovim); }
    @FXML public void navegarCompras() { gestionarNavegacion(btnCompra); }
    @FXML public void navegarAnimales() { gestionarNavegacion(btnAnimales); }
    @FXML public void navegarVentas() { gestionarNavegacion(btnVenta); }
    @FXML public void navegarClientes() { gestionarNavegacion(btnClientes); }
    @FXML public void navegarProveedores() { gestionarNavegacion(btnProveedor); }
    @FXML public void navegarCargaDatos() { gestionarNavegacion(btnCarga); }
    @FXML public void navegarStock() { gestionarNavegacion(btnStock); }
    @FXML public void navegarConsumoLote(){ gestionarNavegacion(btnConsumo); }
    @FXML public void Salir() { System.exit(0); }
}