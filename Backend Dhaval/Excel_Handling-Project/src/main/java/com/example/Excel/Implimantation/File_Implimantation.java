package com.example.Excel.Implimantation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Excel.DTO.File_DTOO;
import com.example.Excel.Helper.File_DTO_Helper;
import com.example.Excel.Helper.MyExcel_Helper;
import com.example.Excel.Main_Entity.Main_Enitity;
import com.example.Excel.Repository.File_Repo;
import com.example.Excel.Service.File_Sevice;

@Component
public class File_Implimantation implements File_Sevice {

	@Autowired 
	private File_Repo fRepo;
	
	
	@Override
	public String SaveData(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			
			if(MyExcel_Helper.CheckFormat(file)) {
				
				List<Main_Enitity> convertExcet_To_List = MyExcel_Helper.ConvertExcet_To_List(file.getInputStream());
				
				final String path = new ClassPathResource("documents").getFile().getAbsolutePath();
				
				File f = new File(path);
				if(!f.exists()) 
				{
					f.mkdir();
				    
				}
				Files.copy(file.getInputStream(),Paths.get(path+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
				
			
//			List<File_DTOO> DTO_MAIN_DATA = MyExcel_Helper.ConvertExcet_To_List(file.getInputStream());
//			System.err.println("convertExcet_To_List............" + DTO_MAIN_DATA);
//			Main_Enitity main_Enitity = File_DTO_Helper.Convert_To_Dto(DTO_MAIN_DATA);
			
			
			this.fRepo.saveAll(convertExcet_To_List);
	
			
			}
			else {
				return "Please enter Excel Format";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "In Implimantation ";
		}
		return "Data Has been Saved....";
	}

	@Override
	public List<File_DTOO> GetData() {
		
		List<File_DTOO> dtosDtoos=new ArrayList<>();
		List<Main_Enitity> all = (List<Main_Enitity>) fRepo.findAll(); 
		for (Main_Enitity main_Enitity : all) {
			
			File_DTOO convert_TO_Entity = File_DTO_Helper.Convert_TO_Entity(main_Enitity);
			dtosDtoos.add(convert_TO_Entity);
		}
		
		
		return dtosDtoos;
	}

/*********************************************** EXCEPTION PRACTICE ***************************************************************************************/	
	
	public Integer Division(Integer a, Integer b) {
		Integer c=a/b;
		return c;
	}
/************************************** EXPORT EXCEL WITH DATABSE DATA *******************************************************************/
 public void genrateExcel(HttpServletResponse response) 
 {
	 List<Main_Enitity> allData = fRepo.findAll();
	 
	 HSSFWorkbook workbook =  new HSSFWorkbook();
	 HSSFSheet sheet = workbook.createSheet("data");
	 HSSFRow row = sheet.createRow(0);
	 
	 row.createCell(0).setCellValue("pId");
	 row.createCell(1).setCellValue("pName");
	 row.createCell(2).setCellValue("pPrice");
	 
	 int dataRowI = 1;
	 for (Main_Enitity main_Enitity : allData) {
		HSSFRow row2 = sheet.createRow(dataRowI);
		row2.createCell(0).setCellValue(main_Enitity.getPId());
		row2.createCell(1).setCellValue(main_Enitity.getPName());
		row2.createCell(2).setCellValue(main_Enitity.getPPrice());
		dataRowI++;
	 }
	 
	 try {
		ServletOutputStream outputStream = response.getOutputStream();
		
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 
	 
 }

/***************************************************DOWNLOAD ONLY FIELD EXCEL FROM LOCAL SYSTEM *************************************************************************************/
 
 public Resource Download_Excel_Format_From_DB() 
 {
	 Resource resource = new ClassPathResource("data.xlsx");
	 return resource;
 }
 
 
 
 
}






















