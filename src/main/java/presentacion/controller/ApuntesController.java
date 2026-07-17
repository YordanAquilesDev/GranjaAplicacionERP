/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controller;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import java.io.File;
import javafx.scene.image.WritableImage;

public class ApuntesController {

   @FXML
    private Canvas canvasApuntes;

    private GraphicsContext gc;

    @FXML
    public void initialize() {
        // Inicializamos el contexto de dibujo
        gc = canvasApuntes.getGraphicsContext2D();
        
        // Configuramos el pincel por defecto
        gc.setStroke(Color.BLACK); // Color del trazo
        gc.setLineWidth(3.0);      // Grosor del pincel
    }

    // Detecta cuando apoyas el "pincel" por primera vez
    @FXML
    private void empezarTrazo(MouseEvent event) {
        gc.beginPath();
        gc.moveTo(event.getX(), event.getY());
        gc.stroke();
    }

    // Pinta la línea de manera fluida mientras arrastras el mouse
    @FXML
    private void pincelear(MouseEvent event) {
        gc.lineTo(event.getX(), event.getY());
        gc.stroke();
    }

    // Limpia toda la hoja de papel
    @FXML
    private void limpiarLienzo() {
        gc.clearRect(0, 0, canvasApuntes.getWidth(), canvasApuntes.getHeight());
    }

    // Guarda el dibujo como archivo .PNG
    @FXML
    private void guardarLienzo() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar Hoja de Dibujo");
        fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("Imagen PNG (*.png)", "*.png")
        );

        File file = fileChooser.showSaveDialog(canvasApuntes.getScene().getWindow());

        if (file != null) {
            // Tomar una captura del contenido del Canvas
            WritableImage writableImage = new WritableImage(
                    (int) canvasApuntes.getWidth(), 
                    (int) canvasApuntes.getHeight()
            );
            canvasApuntes.snapshot(null, writableImage);
            
            // Convertir y guardar en el disco duro como PNG
            // ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
            //   System.out.println("¡Dibujo guardado con éxito!");
        }
    }
    
   
    
}