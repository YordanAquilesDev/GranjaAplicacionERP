package presentacion.controller;

import aplicacion.serviceimpl.ClienteService;
import aplicacion.serviceimpl.ProductoServiceImpl;
import aplicacion.serviceimpl.VentaServiceImpl;
import dominio.modelos.Cliente;
import dominio.modelos.DetalleVenta;
import dominio.modelos.Producto;
import dominio.modelos.Venta;
import dominio.servicio.JlaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

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

    private Label txtCantidad;

    private Label txtPrecioUnitario;

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
        this.productoService= new ProductoServiceImpl();
        this.ventaService= new VentaServiceImpl();
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

    double total= detalleVenta.stream().mapToDouble(DetalleVenta::getCantidad).sum();
    venta.setTotal(total);



    }

    @FXML
    private void handleRemoverItem(ActionEvent event) {

    }
    // declaracion de variable global
    public Venta venta;
    List<DetalleVenta> detalleVenta= new ArrayList<>();

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
        tblDetalleVenta.getItems().addAll(detalleVenta);
        venta.addDetalleVenta(detalle);


    }
    @FXML
    private void handleSeleccionarFila(MouseEvent  event){
       DetalleVenta detalle= tblDetalleVenta.getSelectionModel().getSelectedItem();
       ObservableList<Producto> producto= FXCollections.observableArrayList(detalle.getProducto());
       ObservableList<Cliente> clientes=FXCollections.observableArrayList(clienteService.findAll());
      cmbProducto.setItems(producto);
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
