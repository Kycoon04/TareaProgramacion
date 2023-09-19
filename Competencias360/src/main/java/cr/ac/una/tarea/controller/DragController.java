/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.tarea.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * FXML Controller class
 *
 * @author dilan
 */
public class DragController implements Initializable {

    @FXML
    private Button btnArrastre;
    @FXML
    private GridPane cuadro;
    @FXML
    private ImageView imagen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         String nombreArchivo = "ListaUsuarios.xlsx";
        
        String hoja = "Usuarios";
        
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet(hoja);
        String[] header = new String[] {"NOMBRE", "TELEFONO", "EMAIL"};
        
        
        String[][] document = new String[][] {
            {"Sergio P", "1234567", "sergiop@prueba.es"},
            {"Laura L", "4324251", "laural@prueba.es"},
            {"Juan H", "7363153", "juanh@prueba.es"}
        };
        
        CellStyle style = libro.createCellStyle();
        XSSFFont font = libro.createFont();
        font.setBold(true);
        style.setFont(font);
        
        
        for(int i = 0 ; i <= document.length ; i++) {
            XSSFRow row = hoja1.createRow(i); 
            
            for(int j = 0 ; j < header.length ; j++) {
                if(i == 0) { 
                    XSSFCell cell = row.createCell(j); 
                    cell.setCellValue(header[j]);
                } else {
                    XSSFCell cell = row.createCell(j); 
                    cell.setCellValue(document[i - 1][j]); 
                }
            }
        }
        try (OutputStream fileOut = new FileOutputStream(nombreArchivo)){
            System.out.println("SE CREO EL EXCEL");
            libro.write(fileOut);
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        
    }    
   double startX, startY;
    double xTab, yTab;
    
    @FXML
    private void mouse(MouseEvent event) {
        System.out.println(event.getSceneX());
        System.out.println(event.getSceneY());
        btnArrastre.setOnMousePressed((t) -> {
            startX = t.getSceneX();//Obtiene la posicion en x del click segun el tamano de la ventana
            startY = t.getSceneY();//Obtiene la posicion en y del click segun el tamano de la ventana
        });
        btnArrastre.setOnMouseDragged((t) -> {
            ImageView asiento = (ImageView) btnArrastre.getGraphic();
            asiento.setTranslateX(t.getSceneX() - startX);
            asiento.setTranslateY(t.getSceneY() - startY);
            xTab = t.getSceneX() - 140;//punto origen en x
            yTab = t.getSceneY() - 87;//punto origen en y
        });
        btnArrastre.setOnMouseReleased((t) -> {
            int posX = (int) (xTab / cuadro.getCellBounds(0, 0).getMaxX());//63 size width
            int posY = (int) (yTab / cuadro.getCellBounds(0, 0).getMaxY());//32 size heigth
            if (posX >= 0 && posX < 3 && posY >= 0 && posY < 5) {
              
                cuadro.add(crearAsiento(posX+"",posY+""), posX, posY);
            }
            imagen.setTranslateX(0);
            imagen.setTranslateY(0);
        });
        
        
    }
    
    
    private Button crearAsiento(String letra, String numero) {
        Button asiento = new Button();
        ImageView imagen = new ImageView();
        asiento.setMaxSize(40, 40);
        asiento.setTooltip(new Tooltip("Fila: " + letra + " Numero: " + numero));
        ajustarImagen(imagen);
        imagen.setImage(imagen.getImage());
        asiento.setGraphic(imagen);
        return asiento;
    }
        private void ajustarImagen(ImageView imagen) {
        imagen.setFitHeight(25);
        imagen.setFitWidth(25);
        imagen.setScaleX(3);
        imagen.setScaleY(1.5);
    }
    
}
