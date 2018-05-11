package com.pdfservice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.itextpdf.text.BaseColor;
//import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Hello world!
 *
 */
public class App implements ActionListener
{
	//private static final String BMP = "BMP";
	
	//ImageType imt= ImageType.BMP;
	
	//public static final String DEST = "c:\\dev\\sample.pdf";
	//CSV csv = new CSV();
	
	

//	public static void main(String args[]) throws DocumentException, IOException, URISyntaxException{
//		File file = new File(DEST);
//		try {
//			new App().createPdf(DEST, ASR);
//			new App().createPdf(DEST, ASR);
//		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	
//	}
	
	public void createPdf(String dest, ASR asr) throws DocumentException, IOException, URISyntaxException{
		FileOutputStream fos = new FileOutputStream(dest);
		/*PdfWriter writer = new PdfWriter(fos);
		PdfDocument pdf = new PdfDocument(writer);
		Document document = new Document(pdf);

		Paragraph p = new Paragraph();*/
		
		
		//URL pdfLogoPath = new URL("file","c:/","file:///c:/fda/pdfTemplate/fdaLogo.bmp");
		//URL pdfInsigniaPath = new URL("", "", "C:/FDA/pdfTemplate/pdfInsignia.bmp");
		 
		//ImageData imageDataLogo = new BmpImageData(pdfLogoPath, false, 255 );
		//ImageData imageDataInsignia = new BmpImageData(pdfInsigniaPath, false, 50 );
		
		//PdfImageXObject pdfLogo = new PdfImageXObject(imageDataLogo);
		//Image imageLogo = new Image(pdfLogo);
		//Image logo = new Image();
		//Paragraph p = new Paragraph();
		//document.add(imageLogo);
		Document document= new Document();
		PdfWriter writer = PdfWriter.getInstance(document, fos);
		writer.setPdfVersion(PdfWriter.PDF_VERSION_1_7);
		
		document.open();
		
		Paragraph p = new Paragraph();
		Chunk c = new Chunk();
		//p.setFont(new Font(FontFamily.HELVETICA, 20));
		//Chunk c = new Chunk("The quick brown");
		//p.add(c);
		Image image = Image.getInstance("fdaLogo.bmp");
		image.setAlignment(Image.LEFT | Image.TEXTWRAP);
		c = new Chunk(image, 0, -50, true);
		p.add(c);
		document.add(p);
		
		Paragraph p1 = new Paragraph();
		p1.setAlignment(p1.ALIGN_RIGHT);
		p1.setFont(new Font(FontFamily.HELVETICA, (float) 7.02));
		p1.add("Food and Drug Administration\n "
				+ "Automated Submissions Receipt\n"
					+ "System Requirements Specifications (SRS) Document");
		p1.setLeading(6,0);
		
		Paragraph p2 = new Paragraph();
		p2.setAlignment(p2.ALIGN_LEFT);
		p2.setFont(new Font(FontFamily.HELVETICA, (float) 14));
		p2.add("6.12 ASR Successful, 3rd Acknowledgement PDF notification");
		p2.setLeading(12,0);
		p2.setSpacingBefore(50);
		
		Paragraph p3 = new Paragraph();
		Image image2 = Image.getInstance("fdaInsignia.jpg");
		image2.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
		image2.scaleAbsolute(100, 100);
		c = new Chunk(image2, 0, 0, true);
		p3.setAlignment(p3.ALIGN_CENTER);
		p3.setSpacingBefore(50);
		p3.add(c);
		
		Paragraph p4 = new Paragraph();
		p4.setAlignment(p4.ALIGN_LEFT);
		p4.setFont(new Font(FontFamily.TIMES_ROMAN, (float) 12));
		p4.add("Your submission was successfully processed into the CDER Electronic Document Room, and is available to the assigned review division.   ");
		p4.setLeading(12,0);
		p4.setSpacingBefore(25);
		
		PdfPTable tbl = new PdfPTable(2);
		Font cellFont = new Font(FontFamily.TIMES_ROMAN, (float) 12, Font.BOLD);
		PdfContentByte canvas = writer.getDirectContent();
		Phrase pc1 = new Phrase("Application Type/Number:\n");
		pc1.setFont(cellFont);
		PdfPCell c1 = new PdfPCell(pc1);
		c1.setBorder(0);
		
		
		PdfPCell c2 = new PdfPCell(new Phrase(asr.getApplicationnumber() + "\n"));
		c2.setBorder(0);
		c2.setVerticalAlignment(c2.ALIGN_BOTTOM);
		
		PdfPCell c3 = new PdfPCell(new Phrase("eCTD Sequence Number:  (ADD URL)\n"));
		c3.setBorder(0);
		
		PdfPCell c4 = new PdfPCell(new Phrase(asr.getEctd() + "\n"));
		c4.setBorder(0);
		c4.setVerticalAlignment(c2.ALIGN_BOTTOM);
		
		PdfPCell c5 = new PdfPCell(new Phrase("CoreID:\n"));
		c5.setBorder(0);
		
		PdfPCell c6 = new PdfPCell(new Phrase(asr.getCoreid() + "\n"));
		c6.setBorder(0);
		c6.setVerticalAlignment(c2.ALIGN_BOTTOM);
		
		tbl.addCell(c1);
		tbl.addCell(c2);
		tbl.addCell(c3);
		tbl.addCell(c4);
		tbl.addCell(c5);
		tbl.addCell(c6);
		
		tbl.setTotalWidth(559);
		tbl.writeSelectedRows(0, -1, 36, 500, canvas);
		
		
		
	/*	Paragraph p5 = new Paragraph();
		//ContentByte cb = new ContentByte();
		//ColumnText ct = new ColumnText(null);
		
		p5.setAlignment(p5.ALIGN_LEFT);
		p5.setFont(new Font(FontFamily.HELVETICA, (float) 14));
		p5.add("Application Type/Number:  eCTD Sequence Number:  CoreID:");
		p5.setLeading(12,0);
		p5.setSpacingBefore(25);*/
		
		
		Paragraph p6 = new Paragraph();
		
		URL link1 = new URL("http://www.fda.gov/downloads/Drugs/GuidanceComplianceRegulatoryInformation/Guidances/UCM072385.pdf");
		Font fontForAnchor1 = new Font(FontFamily.HELVETICA, 12, Font.UNDERLINE, BaseColor.BLUE);
		Chunk anchorChunk1 = new Chunk(link1.toExternalForm(), fontForAnchor1);
		
		//URL link1 = new URL("http://www.google.com");
		p6.setAlignment(p6.ALIGN_LEFT);
		p6.setFont(new Font(FontFamily.TIMES_ROMAN, (float) 12));
		p6.add("Your official receipt date is calculated in accordance with the following final Guidance for Industry: ");
		p6.add(anchorChunk1);
		p6.setLeading(18,0);
		p6.setSpacingBefore(75);
		//document.add(p6);
		
		
		
		/*PdfPTable tbl2 = new PdfPTable(2);
		PdfContentByte canvas2 = writer.getDirectContent();
		PdfPCell c21 = new PdfPCell(new Phrase("Contact Information:"));
		c21.setBorder(0);
		
		
		PdfPCell c22 = new PdfPCell(new Phrase(asr.getContactInfo() + "\n"));
		c22.setBorder(0);
		c22.setVerticalAlignment(c22.ALIGN_BOTTOM);
		
		PdfPCell c23 = new PdfPCell(new Phrase("For technical assistance only: \n"));
		c23.setBorder(0);
		
		Anchor anchor = new Anchor("mscarpace@deloitte.com");
		anchor.setReference("mailto:mscarpace@deloitte.com");
		PdfPCell c24 = new PdfPCell(new Phrase(anchor + "\n"));
		c24.setBorder(0);
		c24.setVerticalAlignment(c22.ALIGN_BOTTOM);
		
		PdfPCell c25 = new PdfPCell(new Phrase("For all other questions regarding your submission, contact your review division.\n"));
		c25.setBorder(0);
		
		PdfPCell c26 = new PdfPCell(new Phrase(asr.getOther() + "\n"));
		c26.setBorder(0);
		c26.setVerticalAlignment(c22.ALIGN_BOTTOM);
		
		tbl2.addCell(c21);
		tbl2.addCell(c22);
		tbl2.addCell(c23);
		tbl2.addCell(c24);
		tbl2.addCell(c25);
		tbl2.addCell(c26);
		
		tbl2.setTotalWidth(300);
		tbl2.writeSelectedRows(0, -1, 169, tbl2.getTotalHeight() + 200, canvas2);*/
		
		
		
		Paragraph p7 = new Paragraph();
		
	
		URL link3 = new URL("http://eSUB@fda.hhs.gov");
		Font fontForAnchor = new Font(FontFamily.HELVETICA, 12, Font.UNDERLINE, BaseColor.BLUE);
		Chunk anchorChunk = new Chunk(link3.toExternalForm(), fontForAnchor);
		
		
		//anchorChunk.setFont(fontForAnchor);
		//anchorChunk.setAnchor(link1);
		//anchor.setFont(anchorFont);
		
		p7.setAlignment(p7.ALIGN_LEFT);
		p7.setFont(new Font(FontFamily.TIMES_ROMAN, (float) 12));
		//p7.setFont(new Font(FontFamily.HELVETICA, (float) 14));
		p7.add("Contact Information:\n" + 
				"For technical assistance only:  ");
		p7.add(anchorChunk);
		p7.add(" " + "\n");
		p7.add("For all other questions regarding your submission, contact your review division.\n" +  
				"Thank you,\n\n"); 
		p7.setLeading(18,0);
		p7.setSpacingBefore(25);
		
		Paragraph p8 = new Paragraph();
		p8.add("Electronic Document Room\n" + 
		"Center for Drug Evaluation and Research\n" + 
		"U.S. Food and Drug Administration\n");
		p8.setLeading(12,0);
		//p8.setSpacingBefore(25);
		
		
		
		
		//Paragraph p9 = new Paragraph();
		Font phrase1Font = new Font();
		phrase1Font.setStyle(phrase1Font.BOLD);
		Phrase phrase1 = new Phrase();
		phrase1.setFont(phrase1Font);
		phrase1.add("– Procuremen Sensitive –\n");
		
		
		Phrase phrase2 = new Phrase();
		phrase2.add("This document shall not be disclosed or distributed outside of the ESP Team without approval of the Program manager");
		
		//p8.setAlignment(p8.ALIGN_CENTER);
		/*p8.setAlignment(Element.ALIGN_BOTTOM);
		p8.setFont(new Font(FontFamily.HELVETICA, (float) 14, Font.BOLD));
		p8.add("– Procuremen Sensitive –\n");
		p8.setLeading(12,0);
		p8.setSpacingBefore(0);*/
		PdfContentByte cb2 = writer.getDirectContent();
		Rectangle rect = new Rectangle(36, 0, 559, 100);
		//450, 150
		/*System.out.println(document.getPageSize());
		System.out.println(document.bottom());
		System.out.println(document.top());
		System.out.println(document.left());
		System.out.println(document.right());*/
		rect.setBorder(rect.BOX);
		//rect.setBorderWidth(2);
		cb2.rectangle(rect);
		cb2.stroke();
		//cb2.rectangle(rect);
			//Paragraph bottomPage1 = new Paragraph(phrase1);
		//bottomPage1.setAlignment(phrase1.ALIGN_CENTER);
			//bottomPage1.setAlignment(phrase1.ALIGN_CENTER);
			//Paragraph bottomPage2 = new Paragraph(phrase2);
		//bottomPage2.setAlignment(phrase2.ALIGN_CENTER);
			//bottomPage2.setAlignment(phrase2.ALIGN_CENTER);
		
		
		
		Paragraph bottomPage1 = new Paragraph(phrase1);
		//bottomPage1.setAlignment(phrase1.ALIGN_CENTER);
		bottomPage1.setAlignment(phrase1.ALIGN_CENTER);
		Paragraph bottomPage2 = new Paragraph(phrase2);
		//bottomPage2.setAlignment(phrase2.ALIGN_CENTER);
		bottomPage2.setAlignment(phrase2.ALIGN_CENTER);
		
		
		
		ColumnText ct = new ColumnText(cb2);
		ct.setSimpleColumn(rect);
		ct.addElement(new Paragraph(bottomPage1));
		ct.addElement(bottomPage2);
		ct.setSimpleColumn(rect);
		ct.go();
	
		
		
		
		
		
		
		/*Paragraph p9 = new Paragraph();
		//p9.setAlignment(p9.ALIGN_CENTER);
		p9.setAlignment(Element.ALIGN_BOTTOM);
		p9.setFont(new Font(FontFamily.HELVETICA, (float) 14));
		p9.add("This document shall not be disclosed or distributed outside of the ESP Team  without approval of the Program Manager.  \n");
		p9.setLeading(12,0);
		p9.setSpacingBefore(0);
		
		Paragraph p8 = new Paragraph();
		Image paragraphChunk = Image.getInstance("fdaInsignia.jpg");
		image3.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
		image3.scaleAbsolute(100, 100);
		c = new Chunk("– Procuremen Sensitive –\n", 0, 0, true);
		c = new Chunk();
		p8.setAlignment(p3.ALIGN_CENTER);
		p8.setSpacingBefore(50);
		p8.add(c);*/
		
		document.add(p1);
		document.add(p2);
		document.add(p3);
		document.add(p4);
		//document.add(p5);
		document.add(p6);
		document.add(p7);
		document.add(p8);
		
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		document.newPage();
		
		Paragraph pp = new Paragraph();
		Chunk cc = new Chunk();
		//p.setFont(new Font(FontFamily.HELVETICA, 20));
		//Chunk c = new Chunk("The quick brown");
		//p.add(c);
		Image imageimage = Image.getInstance("fdaLogo.bmp");
		imageimage.setAlignment(Image.LEFT | Image.TEXTWRAP);
		cc = new Chunk(imageimage, 0, -50, true);
		pp.add(cc);
		document.add(pp);
		
		Paragraph pp1 = new Paragraph();
		pp1.setAlignment(pp1.ALIGN_RIGHT);
		pp1.setFont(new Font(FontFamily.HELVETICA, (float) 7.02));
		pp1.add("Food and Drug Administration\n "
				+ "Automated Submissions Receipt\n"
					+ "System Requirements Specifications (SRS) Document");
		pp1.setLeading(6,0);
		
		Paragraph pp2 = new Paragraph();
		pp2.setAlignment(p2.ALIGN_LEFT);
		pp2.setFont(new Font(FontFamily.HELVETICA, (float) 14));
		pp2.add("6.13 ASR Successful, and 3rd Acknowledgement PDF notification with WARNING");
		pp2.setLeading(18,0);
		pp2.setSpacingBefore(50);
		
		
		
		Paragraph pp4 = new Paragraph();
		pp4.setAlignment(p4.ALIGN_LEFT);
		pp4.setFont(new Font(FontFamily.HELVETICA, (float) 14));
		pp4.add("3rd acknowledgement in .pdf format (generated and sent by ASR to sponor's inbox) - needs to be implemented ASAP (before MAR 2017)");
		pp4.setLeading(18,0);
		pp4.setSpacingBefore(12);
		
		Paragraph pp5 = new Paragraph();
		//ContentByte cb = new ContentByte();
		//ColumnText ct = new ColumnText(null);
		
		pp5.setAlignment(pp5.ALIGN_LEFT);
		pp5.setFont(new Font(FontFamily.HELVETICA, (float) 14));
		pp5.add("Subject: 3rd ACK Warning Processed eCTD: (NDA 012345) - ci1441827177076.53972@");
		pp5.setLeading(18,0);
		pp5.setSpacingBefore(12);
		
		Paragraph pp3 = new Paragraph();
		Image imageimage2 = Image.getInstance("fdaInsignia.jpg");
		imageimage2.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
		imageimage2.scaleAbsolute(100, 100);
		cc = new Chunk(imageimage2, 0, 0, true);
		pp3.setAlignment(pp3.ALIGN_CENTER);
		pp3.setSpacingBefore(25);
		pp3.add(c);
		
		PdfPTable tbltbl = new PdfPTable(2);
		PdfContentByte canvascanvas = writer.getDirectContent();
		PdfPCell cc1 = new PdfPCell(new Phrase("Application Type/Number:\n"));
		cc1.setBorder(0);
		
		
		PdfPCell cc2 = new PdfPCell(new Phrase(asr.getApplicationnumber() + "\n"));
		cc2.setBorder(0);
		cc2.setVerticalAlignment(c2.ALIGN_BOTTOM);
		
		PdfPCell cc3 = new PdfPCell(new Phrase("eCTD Sequence Number:  (ADD URL)\n"));
		cc3.setBorder(0);
		
		PdfPCell cc4 = new PdfPCell(new Phrase(asr.getEctd() + "\n"));
		cc4.setBorder(0);
		cc4.setVerticalAlignment(c2.ALIGN_BOTTOM);
		
		PdfPCell cc5 = new PdfPCell(new Phrase("CoreID:\n"));
		cc5.setBorder(0);
		
		PdfPCell cc6 = new PdfPCell(new Phrase(asr.getCoreid() + "\n"));
		cc6.setBorder(0);
		cc6.setVerticalAlignment(c2.ALIGN_BOTTOM);
		
		tbltbl.addCell(cc1);
		tbltbl.addCell(cc2);
		tbltbl.addCell(cc3);
		tbltbl.addCell(cc4);
		tbltbl.addCell(cc5);
		tbltbl.addCell(cc6);
		
		tbltbl.setTotalWidth(559);
		tbltbl.writeSelectedRows(0, -1, 36, 375, canvascanvas);
		
		/*PdfPTable tbltbl2 = new PdfPTable(2);
		PdfContentByte canvascanvas2 = writer.getDirectContent();
		PdfPCell cc21 = new PdfPCell(new Phrase("Contact Information:"));
		cc21.setBorder(0);
		
		
		PdfPCell cc22 = new PdfPCell(new Phrase(asr.getContactInfo() + "\n"));
		cc22.setBorder(0);
		cc22.setVerticalAlignment(cc22.ALIGN_BOTTOM);
		
		PdfPCell cc23 = new PdfPCell(new Phrase("For technical assistance only: \n"));
		cc23.setBorder(0);
		
		URL link4 = new URL("http://www.google.com");
		PdfPCell cc24 = new PdfPCell(new Phrase(link4 + "\n"));
		cc24.setBorder(0);
		cc24.setVerticalAlignment(cc22.ALIGN_BOTTOM);
		
		PdfPCell cc25 = new PdfPCell(new Phrase("For all other questions regarding your submission, contact your review division.\n"));
		cc25.setBorder(0);
		
		PdfPCell cc26 = new PdfPCell(new Phrase(asr.getOther() + "\n"));
		cc26.setBorder(0);
		cc26.setVerticalAlignment(cc22.ALIGN_BOTTOM);
		
		tbltbl2.addCell(cc21);
		tbltbl2.addCell(cc22);
		tbltbl2.addCell(cc23);
		tbltbl2.addCell(cc24);
		tbltbl2.addCell(cc25);
		tbltbl2.addCell(cc26);
		
		tbltbl2.setTotalWidth(300);
		tbltbl2.writeSelectedRows(0, -1, 169, tbltbl2.getTotalHeight() + 200, canvascanvas2);*/
		
		
		
		Paragraph pp6 = new Paragraph();
		pp6.setAlignment(pp6.ALIGN_LEFT);
		pp6.setFont(new Font(FontFamily.HELVETICA, (float) 14));
		pp6.add("Your submission was successfullly processed into the CDER Electronic Document Room and is available to the assigned review division");
		pp6.setLeading(12,0);
		pp6.setSpacingBefore(18);
		
		Paragraph pp7 = new Paragraph();
		pp7.setAlignment(pp7.ALIGN_LEFT);
		pp7.setFont(new Font(FontFamily.HELVETICA, (float) 14));
		pp7.add("Warning: Submissions that do not include a fillable form are subject for rejection beginning May 5, 2017.");
		pp7.setLeading(12,0);
		pp7.setSpacingBefore(18);
		
		/*Paragraph p7 = new Paragraph();
		p7.setAlignment(p7.ALIGN_LEFT);
		p7.setFont(new Font(FontFamily.HELVETICA, (float) 14));
		p7.add("Contact Information:\n" + 
				"For technical assistance only:  (ADD URL)\n" + 
				"For all other questions regarding your submission, contact your review division.\n" +  
				"Thank you,\n" + 
				"Electronic Document Room\n" + 
				"Center for Drug Evaluation and Research\n" + 
				"U.S. Food and Drug Administration\n");
		p7.setLeading(12,0);
		p7.setSpacingBefore(25);*/
		
		/*PdfPTable tbltbl2 = new PdfPTable(2);
		PdfContentByte canvascanvas2 = writer.getDirectContent();
		PdfPCell cc21 = new PdfPCell(new Phrase("Contact Information:\n"));
		cc21.setBorder(0);
		
		
		PdfPCell cc22 = new PdfPCell(new Phrase("(Add Text)\n"));
		cc22.setBorder(0);
		cc22.setVerticalAlignment(cc22.ALIGN_BOTTOM);
		
		PdfPCell cc23 = new PdfPCell(new Phrase("For technical assistance only:  (ADD URL)\n"));
		cc23.setBorder(0);
		
		PdfPCell cc24 = new PdfPCell(new Phrase("(Add Text)\n"));
		cc24.setBorder(0);
		cc24.setVerticalAlignment(cc22.ALIGN_BOTTOM);
		
		PdfPCell cc25 = new PdfPCell(new Phrase("For all other questions regarding your submission, contact your review division.\n"));
		cc25.setBorder(0);
		
		PdfPCell cc26 = new PdfPCell(new Phrase("(Add Text)\n"));
		cc26.setBorder(0);
		cc26.setVerticalAlignment(c22.ALIGN_BOTTOM);
		
		tbltbl2.addCell(cc21);
		tbltbl2.addCell(cc22);
		tbltbl2.addCell(cc23);
		tbltbl2.addCell(cc24);
		tbltbl2.addCell(cc25);
		tbltbl2.addCell(cc26);
		
		tbltbl2.setTotalWidth(300);
		tbltbl2.writeSelectedRows(0, -1, 169, tbltbl2.getTotalHeight() + 200, canvascanvas2);*/
		
		Paragraph pp8 = new Paragraph();
		
		
		URL link4 = new URL("http://eSUB@fda.hhs.gov");
		//Font fontForAnchor2 = new Font(FontFamily.HELVETICA, 12, Font.UNDERLINE, BaseColor.BLUE);
		//Chunk anchorChunk2 = new Chunk(link3.toExternalForm(), fontForAnchor);
		
		
		//anchorChunk.setFont(fontForAnchor);
		//anchorChunk.setAnchor(link1);
		//anchor.setFont(anchorFont);
		
		pp8.setAlignment(p7.ALIGN_LEFT);
		//p7.setFont(new Font(FontFamily.HELVETICA, (float) 14));
		pp8.add("Contact Information:\n" + 
				"For technical assistance only:  ");
		pp8.add(anchorChunk);
		pp8.add(" " + "\n");
		pp8.add("For all other questions regarding your submission, contact your review division.\n" +  
				"Thank you,\n\n"); 
		pp8.setLeading(18,0);
		pp8.setSpacingBefore(100);
		
		Paragraph pp9 = new Paragraph();
		pp9.add("Electronic Document Room\n" + 
		"Center for Drug Evaluation and Research\n" + 
		"U.S. Food and Drug Administration\n");
		pp9.setLeading(12,0);
		//pp9.setSpacingBefore(25);
		
		
		//Paragraph pp8 = new Paragraph();
		Font pphrase1Font = new Font();
		pphrase1Font.setStyle(pphrase1Font.BOLD);
		Phrase pphrase1 = new Phrase();
		pphrase1.setFont(pphrase1Font);
		pphrase1.add("– Procuremen Sensitive –\n");
		
		
		Phrase pphrase2 = new Phrase();
		pphrase2.add("This document shall not be disclosed or distributed outside of the ESP Team without approval of the Program manager");
		
		//p8.setAlignment(p8.ALIGN_CENTER);
		/*p8.setAlignment(Element.ALIGN_BOTTOM);
		p8.setFont(new Font(FontFamily.HELVETICA, (float) 14, Font.BOLD));
		p8.add("– Procuremen Sensitive –\n");
		p8.setLeading(12,0);
		p8.setSpacingBefore(0);*/
		PdfContentByte ccb2 = writer.getDirectContent();
		Rectangle rectrect = new Rectangle(36, 0, 559, 100);
		//rect.setBorder(0);
		ccb2.rectangle(rectrect) ;
		ccb2.stroke();
		//cb2.rectangle(rect);
		Paragraph bbottomPage1 = new Paragraph(pphrase1);
		//bottomPage1.setAlignment(phrase1.ALIGN_CENTER);
		bbottomPage1.setAlignment(pphrase1.ALIGN_CENTER);
		Paragraph bbottomPage2 = new Paragraph(pphrase2);
		//bottomPage2.setAlignment(phrase2.ALIGN_CENTER);
		bbottomPage2.setAlignment(pphrase2.ALIGN_CENTER);
		
		
		
		ColumnText cct = new ColumnText(ccb2);
		cct.setSimpleColumn(rectrect);
		cct.addElement(new Paragraph(bbottomPage1));
		cct.addElement(bbottomPage2);
		cct.setSimpleColumn(rectrect);
		cct.go();
	
		
		
		
		
		
		
		/*Paragraph p9 = new Paragraph();
		//p9.setAlignment(p9.ALIGN_CENTER);
		p9.setAlignment(Element.ALIGN_BOTTOM);
		p9.setFont(new Font(FontFamily.HELVETICA, (float) 14));
		p9.add("This document shall not be disclosed or distributed outside of the ESP Team  without approval of the Program Manager.  \n");
		p9.setLeading(12,0);
		p9.setSpacingBefore(0);
		
		Paragraph p8 = new Paragraph();
		Image paragraphChunk = Image.getInstance("fdaInsignia.jpg");
		image3.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
		image3.scaleAbsolute(100, 100);
		c = new Chunk("– Procuremen Sensitive –\n", 0, 0, true);
		c = new Chunk();
		p8.setAlignment(p3.ALIGN_CENTER);
		p8.setSpacingBefore(50);
		p8.add(c);*/
		
		document.add(pp1);
		document.add(pp2);
		document.add(pp4);
		document.add(pp5);
		document.add(pp3);
		document.add(pp6);
		document.add(pp7);
		document.add(pp8);
		document.add(pp9);
		
		
		
		    /*PdfContentByte cb = writer.getDirectContent();
		 
	        PdfLayer dog = new PdfLayer("layer 1", writer);
	        PdfLayer tiger = new PdfLayer("layer 2", writer);
	        PdfLayer lion = new PdfLayer("layer 3", writer);
	        
	      
	        
	        PdfLayerMembership cat = new PdfLayerMembership(writer);
	        cat.addMember(tiger);
	        cat.addMember(lion);
	        PdfLayerMembership no_cat = new PdfLayerMembership(writer);
	        no_cat.addMember(tiger);
	        no_cat.addMember(lion);
	        no_cat.setVisibilityPolicy(PdfLayerMembership.ALLOFF);
	        cb.beginLayer(dog);
	        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("dog"),0, 0, 0);
	        cb.endLayer();
	        cb.beginLayer(tiger);
	        ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT, new Phrase("tiger"),
	                500, 750, 0);
	        cb.endLayer();
	        cb.beginLayer(lion);
	        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("lion"),
	                50, 725, 0);
	        cb.endLayer();
	        cb.beginLayer(cat);
	        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("cat"),
	                50, 700, 0);
	        cb.endLayer();
	        cb.beginLayer(no_cat);
	        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT,
	                new Phrase("no cat"), 50, 700, 0);
	        cb.endLayer();*/
		
		document.close();
		
	}

	public void actionPerformed(ActionEvent e) {
		
		
	}
}
