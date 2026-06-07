module com.mackas.granja {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; // Si usas PostgreSQL
    
    // 1. AGREGA ESTAS LÍNEAS CON TU NUEVO PAQUETE:
    exports presentacion.app; 
    opens presentacion.fxml to javafx.fxml;
    opens presentacion.app to javafx.fxml, javafx.graphics;
    
    // Si tus controladores están en otro paquete, asegúrate de abrirlos también para que cargue el FXML:
    exports presentacion.controladores;
    opens presentacion.controladores to javafx.fxml;

    // 🌟 ¡ESTA ES LA LÍNEA QUE TE FALTA! 🌟
    // Le da permiso al motor de tablas de JavaFX de leer las propiedades de tu clase Animal
    opens dominio.modelos to javafx.base;
    // Abre tu carpeta css al motor de gráficos de JavaFX
    opens presentacion.css to javafx.graphics;
}