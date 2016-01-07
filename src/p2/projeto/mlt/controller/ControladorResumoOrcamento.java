/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

/**
 *
 * @author carlosb
 */
public class ControladorResumoOrcamento {
    
      @FXML
 private javafx.scene.control.Button sair;
    
      
    @FXML
    public void imprimir() throws FileNotFoundException{
        String pdfFileName = "";
        ControladorResumoOrcamento printReport = new ControladorResumoOrcamento();
        
        printReport.createPDF();
       
        
        
        
    }  
    
    
    private void createPDF() throws FileNotFoundException{
        Document doc = new Document();
        PdfWriter docWriter = null;
        
        DecimalFormat df = new DecimalFormat("0.00");
        
        try {
            Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0,0,0));
            Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);
            
            String path = "C:\\Users\\ricardon\\Documents\\ProjetoP2\\" + "Teste";
            docWriter = PdfWriter.getInstance(doc, new FileOutputStream(path));
            
            doc.addAuthor("TEste1");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("Eu");
            doc.addTitle("Report");
            doc.setPageSize(PageSize.LETTER);
            
            doc.open();
            
            Paragraph paragraph = new Paragraph("iText");
            
            float[] columnWidths = {1.5f, 2f, 5f, 2f};
            PdfPTable table = new PdfPTable(columnWidths);
            table.setWidthPercentage(90f);
            
            insertCell(table, "Order No", Element.ALIGN_RIGHT, 1, bfBold12);
            insertCell(table, "Account No", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Account Name", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Order Total", Element.ALIGN_RIGHT, 1, bfBold12);
            table.setHeaderRows(1);
            
            insertCell(table, "", Element.ALIGN_LEFT, 4, bfBold12);
            insertCell(table, "New York Orders ...", Element.ALIGN_LEFT, 4, bfBold12);
            double orderTotal, total = 0;
            
            for(int x=1; x<5; x++){
    
                insertCell(table, "10010" + x, Element.ALIGN_RIGHT, 1, bf12);
                insertCell(table, "ABC00" + x, Element.ALIGN_LEFT, 1, bf12);
                insertCell(table, "This is Customer Number ABC00" + x, Element.ALIGN_LEFT, 1, bf12);

                //orderTotal = Double.valueOf(df.format(Math.random() * 1000));
                //total = total + orderTotal;
                //insertCell(table, df.format(orderTotal), Element.ALIGN_RIGHT, 1, bf12);

           }
            
            insertCell(table, "New York Total...", Element.ALIGN_RIGHT, 3, bfBold12);
            insertCell(table, df.format(total), Element.ALIGN_RIGHT, 1, bfBold12);
            
            
            insertCell(table, "", Element.ALIGN_LEFT, 4, bfBold12);
            insertCell(table, "California Orders ...", Element.ALIGN_LEFT, 4, bfBold12);
            orderTotal = 0;

            for(int x=1; x<7; x++){

                insertCell(table, "20020" + x, Element.ALIGN_RIGHT, 1, bf12);
                insertCell(table, "XYZ00" + x, Element.ALIGN_LEFT, 1, bf12);
                insertCell(table, "This is Customer Number XYZ00" + x, Element.ALIGN_LEFT, 1, bf12);

                //orderTotal = Double.valueOf(df.format(Math.random() * 1000));
                //total = total + orderTotal;
                //insertCell(table, df.format(orderTotal), Element.ALIGN_RIGHT, 1, bf12);

            }
            insertCell(table, "California Total...", Element.ALIGN_RIGHT, 3, bfBold12);
            insertCell(table, df.format(total), Element.ALIGN_RIGHT, 1, bfBold12);
            
            paragraph.add(table);
            doc.add(paragraph);
            
        } catch (DocumentException dex) {
            dex.printStackTrace();
        }
    }
     private void insertCell(PdfPTable table, String text, int align, int colspan, Font font){
  
        //create a new cell with the specified Text and Font
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
        //set the cell alignment
        cell.setHorizontalAlignment(align);
        //set the cell column span in case you want to merge two or more cells
        cell.setColspan(colspan);
        //in case there is no text and you wan to create an empty row
        if(text.trim().equalsIgnoreCase("")){
         cell.setMinimumHeight(10f);
        }
        //add the call to the table
        table.addCell(cell);
  
 }
      
    @FXML
    public void voltaMenuPrincipal() {
        try {
            Stage resumoOrcamentomento = (Stage) sair.getScene().getWindow();
            resumoOrcamentomento.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/MenuPrincipal.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("MenuPrincipal");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
