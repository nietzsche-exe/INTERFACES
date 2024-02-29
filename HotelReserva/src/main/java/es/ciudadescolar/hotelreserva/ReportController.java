package es.ciudadescolar.hotelreserva;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignSortField;
import net.sf.jasperreports.engine.type.SortFieldTypeEnum;
import net.sf.jasperreports.engine.type.SortOrderEnum;
import net.sf.jasperreports.engine.util.JRLoader;
import win.zqxu.jrviewer.JRViewerFX;

import javafx.stage.FileChooser;


import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Clase controladora para la generación de informes del hotel.
 * @version 1.0
 * @since 2023-2024
 * @author Jose Julian Saavedra
 */
public class ReportController {
    @FXML
    private Label info;

    @FXML
    private StackPane reportPanel;

    @FXML
    private SwingNode helpButtonNode;
    private JButton helpButton;

    /**
     * Método para inicializar la aplicación.
     */
    public ReportController() {
        initJavaHelpConfig();
    }

    /**
     * Método para generar el informe del hotel.
     * @return El informe generado.
     */
    private JasperPrint generateReport() {

        Reserva reserva1 = new Reserva(7, "Carlos", "Velasco", 2);
        Reserva reserva2 = new Reserva(4, "Alvaro", "Aparicio", 7);
        Reserva reserva3 = new Reserva(6, "Diego", "Hernando", 1);
        Reserva reserva4 = new Reserva(6, "Jon", "Kepa", 9);
        Reserva reserva5 = new Reserva(12, "Pukuchu", "simplemente pukuchu", 14);

        Habitacion habitacion1 = new Habitacion(202, 782.0, reserva1);
        Habitacion habitacion2 = new Habitacion(102, 1800.0, reserva2);
        Habitacion habitacion3 = new Habitacion(303, 215.00, reserva3);
        Habitacion habitacion4 = new Habitacion(401, 2000.50, reserva4);
        Habitacion habitacion5 = new Habitacion(103, 1200.00, reserva5);

        HashSet<Habitacion> habitaciones = new HashSet<>();
        habitaciones.add(habitacion1);
        habitaciones.add(habitacion2);
        habitaciones.add(habitacion3);
        habitaciones.add(habitacion4);
        habitaciones.add(habitacion5);
        JasperPrint print=null;

        try {
            File fichero = new File("./informes/informe_hotel_JoseJulianSaavedra.jasper");
            JasperReport informe = (JasperReport) JRLoader.loadObject(fichero);

            JRBeanCollectionDataSource coleccion = new JRBeanCollectionDataSource(habitaciones);

            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put("RUTA_IMAGEN", "./informes/logo.jpeg");

            JRDesignSortField sortField=new JRDesignSortField();
            sortField.setName("id_habitacion");
            sortField.setOrder(SortOrderEnum.ASCENDING);
            sortField.setType(SortFieldTypeEnum.FIELD);

            List<JRSortField> sortList= new ArrayList<>();
            sortList.add(sortField);
            parametros.put(JRParameter.SORT_FIELDS,sortList);


            print= JasperFillManager.fillReport(informe, parametros, coleccion);

        } catch (JRException e) {
            throw new RuntimeException(e);
        }
        return print;
    }

    /**
     * Método para manejar el evento de clic en el botón "Mostrar".
     */
    @FXML
    public void onShowButtonClick() {
        JasperPrint print = generateReport();

        JRViewerFX visorFX = new JRViewerFX(print);

        reportPanel.getChildren().add(visorFX);

        info.setText("¡reporte generado correctamente!");
    }

    /**
     * Método para manejar el evento de clic en el botón "Imprimir".
     */
    @FXML
    public void onPrintButtonClick() {
        JasperPrint print = generateReport();

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try {
                OutputStream output = new FileOutputStream(file);
                //Exportar fichero
                JasperExportManager.exportReportToPdfStream(print, output);
                output.close();
                info.setText("Fichero PDF generado correctamente en: " + file.getAbsolutePath());
            } catch (Exception e) {
                info.setText("Error al generar PDF");
                throw new RuntimeException(e);
            }
        } else {
            info.setText("No se encontro ruta de guardado");
        }
    }

    /**
     * Método para manejar el evento de clic en el botón "Ayuda".
     */
    private void initJavaHelpConfig() {
        File fichero = new File("./help/help_set.hs");
        HelpSet helpSet;
        try {
            helpSet = new HelpSet(getClass().getClassLoader(), fichero.toURI().toURL());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ImageIcon buttonIcon = new ImageIcon("./informes/help.ico");
                helpButtonNode = new SwingNode();
                helpButton = new JButton("<html><center><b>HELP! </b>", buttonIcon);
                helpButton.setBounds(0, 0, 150, 50);
                helpButtonNode.setContent(helpButton);

                HelpBroker hb = helpSet.createHelpBroker();
                hb.enableHelpOnButton(helpButton, "aplicacion", helpSet);

                Timeline timeline =
                        new Timeline(
                                new KeyFrame(
                                        Duration.seconds(0.2),
                                        ae -> {
                                            helpButtonNode.getContent().repaint();
                                        }));
                timeline.playFromStart();
            }
        });
    }

}