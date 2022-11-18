package application;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PdfWriteExample {

  //  private static final String FILE_NAME = "Invoice.pdf";

//    public static void main(String[] args) {
//        writeUsingIText();
//    }

    public void writeUsingIText(Paragraph p1,Paragraph p2,Paragraph p3,Paragraph p4,Paragraph p5,Paragraph p6,String filename) {
    	String FILE_NAME = filename;
        Document document = new Document();

        try {

            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

            //open
            document.open();

            Paragraph p = new Paragraph();
            p.add("Invoice");
            p.setAlignment(Element.ALIGN_CENTER);

            document.add(p);

          //  Paragraph p2 = new Paragraph();
          //  p2.add("This is my paragraph 2"); //no alignment

            document.add(p1);
            document.add(p2);
            document.add(p3);
            document.add(p4);
            document.add(p5);
            document.add(p6);


            //close
            document.close();

            System.out.println("Done");
         
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } 

    }
}
