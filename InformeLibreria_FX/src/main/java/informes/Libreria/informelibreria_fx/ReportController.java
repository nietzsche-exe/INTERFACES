package informes.libreria.informelibreria_fx;

import informes.libreria.Autor;
import informes.libreria.Libro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignSortField;
import net.sf.jasperreports.engine.type.SortFieldTypeEnum;
import net.sf.jasperreports.engine.type.SortOrderEnum;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import win.zqxu.jrviewer.JRViewerFX;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ReportController {

    @FXML
    public StackPane reportPane;

    public Label welcomeText;


    private JasperPrint generateReport() {
        Autor autor1 = new Autor("Miguel", "de Cervantes");
        Autor autor2 = new Autor("Juan", "Ortega");
        Autor autor3 = new Autor("Fernando", "de Rojas");


        Libro libro1 = new Libro("111", "El Quijote", autor1);
        Libro libro2 = new Libro("333", "El Lazarillo de Tormes", autor2);
        Libro libro3 = new Libro("222", "La Celestina", autor3);

        libro1.setVentas(100);
        libro2.setVentas(200);
        libro3.setVentas(300);

        HashSet<Libro> libros = new HashSet<Libro>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);

        JasperPrint print = null;
        try {
            File file = new File("./informes/reporte.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObject(file);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(libros);

            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("RUTA_IMAGEN", "./resources/libro.png");

            JRDesignSortField sortField = new JRDesignSortField();
            sortField.setName("ISBN");
            sortField.setOrder(SortOrderEnum.ASCENDING);
            sortField.setType(SortFieldTypeEnum.FIELD);
            List<JRSortField> sortList = new ArrayList<JRSortField>();
            sortList.add(sortField);

            parameters.put(JRParameter.SORT_FIELDS, sortList);

            print = JasperFillManager.fillReport(report, parameters, dataSource);


        }
        catch(JRException e) {
            e.printStackTrace();
        }

        return print;
    }

    @FXML
    protected void onShowButtonClick() {
        JasperPrint print = generateReport();
        JRViewerFX visorFX = new JRViewerFX(print);
        reportPane.getChildren().add(visorFX);

    }

    @FXML
    protected void onPrintButtonClick() {
    JasperPrint print = generateReport();

        File printPDF = new File("./informes/reporte.pdf");
        try {
            OutputStream output = new FileOutputStream(printPDF);
            JasperExportManager.exportReportToPdfStream(print, output);
            output.close();
            welcomeText.setText("Reporte generado en " + printPDF.getAbsolutePath());
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}