package com.practise.HELPER;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.practise.Entity.p_Entity;
 
 
public class Pdf_Helper {
    private List<p_Entity> listUsers;
     
    public Pdf_Helper(List<p_Entity> listUsers) {
        this.listUsers = listUsers;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("User ID", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("E-mail", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Full Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("phone no", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("City", font));
        table.addCell(cell);       
    }
     
    private void writeTableData(PdfPTable table) {
        for (p_Entity user : listUsers) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getEmail());
            table.addCell(user.getName());
            table.addCell(user.getPhoneNo());
            table.addCell(user.getCity());
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        
        
        final String path = new ClassPathResource("").getFile().getAbsolutePath();
       
        System.err.println("Path----" + path);
        File directory=new File(path,"/documents");
        if(!directory.exists()) {
        	boolean mkdir = directory.mkdir();
        	System.err.println("mkdir"+mkdir);
        }
        File pdfFile=new File(directory,"user_list.pdf");
        
        OutputStream fileOut = new FileOutputStream(pdfFile);
       // OutputStream responseOut = response.getOutputStream();
        
        PdfWriter writer = PdfWriter.getInstance(document, fileOut);
       // writer = PdfWriter.getInstance(document, responseOut);
        System.err.println("writer"+writer);
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
       
         
        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
        fileOut.close();
        
     
      
        
         
    }
}
