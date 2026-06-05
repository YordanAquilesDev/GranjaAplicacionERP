package presentacion.controladores;

import dominio.modelos.Animal;
import dominio.servicio.AnimalService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class AnimalController {

    // Componentes FXML
    @FXML private TextField txtId;
    @FXML private TextField txtEspecie;
    @FXML private TextField txtRaza;
    @FXML private Button btnGuardar;
    @FXML private Button btnLimpiar;
    
    @FXML private TableView<Animal> tblAnimales;
    @FXML private TableColumn<Animal, Integer> colId;
    @FXML private TableColumn<Animal, String> colEspecie;
    @FXML private TableColumn<Animal, String> colRaza;

    // Dependencia del Dominio (Service)
    private final AnimalService animalService;
    
    // Lista observable para la UI
    private ObservableList<Animal> listaAnimales;

    // NOTA: Si usas un contenedor de Inyección de Dependencias, maneja esto según tu framework.
    // Para este ejemplo guía, asumimos que se inicializa o se inyecta la implementación.
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }
    
    // Constructor por defecto requerido por JavaFX si no usas Factory de controladores
    public AnimalController() {
        // Aquí deberías vincular tu implementación real del servicio temporalmente si no usas DI.
        this.animalService = null; 
    }

    @FXML
    public void initialize() {
        // 1. Configurar cómo se van a llenar las columnas con las propiedades de 'Animal'
        colId.setCellValueFactory(new PropertyValueFactory<>("idAnimal"));
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        colRaza.setCellValueFactory(new PropertyValueFactory<>("raza"));

        // 2. Cargar los datos iniciales en la tabla
        cargarDatosTabla();
    }

    private void cargarDatosTabla() {
        if (animalService != null) {
            List<Animal> animales = animalService.obtenerTodosLosAnimales();
            listaAnimales = FXCollections.observableArrayList(animales);
            tblAnimales.setItems(listaAnimales);
        }
    }

    @FXML
    void handleGuardar() {
        if (animalService == null) return;

        String especie = txtEspecie.getText().trim();
        String raza = txtRaza.getText().trim();

        if (especie.isEmpty() || raza.isEmpty()) {
            // Aquí podrías mostrar una alerta de validación básica
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
        animalService.guardarAnimal(animal);
        
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
        Animal animalSeleccionado = tblAnimales.getSelectionModel().getSelectedItem();
        
        if (animalSeleccionado != null) {
            txtId.setText(String.valueOf(animalSeleccionado.getIdAnimal()));
            txtEspecie.setText(animalSeleccionado.getEspecie());
            txtRaza.setText(animalSeleccionado.getRaza());
        }
    }
}
