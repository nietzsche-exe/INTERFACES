package informes.hotel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javafx.scene.layout.StackPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignSortField;
import net.sf.jasperreports.engine.type.SortFieldTypeEnum;
import net.sf.jasperreports.engine.type.SortOrderEnum;
import net.sf.jasperreports.engine.util.JRLoader;
import win.zqxu.jrviewer.JRViewerFX;

import javax.swing.*;

public class HotelController {
    @FXML
    private Label welcomeText;
    @FXML
    public StackPane reportPanel;

    @FXML
    private JasperPrint generateReport (){
        Habitacion habitacion1 = new Habitacion(Integer.valueOf(1), 100.50,
                new Reserva(Integer.valueOf(2), "Carlos", "Velasco", Integer.valueOf(8)));
        Habitacion habitacion2 = new Habitacion(Integer.valueOf(2), 70.50,
                new Reserva(Integer.valueOf(1), "Keira", "Defaz", Integer.valueOf(7)));
        Habitacion habitacion3 = new Habitacion(Integer.valueOf(3), 90.50,
                new Reserva(Integer.valueOf(2), "Alvaro", "Aparicio", Integer.valueOf(9)));
        Habitacion habitacion4 = new Habitacion(Integer.valueOf(4), 125.50,
                new Reserva(Integer.valueOf(3), "Jose Julian", "Sabedra", Integer.valueOf(10)));
        Habitacion habitacion5 = new Habitacion(Integer.valueOf(5), 150.50,
                new Reserva(Integer.valueOf(4), "Diego", "Hernando", Integer.valueOf(8)));

        HashSet<Habitacion> habitaciones = new HashSet<>();

        habitaciones.add(habitacion1);
        habitaciones.add(habitacion2);
        habitaciones.add(habitacion3);
        habitaciones.add(habitacion4);
        habitaciones.add(habitacion5);

        JasperPrint print = null;

        try{
            File fichero = new File("./Informes/hotelInforme.jasper");

            HashMap <String, Object> params = new HashMap<>();
            params.put("RUTA_IMAGEN", "resources/habitacion.png");

            JRDesignSortField sortField = new JRDesignSortField();
            sortField.setName("num_habitacion");
            sortField.setOrder(SortOrderEnum.ASCENDING);
            sortField.setType(SortFieldTypeEnum.FIELD);
            List<JRSortField> sortList = new ArrayList<JRSortField>();
            sortList.add(sortField);
            params.put(JRParameter.SORT_FIELDS, sortList);

            JasperReport informe = (JasperReport) JRLoader.loadObject(fichero);

            JRBeanCollectionDataSource coleccion = new JRBeanCollectionDataSource(habitaciones);

            print = JasperFillManager.fillReport(informe, params, coleccion);

        } catch (JRException e) {
            e.getMessage();
        }

        return print;
    }

    public void onPrintButtonClick() {
        JasperPrint print = generateReport();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try {

                if (!fileToSave.getAbsolutePath().toLowerCase().endsWith(".pdf")) {
                    fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");
                }

                OutputStream output = new FileOutputStream(fileToSave);
                JasperExportManager.exportReportToPdfStream(print, output);
                output.close();

                welcomeText.setText("Fichero PDF correctamente generado en: " + fileToSave.getAbsolutePath());

            } catch (FileNotFoundException e) {
                welcomeText.setText("Error al generar el pdf");
                throw new RuntimeException(e);
            } catch (JRException e) {
                welcomeText.setText("Error al generar el pdf");
                throw new RuntimeException(e);
            } catch (IOException e) {
                welcomeText.setText("Error al generar el pdf");
                throw new RuntimeException(e);
            }
        }
    }


    public void onShowButtonClick() {
        JasperPrint print = generateReport();

        JRViewerFX visorFX = new JRViewerFX(print);
        reportPanel.getChildren().add(visorFX);

        welcomeText.setText("Reporte Generado!");
    }
}