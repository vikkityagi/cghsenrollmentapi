package io.swagger.utils;


import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import io.swagger.model.NodalApplicationDetail;

public class OnboardingApplicationPDF {
    private Font BOLD = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private Font NORMAL = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.NORMAL);
    private Font UNDERLINE = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.UNDERLINE);
    private Font SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

    public static void main(String[] args) {
        OnboardingApplicationPDF onboardingApplicationPDF = new OnboardingApplicationPDF();
        onboardingApplicationPDF.generatePDF(null);

    }
    
   
    // generate a pdf using itext library
    public  void generatePDF(NodalApplicationDetail applicationDetail) {
       // NodalOfficer nodalOfficer = applicationDetail.getNodalOfficer();
       // ApprovingAuthority approvingAuthority = applicationDetail.getApprovingAuthority();
        
        Document document = new Document();
        try {
           
            PdfWriter.getInstance(document, new FileOutputStream(new File("G:/itext.pdf")));
            document.open();
            document.add(crateITextParagraphWithCentreAlignment("CGHS Nodal Officer Onboarding Application Form",BOLD));
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(crateITextParagraphWithCentreAlignment("Nodal Officer Details",NORMAL));
            document.add(Chunk.NEWLINE);
            
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setSpacingBefore(11f);
            table.setSpacingAfter(11f);
            float[] columnWidths = {1f, 2f, 1f,2f};
            table.setWidths(columnWidths);
            // table 1 start 
            
            PdfPCell cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("Name  ",SMALL));
            
            table.addCell(cell);

            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement((crateITextParagraphWithLeftAlignment("Vikram Singh",SMALL)));
            table.addCell(cell);

            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("Designation  ",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("Scientist",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("Employee Code",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("a2b3",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("Date Of Birth",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("12-07-1998",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("Date Of Superannuation",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("12-07-1998",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("Present Pay Level",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("4541245",SMALL));
            table.addCell(cell);
            
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("Official Email Id",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("vikkityagi1998@gmail.com",SMALL));
            table.addCell(cell);
            
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("Official Phone No",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("7017xxxxxx91",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("Mobile Number",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("9084xxxx26",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("Office Address",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("CGO Complex",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("City",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("Delhi",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("State",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("East Delhi",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("PinCode",SMALL));
            table.addCell(cell);
            
            cell = new PdfPCell();
            cell.setBorder(0);
            cell.addElement(crateITextParagraphWithLeftAlignment("25xx07",SMALL));
            table.addCell(cell);
            
            
            
            

            // table one end
            document.add(table);

            document.add(Chunk.NEWLINE);
            document.add(crateITextParagraphWithCentreAlignment("Approving Officer Details",NORMAL));
            document.add(Chunk.NEWLINE);
            //table 2 start
            PdfPTable table2 = new PdfPTable(4);
            table2.setWidthPercentage(100);
            table2.setSpacingBefore(11f);
            table2.setSpacingAfter(11f);
             columnWidths = new float[]{1f, 2f, 1f,2f};
            table2.setWidths(columnWidths);
            
            PdfPCell cell2 = new PdfPCell();
            cell2.setBorder(0);
            cell2.addElement(crateITextParagraphWithLeftAlignment("Name  ",SMALL));
            table2.addCell(cell2);

            cell2 = new PdfPCell();
            cell2.setBorder(0);
            cell2.addElement((crateITextParagraphWithLeftAlignment("Vikram Singh",SMALL)));
            table2.addCell(cell2);
            
            cell2 = new PdfPCell();
            cell2.setBorder(0);
            cell2.addElement(crateITextParagraphWithLeftAlignment("Designation",SMALL));
            table2.addCell(cell2);

            cell2 = new PdfPCell();
            cell2.setBorder(0);
            cell2.addElement((crateITextParagraphWithLeftAlignment("Scintist-B",SMALL)));
            table2.addCell(cell2);
            
            cell2 = new PdfPCell();
            cell2.setBorder(0);
            cell2.addElement(crateITextParagraphWithLeftAlignment("Employee Id",SMALL));
            table2.addCell(cell2);

            cell2 = new PdfPCell();
            cell2.setBorder(0);
            cell2.addElement((crateITextParagraphWithLeftAlignment("xxxxx",SMALL)));
            table2.addCell(cell2);
            
            cell2 = new PdfPCell();
            cell2.setBorder(0);
            cell2.addElement(crateITextParagraphWithLeftAlignment("Official Email",SMALL));
            table2.addCell(cell2);

            cell2 = new PdfPCell();
            cell2.setBorder(0);
            cell2.addElement((crateITextParagraphWithLeftAlignment("vikram.singhxxxxx@gov.in",SMALL)));
            table2.addCell(cell2);
            
            cell2 = new PdfPCell();
            cell2.setBorder(0);
            cell2.addElement(crateITextParagraphWithLeftAlignment("Offical Phone No",SMALL));
            table2.addCell(cell2);

            cell2 = new PdfPCell();
            cell2.setBorder(0);
            cell2.addElement((crateITextParagraphWithLeftAlignment("98xxxxx45",SMALL)));
            table2.addCell(cell2);
            
            cell2 = new PdfPCell();
            cell2.setBorder(0);
            cell2.addElement(crateITextParagraphWithLeftAlignment("Mobile No",SMALL));
            table2.addCell(cell2);

            cell2 = new PdfPCell();
            cell2.setBorder(0);
            cell2.addElement((crateITextParagraphWithLeftAlignment("85xxxxx98",SMALL)));
            table2.addCell(cell2);

            // table 2 end
            document.add(table2);


            document.add(Chunk.NEWLINE);
            document.add(crateITextParagraphWithCentreAlignment("Application Details",NORMAL));
            document.add(Chunk.NEWLINE);

            // create paragraphs for application details data 
            // add paragraphs to document
            Paragraph para = new Paragraph ("- Nodal officer is being appointed for following CGHS cities"); 
            document.add(para);
            Paragraph para1 = new Paragraph ("Delhi ,Kolkata ,Lucknow"); 
            para1.setSpacingAfter(12f);
            document.add(para1);
            
            Paragraph para2 = new Paragraph ("- Total Strength of serving staff eligible for CGHS card in above cities"); 
            document.add(para2);
            
            Paragraph para3 = new Paragraph ("12");
            para3.setSpacingAfter(40f);
            document.add(para3);
            
            Paragraph para4 = new Paragraph ("I certify that all the above details are true to the best  of my knowledge.");
            para4.setSpacingAfter(30f);
            document.add(para4);
            
            Chunk glue = new Chunk(new VerticalPositionMark());
            Paragraph para5 = new Paragraph ("Sign and Stamp of Approving");
            para5.setAlignment(Element.ALIGN_RIGHT);
            document.add(para5);
            Paragraph para6 = new Paragraph ("Authority");
            para6.setAlignment(Element.ALIGN_RIGHT);
            para6.add(new Chunk(glue));
            para6.add("....");
            document.add(para6);
            
            
           

            
            
            
            document.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
    }
    // itext add two paragraphs in one cell
    
    Paragraph crateITextParagraphWithCentreAlignment(String text,Font font) throws DocumentException{
        Paragraph paragraph = new Paragraph();
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.add(text);
        paragraph.setFont(font);
        return paragraph;
    }
    Paragraph crateITextParagraphWithRightAlignment(String text,Font font) throws DocumentException{
        Paragraph paragraph = new Paragraph();
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        paragraph.add(text);
        paragraph.setFont(font);
        return paragraph;
    }
    Paragraph crateITextParagraphWithLeftAlignment(String text,Font font) throws DocumentException{
        Paragraph paragraph = new Paragraph();
        paragraph.setAlignment(Element.ALIGN_LEFT);
        paragraph.add(text);
        paragraph.setFont(font);
        return paragraph;
    }
   

   

}
