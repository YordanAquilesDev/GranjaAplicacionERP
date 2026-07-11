package presentacion.controller;

import aplicacion.serviceimpl.AnimalServiceImpl;
import aplicacion.serviceimpl.LoteAnimalServiceImpl;
import dominio.modelos.Animal;
import dominio.modelos.LoteAnimal;
import dominio.servicio.JlaService;
import javafx.fxml.FXML;

import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent; // <

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import org.jfree.data.Value;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController {

    // Instancia del controlador principal (el que maneja el menú lateral y el contenedor)
    private HomeController mainController;
    private JlaService<Animal,Integer> animalService;
    private JlaService<LoteAnimal,Integer> loteAnimalService;

    // Método setter para inyectar el controlador principal
    public void setMainController(HomeController mainController) {
        this.mainController = mainController;
    }

    /**
     * -----------------------------------------
     * CONSTRUCTORES
     * -----------------------------------------
     */
    public DashboardController() {
        this.animalService=new AnimalServiceImpl();
        this.loteAnimalService= new LoteAnimalServiceImpl();

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
    private void navegarConsumoLote() {
        if (mainController != null) mainController.navegarConsumoLote();
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
    private Label txtTotalAnimales;

    @FXML
    private Label txtTotalLotes;
    // Cambia el <?> por <LoteAnimal>
    @FXML
    private TableView<LoteAnimal> tblLotesPróximos;

    // Declara las columnas vinculándolas a la clase LoteAnimal y el tipo de dato que mostrarán
    @FXML
    private TableColumn<LoteAnimal, Integer> colProgresoLote; // Si el ID es entero
    @FXML
    private TableColumn<LoteAnimal, String> colProgresoTipo;
    @FXML
    private TableColumn<LoteAnimal, Integer> colProgresoDias;
    @FXML
    private TableColumn<LoteAnimal, String> colProgresoFecha; // Puedes usar String o Date
    @FXML
    private TableColumn<LoteAnimal, String> colProgresoEstado;

    public void provar() {
        // 1. Decirle a cada columna qué variable/atributo de "LoteAnimal" debe leer
        // Nota: Reemplaza las palabras entre comillas por los nombres EXACTOS de tus variables en LoteAnimal
        colProgresoLote.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("idLote"));

        // Si quieres mostrar la especie que está dentro del objeto Animal, puedes pasarle un String limpio
        // o mapearlo. Por ahora asumamos que lee variables directas de tu clase LoteAnimal:
        colProgresoTipo.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("estadoLote"));
        colProgresoDias.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("cantidadInicio"));
        colProgresoFecha.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("estadoLote"));
        colProgresoEstado.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("estadoLote"));

        // 2. Convertir tu lista común a una Lista Observable que JavaFX pueda leer en tiempo real
        javafx.collections.ObservableList<LoteAnimal> datos =
                javafx.collections.FXCollections.observableArrayList(loteAnimalService.findAll());

        // 3. ¡INYECTAR LOS DATOS EN LA TABLA! Sin necesidad de un forEach
        tblLotesPróximos.setItems(datos);
    }


    @FXML
    private TableColumn<LoteAnimal, Integer> colLoteNombre;
    @FXML
    private TableColumn<LoteAnimal, Integer> colLotePoblacion;
    @FXML
    private TableColumn<LoteAnimal, Integer> colLoteBajas;
    @FXML
    private TableColumn<LoteAnimal, Double> colLoteMortalidad;
    @FXML
    private TableColumn<LoteAnimal, Double> colLoteConsumo;
    @FXML
    private TableColumn<LoteAnimal, String> colLoteSanidad;
    @FXML
    private Label txtTasaMortalidad;


    @FXML
    public void initialize() {
        provar();
        rellenarDatos();
        if (chartBalance != null) {
            chartBalance.setAnimated(false);
        }

        if (scrollPrincipal != null) {

            scrollPrincipal.addEventFilter(ScrollEvent.SCROLL, event -> {

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

    public void rellenarDatos(){
       int totalAnimales= animalService.findAll().size();
       int totalLotes= loteAnimalService.findAll().size();
       int cantidadInicial= loteAnimalService.findAll().stream().mapToInt(LoteAnimal::getCantidadInicio).sum();
       int cantidadFinal= loteAnimalService.findAll().stream().mapToInt(LoteAnimal::getCantidadActual).sum();
       int diferencia= cantidadInicial - cantidadFinal;
        /**
         * 1000 ------ 100%
         * 100 ------ X
         *  X= 100 x100 / 1000
         * cantidadInicial ------> 100%
         * diferenia ----------- X
         * X=catidadFinal* 100 /cantidadInicial
         */
       double porcentaje=(double)(diferencia*100)/cantidadInicial;
        txtTotalAnimales.setText(String.valueOf(totalAnimales));
        txtTotalLotes.setText(String.valueOf(totalLotes));
        txtTasaMortalidad.setText(String.valueOf(porcentaje));
    }
}

