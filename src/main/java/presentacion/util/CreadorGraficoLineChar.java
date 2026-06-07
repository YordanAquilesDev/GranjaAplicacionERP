package presentacion.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CreadorGraficoLineChar {

    /**
     * Crea y devuelve un LineChart completamente configurado y listo para añadir a la vista.
     * * @param tituloGrafico El título principal del gráfico.
     * @param etiquetaX Nombre para el eje Horizontal (Categorías/Tiempo).
     * @param etiquetaY Nombre para el eje Vertical (Valores numéricos).
     * @param datos Una lista de series de datos (pueden ser una o varias líneas).
     * @return Un objeto LineChart configurado.
     */
    public static LineChart<String, Number> crearGraficoLineal(

            String tituloGrafico,
            String etiquetaX,
            String etiquetaY,
            ObservableList<XYChart.Series<String, Number>> datos) {
        System.out.println("estamos en el poblar garfico");
        System.out.println("estamos en el poblar garfico");


        // 1. Crear los ejes requeridos por el LineChart de JavaFX
        CategoryAxis ejeX = new CategoryAxis();
        ejeX.setLabel(etiquetaX);

        NumberAxis ejeY = new NumberAxis();
        ejeY.setLabel(etiquetaY);

        // 2. Instanciar el gráfico con sus ejes
        LineChart<String, Number> grafico = new LineChart<>(ejeX, ejeY);
        grafico.setTitle(tituloGrafico);

        // 3. Inyectar los datos si es que se pasaron parámetros válidos
        if (datos != null && !datos.isEmpty()) {
            grafico.setData(datos);
        }

        // 4. Desactivar animaciones si deseas que cargue instantáneamente (opcional)
        grafico.setAnimated(false);

        return grafico;
    }


    public static void poblarGraficoLineal(
            LineChart<String, Number> graficoExistente,
            String titulo,
            ObservableList<XYChart.Series<String, Number>> datos) {

        if (graficoExistente == null) return;

        // 1. Configuramos el título básico
        graficoExistente.setTitle(titulo);

        // 2. Limpiamos datos viejos por si se actualiza la pantalla
        graficoExistente.getData().clear();

        // 3. Inyectamos las nuevas series de datos
        if (datos != null && !datos.isEmpty()) {
            graficoExistente.setData(datos);
        }

        graficoExistente.setAnimated(false);
    }

    /**
     * Puebla un LineChart existente con múltiples líneas/series directamente.
     */

    /**
     * Procesa una lista de cualquier objeto del dominio, agrupa sus montos por fecha y devuelve una Serie lista para graficar.
     * * @param <T>          El tipo de modelo (Ej: Compra, Venta, Gasto)
     * @param nombreSerie  El nombre de la leyenda (Ej: "Ventas Totales")
     * @param listaDatos   La lista que viene de la base de datos
     * @param extractorFecha Función Lambda para obtener la fecha del objeto
     * @param extractorMonto Función Lambda para obtener el total del objeto
     * @return Una serie configurada con los totales agrupados cronológicamente
     */
    public static <T> XYChart.Series<String, Number> mapearListaASerie(
            String nombreSerie,
            List<T> listaDatos,
            Function<T, ?> extractorFecha,
            Function<T, Double> extractorMonto) {

        XYChart.Series<String, Number> serie = new XYChart.Series<>();
        serie.setName(nombreSerie);

        if (listaDatos == null || listaDatos.isEmpty()) {
            return serie;
        }

        // Formato técnico para obligar a TreeMap a ordenar cronológicamente por Año-Mes-Día
        SimpleDateFormat formatoTecnico = new SimpleDateFormat("yyyy-MM-dd");
        // Formato visual para mostrar en el gráfico de forma elegante
        SimpleDateFormat formatoVisual = new SimpleDateFormat("dd-MMM");

        // 1. Agrupamos usando la fecha técnica ("2026-05-19") para asegurar el orden cronológico
        Map<String, Double> datosAgrupados = listaDatos.stream().collect(
                Collectors.groupingBy(
                        objeto -> formatoTecnico.format(extractorFecha.apply(objeto)),
                        TreeMap::new, // Gracias al formato yyyy-MM-dd, esto ordenará el tiempo a la perfección
                        Collectors.summingDouble(objeto -> extractorMonto.apply(objeto))
                )
        );

        // 2. Pasamos al gráfico transformando la llave técnica a la etiqueta bonita
        datosAgrupados.forEach((fechaTecnica, total) -> {
            try {
                Date fechaReal = (Date) formatoTecnico.parse(fechaTecnica);
                String etiquetaBonita = formatoVisual.format(fechaReal);

                serie.getData().add(new XYChart.Data<>(etiquetaBonita, total));
            } catch (Exception e) {
                serie.getData().add(new XYChart.Data<>(fechaTecnica, total));
            }
        });

        return serie;
    }

    /**
     * Método final para renderizar las series en el gráfico (El mismo que tenías antes)
     */
    @SafeVarargs
    public static void graficarMultiplesLineas(
            LineChart<String, Number> graficoExistente,
            String titulo,
            XYChart.Series<String, Number>... series) {
        if (graficoExistente == null) return;
        graficoExistente.setTitle(titulo);
        graficoExistente.getData().clear();
        graficoExistente.setCreateSymbols(false); // Quita los codos/círculos
        if (series != null) {
            graficoExistente.getData().addAll(FXCollections.observableArrayList(series));
        }
        graficoExistente.setAnimated(false);
    }
}