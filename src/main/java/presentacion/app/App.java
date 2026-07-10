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
    public void start(Stage stage) throws Exception {
        // Cargar tu FXML principal (Home.fxml)
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/presentacion/fxml/Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720); // <-- Ponle un tamaño base intermedio óptimo aquí

        stage.setTitle("Sistema de Gestión de Granja");
        stage.setScene(scene);

        // OPCIONAL: Si quieres que abra maximizado directamente de forma nativa y fluida:
        stage.setMaximized(true);

        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        String rutaCorregida = fxml.startsWith("/") ? fxml : "/" + fxml;
        rutaCorregida = rutaCorregida + ".fxml";

        System.out.println("Intentando cargar desde el Módulo: " + rutaCorregida);

        java.net.URL url = App.class.getResource(rutaCorregida);

        if (url == null) {
            throw new IOException("El sistema de módulos bloqueó el recurso o no existe en target: " + rutaCorregida);
        }

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

        launch();
    }

}