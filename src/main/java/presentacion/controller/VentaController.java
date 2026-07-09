package presentacion.controller;

import aplicacion.serviceimpl.ClienteService;
import aplicacion.serviceimpl.ProductoServiceImpl;
import dominio.modelos.Cliente;
import dominio.modelos.DetalleVenta;
import dominio.modelos.Producto;
import dominio.servicio.JlaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class VentaController {
    
   /**
    * -------------------------------------------------
    * DECLARACION DE VARIABLES
    * -------------------------------------------------
    */
    private final JlaService clienteService;
    private final JlaService  productoService;
    private ComboBox<Producto> cmbProducto;
    private Label txtCantidad;
    private Label txtPrecioUnitario;
    private TableView<DetalleVenta> tblDetalleVenta; 
    /**
     * -----------------------------------------------
     * CONSTRUCTORES    
     * ----------------------------------------------
     */
    
    public VentaController(){
        this.clienteService= new ClienteService();
        this.productoService= new ProductoServiceImpl();
    }

    @FXML
    private void handleLimpiarTodo(ActionEvent event) {

    }

    @FXML
    private void handleGuardarVenta(ActionEvent event) {

    }

    @FXML
    private void handleRemoverItem(ActionEvent event) {

    }

    @FXML
    private void handleAgregarItem(ActionEvent event) {

    }
    @FXML
    private void handleSeleccionarFila(MouseEvent  event){
       DetalleVenta detalle= tblDetalleVenta.getSelectionModel().getSelectedItem();
       ObservableList<Producto> producto= FXCollections.observableArrayList(productoService.findAll());
       ObservableList<Cliente> clientes=FXCollections.observableArrayList(clienteService.findAll());
      cmbProducto.setItems(producto);
      txtCantidad.setText(String.valueOf(detalle.getCantidad()));
      txtPrecioUnitario.setText(String.valueOf(detalle.getProducto().getPrecio()));
      
    }
}
