package com.practise.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.practise.HELPER.HtmlToPdf_Helper;

@RestController
public class HtmlToPdf {


	@Autowired
	private HtmlToPdf_Helper htmlToPdfHelper;
	public static String PDF_FILE_PATH = "../Practise_For_Production/src/main/resources/templates/converter.pdf";
	
	@PostMapping("/htmlToPdf")
//	public ResponseEntity<?> pdfConverter(@RequestBody String html) {
	public ResponseEntity<?> pdfConverter(@RequestParam("file") MultipartFile html) {
		System.err.println(html);
		System.err.println("111");
		
	try {
		System.err.println("22222");
	        File pdfDocumentPath = new File(PDF_FILE_PATH);
	        System.err.println("PDF DOC PATH -------->| " + pdfDocumentPath);
	        HtmlToPdf_Helper.generateHtmlToPdf(html, pdfDocumentPath);
	        byte[] pdfBytes = Files.readAllBytes(pdfDocumentPath.toPath());
//	        byte[] encode = Base64.getEncoder().encode(pdfBytes);
//	        System.err.println(encode);
//
//	        if (pdfBytes != null) {
//	            String base64EncodedPDF = Base64.getEncoder().encodeToString(pdfBytes);
//	            return ResponseEntity.ok().body(base64EncodedPDF);
//	        } else {
//	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to generate PDF");
//	        }
//	      
	        System.err.println("bytes"+pdfBytes);
	        if (pdfBytes != null) {
                FileSystemResource file = new FileSystemResource(pdfDocumentPath);
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=generated_pdf.pdf");

                return ResponseEntity.ok()
                        .headers(headers)
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(file);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to generate PDF");
            }
	    } catch (IOException e) {
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to convert HTML to PDF");
	    	e.printStackTrace();
	    	return null;
	    }
	}
	
	

}
