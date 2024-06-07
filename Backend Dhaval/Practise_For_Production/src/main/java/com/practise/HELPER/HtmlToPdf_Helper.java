package com.practise.HELPER;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

@Component
public class HtmlToPdf_Helper {

	private static String SAVE_FINAL_FILE_PATH =  "../Practise_For_Production/src/main/resources/templates";
	

	
	public static void generateHtmlToPdf(MultipartFile html, File file) throws IOException {
//		 Document doc = createWellFormedHtml(html);
//		 System.err.println("DOC"+doc);
//		xhtmlToPdf(html, file);
		System.err.println("aaaa");
		 try (InputStream inputStream = html.getInputStream();
	             OutputStream outputStream = new FileOutputStream(file)) {
			 System.err.println("bbbbb");

	            String htmlContent = new String(inputStream.readAllBytes());
	            System.err.println("htmlContent ------>|" + htmlContent);
	            
	            Document document = Jsoup.parse(htmlContent);
//	            System.err.println("Convert  to documnt ---->" + document);
	            PdfRendererBuilder builder = new PdfRendererBuilder();
	            builder.withFile(file);
	            builder.toStream(outputStream);
	            PdfRendererBuilder withHtmlContent = builder.withHtmlContent(document.outerHtml(),"");
	            System.err.println("*******"+withHtmlContent);
	            builder.run();
	            
	        }

//
//		FileWriter fWriter = null;
//		BufferedWriter writer = null;
//		try {
//			fWriter = new FileWriter(SAVE_FINAL_FILE_PATH);
//			writer = new BufferedWriter(fWriter);
//			writer.write(doc.html());
//			writer.newLine(); //this is not actually needed for html files - can make your code more readable though
//			writer.close();
//		} catch (Exception e) {
//			//catch any exceptions here
//		}
	}
	
//	private static Document createWellFormedHtml(MultipartFile inputHTML) {
//		Document document = Jsoup.parse(inputHTML, "UTF-8");
//		return document;
//	}
//	private static void xhtmlToPdf(MultipartFile doc, File file) throws IOException {
//		try (OutputStream os = new FileOutputStream(file)) {
//			PdfRendererBuilder builder = new PdfRendererBuilder();
//			builder.withFile(file);
//			builder.toStream(os);
//			builder.withW3cDocument(new W3CDom().fromJsoup(doc), file.toURI().getPath());
//			builder.run();
//		}
//	}
	
}
