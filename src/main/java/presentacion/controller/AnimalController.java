package presentacion.controller;

import aplication.service.AnimalService;
import domain.model.Animal;
import domain.service.JlaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class AnimalController {
    // Dependencia del Dominio (Service)
    private final JlaService<Animal,Integer> animalService;
    public AnimalController() {
        this.animalService = new AnimalService();
    }

    // Componentes FXML
    @FXML private TextField txtId;
    @FXML private TextField txtEspecie;
    @FXML private TextField txtRaza;
    @FXML private Button btnGuardar;
    @FXML private Button btnLimpiar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;
    
    @FXML private TableView<Animal> tblAnimales;
    @FXML private TableColumn<Animal, Integer> colId;
    @FXML private TableColumn<Animal, String> colEspecie;
    @FXML private TableColumn<Animal, String> colRaza;

    // Dependencia del Dominio (Service)

    
    // Lista observable para la UI
    private ObservableList<Animal> listaAnimales;




    @FXML
    public void initialize() {

        System.out.println("INICIANDO ANIMALES");
        System.out.println("ESTAS EN LA UI ANIMAL.fxml");
        // 1. Configurar cómo se van a llenar las columnas con las propiedades de 'Animal'
        colId.setCellValueFactory(new PropertyValueFactory<>("idAnimal"));
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        colRaza.setCellValueFactory(new PropertyValueFactory<>("raza"));

        // 2. Cargar los datos iniciales en la tabla
        cargarDatosTabla();
    }

    private void cargarDatosTabla() {
        List<Animal> animales = animalService.findAll();
        listaAnimales = FXCollections.observableArrayList(animales);
        tblAnimales.setItems(listaAnimales);
    }

    private Animal animalSeleccionado;

    @FXML
    void handleGuardar() {

        String especie = txtEspecie.getText().trim();
        String raza = txtRaza.getText().trim();

        if (especie.isEmpty() || raza.isEmpty() || animalSeleccionado.getIdAnimal()>0) {
            // Aquí podrías mostrar una alerta de validación básica
            // mostrar mensaje de advertencia error
            return;
        }

        Animal animal;
        if (txtId.getText() == null || txtId.getText().isEmpty()) {
            // Es un registro nuevo
            animal = new Animal(especie, raza);
        } else {
            // Es una actualización (Se mantiene el ID existente)
            int id = Integer.parseInt(txtId.getText());
            animal = new Animal(id, especie, raza);
        }

        // El flujo viaja del controlador -> Service -> Repository
       int resultado= animalService.save(animal);
        if(resultado>=1){
            // mensaje de exito
        }else{
            // mensaje de error
        }
        
        // Refrescar UI y limpiar campos
        cargarDatosTabla();
        handleLimpiar();
    }

    @FXML
    void handleLimpiar() {
        txtId.clear();
        txtEspecie.clear();
        txtRaza.clear();
        tblAnimales.getSelectionModel().clearSelection();
    }

    @FXML
    void handleSeleccionarFila(MouseEvent event) {
        // Al hacer clic en un elemento de la tabla, se cargan los datos en el formulario para editar
     animalSeleccionado = tblAnimales.getSelectionModel().getSelectedItem();
        if (animalSeleccionado != null && animalSeleccionado.getIdAnimal() > 0) {
            txtId.setText(String.valueOf(animalSeleccionado.getIdAnimal()));
            txtEspecie.setText(animalSeleccionado.getEspecie());
            txtRaza.setText(animalSeleccionado.getRaza());
        }
    }

    @FXML
    void handleActualizar(ActionEvent event) {
        if (tblAnimales.getSelectionModel().getSelectedItem() != null) {

        }
    }

    @FXML
    void handleEliminar(ActionEvent event) {
        if (tblAnimales.getSelectionModel().getSelectedItem() != null) {

         int resultado=   animalService.delete(tblAnimales.getSelectionModel().getSelectedItem().getIdAnimal());
            tblAnimales.getSelectionModel().clearSelection();
            System.out.println(resultado);

        }
    }
}
