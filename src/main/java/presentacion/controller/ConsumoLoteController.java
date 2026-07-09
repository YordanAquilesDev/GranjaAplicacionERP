package presentacion.controller;

import aplicacion.serviceimpl.ClienteService;
import aplicacion.serviceimpl.LoteAnimalServiceImpl;
import aplicacion.serviceimpl.ProductoServiceImpl;
import dominio.modelos.LoteAnimal;
import dominio.modelos.Producto;
import dominio.servicio.JlaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

public class ConsumoLoteController {
    /**
    * -------------------------------------------------
    * DECLARACION DE VARIABLES
    * -------------------------------------------------
    */
    private JlaService productoService;
    private JlaService loteService;
    private ComboBox<Producto> cmbProducto;
    private ComboBox<LoteAnimal> cmbLoteAnimal;
    
    /**
    * -------------------------------------------------
    * CONSTRUCTORES 
    * -------------------------------------------------
    */
    public ConsumoLoteController(){
        this.loteService= new LoteAnimalServiceImpl();
        this.productoService= new ProductoServiceImpl();
        
    }
 
    @FXML
    private void handleGuardar(ActionEvent event) {

    }

    @FXML
    private void handleActualizar(ActionEvent event) {

    }

    @FXML
    private void handleEliminar(ActionEvent event) {

    }

    @FXML
    private void handleLimpiar(ActionEvent event) {

    }

    @FXML
    private void handleSeleccionarFila(MouseEvent event) {

    }
    
    public void initialaizer(){
            ObservableList<Producto> productos= FXCollections.observableArrayList(productoService.findAll());
       ObservableList<LoteAnimal> clientes=FXCollections.observableArrayList(loteService.findAll());
        cmbLoteAnimal.setItems(clientes);
        cmbProducto.setItems(productos);
        
    }
}
