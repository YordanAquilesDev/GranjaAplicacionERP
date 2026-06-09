package presentacion.controller;


import aplicacion.serviceimpl.CompraServiceImpl;
import aplicacion.serviceimpl.VentaServiceImpl;
import dominio.servicio.CompraService;
import dominio.servicio.VentaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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
    @FXML private Button btnMovim;
    @FXML private Button btnAnimales;
    @FXML private Button btnLote;
    @FXML private Button btnVenta;
    @FXML private Button btnHome;
    @FXML private Button btnPedidos;
    @FXML private Button btnGranja;
    @FXML  private Button btnCompra;
    @FXML private  Button btnClientes;
    @FXML private  Button btnProveedor;
    @FXML private  Button btnCarga;
    @FXML private  Button btnStock;
    @FXML private  Button btnSalir;





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
    }// Mapa para asociar cada botón con la ruta de su vista FXML
    private final Map<Button, String> mapasNavegacion = new HashMap<>();

    @FXML
    public void initialize() {
        // Inicializamos el mapa de navegación relacionando Botón -> Ruta FXML
        mapasNavegacion.put(btnHome, "/presentacion/fxml/Dashboar.fxml");
        mapasNavegacion.put(btnPedidos, "/presentacion/fxml/Pedidos.fxml");
        mapasNavegacion.put(btnLote, "/presentacion/fxml/ConsumoLote.fxml");
        mapasNavegacion.put(btnGranja, "/presentacion/fxml/Granja.fxml");
        mapasNavegacion.put(btnMovim, "/presentacion/fxml/MovimientosGranja.fxml");
        mapasNavegacion.put(btnCompra, "/presentacion/fxml/Compra.fxml");
        mapasNavegacion.put(btnAnimales, "/presentacion/fxml/Animal.fxml");
        mapasNavegacion.put(btnVenta, "/presentacion/fxml/Venta.fxml");
        mapasNavegacion.put(btnClientes, "/presentacion/fxml/Cliente.fxml");
        mapasNavegacion.put(btnProveedor, "/presentacion/fxml/Proveedor.fxml");
        mapasNavegacion.put(btnCarga, "/presentacion/fxml/CargaDatos.fxml");
        mapasNavegacion.put(btnStock, "/presentacion/fxml/Stock.fxml");
    }

    /**
     * Método centralizado para gestionar el cambio de pantallas y actualización de estilos CSS.
     */
    private void gestionarNavegacion(Button botonPresionado) {
        // 1. Cambiar dinámicamente las clases CSS
        mapasNavegacion.keySet().forEach(btn -> {
            btn.getStyleClass().removeAll("menu-button", "menu-button-active");
            if (btn == botonPresionado) {
                btn.getStyleClass().add("menu-button-active");
            } else {
                btn.getStyleClass().add("menu-button");
            }
        });

        // 2. Cambiar de pantalla usando la ruta del mapa
        String rutaFxml = mapasNavegacion.get(botonPresionado);
        if (rutaFxml != null) {
            System.out.println("Navegando hacia: " + rutaFxml);
            cambiarPantalla(rutaFxml);
        }
    }

    // ==========================================================================
    // ACCIONES DE NAVEGACION (Ahora son de una sola línea)
    // ==========================================================================

    @FXML
    private void navegarHome(ActionEvent event) {
        gestionarNavegacion(btnHome);
    }

    @FXML
    private void navegarPedidos(ActionEvent event) {
        gestionarNavegacion(btnPedidos);
    }

    @FXML
    private void navegarLotes(ActionEvent event) {
        gestionarNavegacion(btnLote);
    }

    @FXML
    private void navegarGranja(ActionEvent event) {
        gestionarNavegacion(btnGranja);
    }

    @FXML
    private void navegarMovimientos(ActionEvent event) {
        gestionarNavegacion(btnMovim);
    }

    @FXML
    private void navegarCompras(ActionEvent event) {
        gestionarNavegacion(btnCompra);
    }

    @FXML
    private void navegarAnimales(ActionEvent event) {
        gestionarNavegacion(btnAnimales);
    }

    @FXML
    private void navegarVentas(ActionEvent event) {
        gestionarNavegacion(btnVenta);
    }

    @FXML
    private void navegarClientes(ActionEvent event) {
        gestionarNavegacion(btnClientes);
    }

    @FXML
    private void navegarProveedores(ActionEvent event) {
        gestionarNavegacion(btnProveedor);
    }

    @FXML
    private void navegarCargaDatos(ActionEvent event) {
        gestionarNavegacion(btnCarga);
    }

    @FXML
    private void navegarStock(ActionEvent event) {
        gestionarNavegacion(btnStock);
    }

    @FXML
    private void Salir(ActionEvent event) {
        System.out.println("Saliendo del programa...");
        System.exit(0);
    }



}