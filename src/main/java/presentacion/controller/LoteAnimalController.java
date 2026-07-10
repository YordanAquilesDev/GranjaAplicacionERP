package presentacion.controller;

import dominio.modelos.Animal;
import dominio.modelos.LoteAnimal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.Date;
import java.util.List;

public class LoteAnimalController {
    @FXML
    private TableView<LoteAnimal> tblLotes;
    @FXML
    private TableColumn<LoteAnimal, Integer> colIdLote;
    @FXML
    private TableColumn<LoteAnimal, Animal> colAnimal;
    @FXML
    private TableColumn<LoteAnimal, Date> colFechaInicio;
    @FXML
    private TableColumn<LoteAnimal, Integer> colCantInicio;
    @FXML
    private TableColumn<LoteAnimal, Integer> colCantActual;
    @FXML
    private TableColumn<LoteAnimal, Double> colPesoPromedio;
    @FXML
    private TableColumn<LoteAnimal, String > colEstadoLote;

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
        LoteAnimal  loteAnimal= tblLotes.getSelectionModel().getSelectedItem();
        if (loteAnimal != null) {
            txtIdLote.setText(String.valueOf(loteAnimal.getIdLote()));
            txtCantidadInicio.setText(String.valueOf(loteAnimal.getCantidadInicio()));
            txtCantidadActual.setText(String.valueOf(loteAnimal.getCantidadActual()));
            txtPesoPromedio.setText(String.valueOf(loteAnimal.getPesoPromedio()));
            cmbAnimal.getSelectionModel().select(loteAnimal.getAnimal());
        }

    }

    private void llenarTabla() {
        colIdLote.setCellValueFactory(new PropertyValueFactory<>("idLote"));
        colAnimal.setCellValueFactory(new PropertyValueFactory<>("animal"));
        colFechaInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        colCantInicio.setCellValueFactory(new PropertyValueFactory<>("cantidadInicio"));
        colCantActual.setCellValueFactory(new PropertyValueFactory<>("cantidadActual"));
        colPesoPromedio.setCellValueFactory(new  PropertyValueFactory<>("pesoPromedio"));
        colEstadoLote.setCellValueFactory(new PropertyValueFactory<>("estadoLote"));
        ObservableList<LoteAnimal> datos =  FXCollections.observableArrayList(lista);
        tblLotes.setItems(datos);


    }
    @FXML
    private  void initialize() {
        llenarTabla();
        llenarCombo();

    }
    private List<LoteAnimal> lista= List.of(
            new LoteAnimal(1,new Animal(),new Date(20,10,12),100,80,1.4,"actiivo"),
            new LoteAnimal(2,new Animal(),new Date(20,10,12),100,80,1.4,"actiivo"),
            new LoteAnimal(3,new Animal(),new Date(20,10,12),100,80,1.4,"actiivo")

    );
    @FXML
    private TextField txtIdLote;
    @FXML
    private ComboBox<Animal> cmbAnimal;
    @FXML
    private DatePicker dpFechaInicio;
    @FXML
    private TextField txtCantidadInicio;
    @FXML
    private TextField txtCantidadActual;
    @FXML
    private TextField txtPesoPromedio;
    @FXML
    private ComboBox<String> cmbEstadoLote;

    private  void llenarCombo() {
        List<Animal> listaAnimal= List.of(
                new Animal(),
                new Animal()
        );
        ObservableList<Animal> datos =  FXCollections.observableArrayList(listaAnimal);
        cmbAnimal.setItems(datos);
    }
}
