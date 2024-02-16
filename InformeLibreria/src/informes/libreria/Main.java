package informes.libreria;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        Autor autor1 = new Autor("Miguel", "de Cervantes");
        Autor autor2 = new Autor("Juan", "Ortega");
        Autor autor3 = new Autor("Fernando", "de Rojas");


        Libro libro1 = new Libro("1234567890", "El Quijote", autor1);
        Libro libro2 = new Libro("1234567891", "El Lazarillo de Tormes", autor2);
        Libro libro3 = new Libro("1234567892", "La Celestina", autor3);

        libro1.setVentas(100);
        libro2.setVentas(200);
        libro3.setVentas(300);

        HashSet<Libro> libros = new HashSet<Libro>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);

        try {
            File file = new File("./informes/reporte.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObject(file);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(libros);

            JasperPrint print = JasperFillManager.fillReport(report, null, dataSource);

            JasperViewer viewer = new JasperViewer(print);
            viewer.setVisible(true);
        }
        catch(JRException e) {
            e.printStackTrace();
        }

    }
}