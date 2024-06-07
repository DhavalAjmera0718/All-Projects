package com.practise.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.practise.Entity.p_Entity;
import com.practise.HELPER.Pdf_Helper;
import com.practise.Repository.p_Repo;

@RestController
public class Pdf_controller {

	@Autowired
	public p_Repo service;
	
	@GetMapping("/getPdf")
	 public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        //response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         

        List<p_Entity> all = service.findAll();
         
        Pdf_Helper exporter = new Pdf_Helper(all);
        exporter.export(response);
         
    }
}
