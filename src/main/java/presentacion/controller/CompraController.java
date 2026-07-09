package presentacion.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CompraController {


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
        txtIdCompra.setText("");
        cmbProveedor
        dpFecha
        cmbProducto
        txtCantidad.setText("");
        txtCostoUnitario.setText("");

    }

    @FXML
    private void handleAgregarItem(ActionEvent event) {

    }
}
