package presentacion.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("presentacion/fxml/Home"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

   private static Parent loadFXML(String fxml) throws IOException {
          System.out.println("Ruta +" + fxml);
    // Buscamos el recurso usando el ClassLoader del hilo actual para saltar restricciones del módulo
    java.net.URL url = Thread.currentThread().getContextClassLoader().getResource(fxml + ".fxml");
  
    
    if (url == null) {
        throw new IOException("No se encontró el archivo FXML. Revisa que esté en src/main/resources/" + fxml + ".fxml");
    }
    
    FXMLLoader fxmlLoader = new FXMLLoader(url);
    return fxmlLoader.load();
}

    public static void main(String[] args) {
        launch();
    }

}