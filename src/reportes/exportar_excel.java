
package reportes;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
public class exportar_excel {
public void exportarExcel(JTable t) throws IOException {
    // Se crea un JFileChooser para que el usuario pueda elegir la ubicación y el nombre del archivo Excel
    JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
    chooser.setFileFilter(filter);
    chooser.setDialogTitle("Guardar archivo");
    chooser.setAcceptAllFileFilterUsed(false);
    // Se muestra el diálogo para guardar el archivo
    if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
        // Se obtiene la ruta seleccionada por el usuario
        String ruta = chooser.getSelectedFile().toString().concat(".xls");
        try {
            // Se crea un nuevo archivo Excel en la ruta seleccionada
            File archivoXLS = new File(ruta);
            // Si el archivo ya existe, se elimina para sobrescribirlo
            if (archivoXLS.exists()) {
                archivoXLS.delete();
            }
            archivoXLS.createNewFile();
            // Se crea un nuevo libro de trabajo (Workbook) en formato Excel
            Workbook libro = new HSSFWorkbook();
            FileOutputStream archivo = new FileOutputStream(archivoXLS);
            // Se crea una nueva hoja en el libro de trabajo
            Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
            hoja.setDisplayGridlines(false); // Se ocultan las líneas de la cuadrícula en la hoja
            
            // Se recorren las filas y columnas de la tabla para copiar los datos a la hoja de trabajo
            for (int f = 0; f < t.getRowCount(); f++) {
                Row fila = hoja.createRow(f);
                for (int c = 0; c < t.getColumnCount(); c++) {
                    Cell celda = fila.createCell(c);
                    // Si es la primera fila, se copian los nombres de las columnas
                    if (f == 0) {
                        celda.setCellValue(t.getColumnName(c));
                    }
                }
            }
            int filaInicio = 1;
            // Se copian los datos de la tabla a la hoja de trabajo
            for (int f = 0; f < t.getRowCount(); f++) {
                Row fila = hoja.createRow(filaInicio);
                filaInicio++;
                for (int c = 0; c < t.getColumnCount(); c++) {
                    Cell celda = fila.createCell(c);
                    // Se verifica el tipo de dato y se copia a la celda correspondiente en la hoja de trabajo
                    if (t.getValueAt(f, c) instanceof Double) {
                        celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                    } else if (t.getValueAt(f, c) instanceof Float) {
                        celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                    } else {
                        celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                    }
                }
            }
            // Se escribe el libro de trabajo en el archivo Excel
            libro.write(archivo);
            archivo.close();
            // Se abre el archivo Excel recién creado
            Desktop.getDesktop().open(archivoXLS);
        } catch (IOException | NumberFormatException e) {
            throw e;
        }
    }
}

}


