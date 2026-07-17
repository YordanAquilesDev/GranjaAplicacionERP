package presentacion.controller;

import domain.model.Producto;
import domain.model.Proveedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class CompraController {

  /**
    * -------------------------------------------------
    * DECLARACION DE VARIABLES
    * -------------------------------------------------
    */
    private Label txtCantidad;
    private Label txtCostoUnitario;
    private DatePicker dpFecha;
    private ComboBox<Proveedor> cmbProveedor;

    private ComboBox<Producto> cmbProducto;

    
    
@FXML
public Label txtIdCompra;

    @FXML
    private void handleGuardarCompra(ActionEvent event) {

    }

    @FXML
    private void handleLimpiarTodo(ActionEvent event) {

    }

    @FXML
    private void handleRemoverItem(ActionEvent event) {

    }
    @FXML
    private void handleSeleccionarFila(MouseEvent even){
        Proveedor provee= new Proveedor();
        Producto produ= new Producto();
        txtIdCompra.setText("");
        
         ObservableList<Proveedor> proveedor= FXCollections.observableArrayList(provee);
         ObservableList<Producto> producto= FXCollections.observableArrayList(produ);
          
        cmbProveedor.setItems(proveedor);
        //dpFecha.
        cmbProducto.setItems(producto);
        txtCantidad.setText("");
        txtCostoUnitario.setText("");

    }

    @FXML
    private void handleAgregarItem(ActionEvent event) {

    }
}
