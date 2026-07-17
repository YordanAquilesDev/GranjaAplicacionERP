package presentacion.controller;

import aplication.service.ClienteService;
import aplication.service.ProductoService;
import aplication.service.VentaService;
import domain.model.Cliente;
import domain.model.DetalleVenta;
import domain.model.Producto;
import domain.model.Venta;
import domain.service.JlaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class VentaController {
    
   /**
    * -------------------------------------------------
    * DECLARACION DE VARIABLES
    * -------------------------------------------------
    */
    private final JlaService<Cliente,Integer> clienteService;
    private final JlaService<Producto,Integer>  productoService;
    private final JlaService<Venta,Integer> ventaService;

    @FXML
    private ComboBox<Producto> cmbProducto= new ComboBox<>();

    @FXML
    private ComboBox<Cliente> cmbCliente= new ComboBox<>();



    private Label txtPrecioUnitario;

    @FXML
    private TableView<DetalleVenta> tblDetalleVenta;

    @FXML
    private Button btnAgregarItem;
    @FXML
    private DatePicker dpFecha;

    /**
     * -----------------------------------------------
     * CONSTRUCTORES    
     * ----------------------------------------------
     */
    
    public VentaController(){
        this.clienteService= new ClienteService();
        this.productoService= new ProductoService();
        this.ventaService= new VentaService();
    }

    /**
     * -----------------------------------------------
     * Metodos de la clase
     * ----------------------------------------------
     */
    @FXML
    private void handleLimpiarTodo(ActionEvent event) {
        

    }

    @FXML
    private void handleGuardarVenta(ActionEvent event) {
        double total = detalleVenta.stream().mapToDouble(DetalleVenta::getSubtotal).sum();
        venta.setTotal(total);

        // 1. Crear la alerta de confirmación básica
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar Venta");
        alert.setHeaderText("¿Está seguro de registrar esta venta?");

        // Quitar el texto por defecto ya que pondremos nuestro propio diseño personalizado
        alert.setContentText(null);

        // --- DISEÑO INTERACTIVO DE LA BOLETA VIA CÓDIGO ---

        // Contenedor principal de la boleta
        VBox contenedorBoleta = new VBox(10); // 10px de separación entre elementos
        contenedorBoleta.setStyle("-fx-padding: 15; -fx-background-color: #f9f9f9; -fx-border-color: #cccccc; -fx-border-radius: 5; -fx-background-radius: 5;");

        // Datos del Cliente
        Label lblCliente = new Label("Cliente: " + venta.getCliente().getNombre());
        lblCliente.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #333333;");

        // Creación de una Tabla real e interactiva para los productos
        TableView<DetalleVenta> tablaDetalle = new TableView<>();
        tablaDetalle.setPrefHeight(180); // Altura fija para que no ocupe toda la pantalla
        tablaDetalle.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Auto-ajustar columnas

        // Columna Producto
        TableColumn<DetalleVenta, String> colProducto = new TableColumn<>("Producto");
        colProducto.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getProducto().getNombre())
        );

        // Columna Cantidad
        TableColumn<DetalleVenta, Integer> colCantidad = new TableColumn<>("Cantidad");
        colCantidad.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("cantidad"));
        colCantidad.setStyle("-fx-alignment: CENTER;");

        // Columna Subtotal
        TableColumn<DetalleVenta, Double> colSubtotal = new TableColumn<>("Subtotal");
        colSubtotal.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("subtotal"));
        colSubtotal.setStyle("-fx-alignment: CENTER-RIGHT;");

        // Agregar columnas a la tabla y cargar los datos directamente de tu lista observable
        tablaDetalle.getColumns().addAll(colProducto, colCantidad, colSubtotal);
        tablaDetalle.getItems().addAll(detalleVenta);

        // Total de la venta destacado
        Label lblTotal = new Label(String.format("Total a pagar: S/. %.2f", total));
        lblTotal.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #27ae60; -fx-padding: 5 0 0 0;");

        // Alinear el total a la derecha metiéndolo en un HBox
        HBox contenedorTotal = new HBox(lblTotal);
        contenedorTotal.setStyle("-fx-alignment: CENTER-RIGHT;");

        // Añadir todos los componentes interactivos al contenedor principal
        contenedorBoleta.getChildren().addAll(lblCliente, tablaDetalle, contenedorTotal);

        // 2. Insertar el contenedor con diseño moderno dentro del Alert
        alert.getDialogPane().setContent(contenedorBoleta);

        // --- FIN DEL DISEÑO ---

        // 3. Mostrar la alerta y capturar la respuesta del usuario
        java.util.Optional<ButtonType> resultadoBoton = alert.showAndWait();

        if (resultadoBoton.isPresent() && resultadoBoton.get() == ButtonType.OK) {
           // int resultado = ventaService.save(venta);

            if (true) {
                Alert exito = new Alert(Alert.AlertType.INFORMATION);
                exito.setTitle("Éxito");
                exito.setHeaderText(null);
                exito.setContentText("La venta se ha registrado correctamente.");
                exito.showAndWait();

                // Aquí puedes limpiar tu tabla principal si es necesario
            } else {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setContentText("No se pudo guardar la venta en el sistema.");
                error.showAndWait();
            }
        } else {
            System.out.println("Operación cancelada por el usuario.");
        }
    }

    @FXML
    private void handleRemoverItem(ActionEvent event) {

    }
    // declaracion de variable global
    public Venta venta;
    List<DetalleVenta> detalleVenta= new ArrayList<>();
    @FXML
    private TextField txtCantidad;
    @FXML
    private TableColumn<DetalleVenta, Producto> colProducto;
    @FXML
    private TableColumn<DetalleVenta, Integer> colCantidad;
    @FXML
    private TableColumn<DetalleVenta, Double> colPrecio;
    @FXML
    private TableColumn<DetalleVenta, Double> colSubtotal;

    @FXML
    private void handleAgregarItem(ActionEvent event) {
        Cliente cliente= cmbCliente.getValue();
        Date fecha= Date.valueOf(dpFecha.getValue());

         venta= new Venta(0,cliente,fecha,0.0);


        int cantidad= Integer.parseInt(txtCantidad.getText());
        Producto producto= cmbProducto.getValue();
        double subTotal= cantidad*producto.getPrecio();
        DetalleVenta detalle= new DetalleVenta(0,venta,producto,cantidad,subTotal);
        detalleVenta.add(detalle);
        agregarItemTabla(detalle);
        venta.addDetalleVenta(detalle);


    }

    void agregarItemTabla(DetalleVenta detalle){
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("idLote"));
        colProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colSubtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        ObservableList<DetalleVenta> datos =  FXCollections.observableArrayList(detalle);
        tblDetalleVenta.getItems().add(detalle);

    }
    @FXML
    private void handleSeleccionarFila(MouseEvent  event){
       DetalleVenta detalle= tblDetalleVenta.getSelectionModel().getSelectedItem();
       ObservableList<Producto> producto= FXCollections.observableArrayList(detalle.getProducto());
       ObservableList<Cliente> clientes=FXCollections.observableArrayList(clienteService.findAll());
      cmbProducto.getSelectionModel().select(detalle.getProducto());
      txtCantidad.setText(String.valueOf(detalle.getCantidad()));
      txtPrecioUnitario.setText(String.valueOf(detalle.getProducto().getPrecio()));
      
    }
    
    @FXML
    public void initialize(){
       llenarCombo();
    }

    public void llenarCombo(){
        List<Producto> listaProducto= productoService.findAll();
        List<Cliente> listaCliente= clienteService.findAll();
        ObservableList<Producto> productos= FXCollections.observableArrayList(listaProducto);
        ObservableList<Cliente> clientes=FXCollections.observableArrayList(listaCliente);
        cmbCliente.setItems(clientes);
        cmbProducto.setItems(productos);
    }

}
