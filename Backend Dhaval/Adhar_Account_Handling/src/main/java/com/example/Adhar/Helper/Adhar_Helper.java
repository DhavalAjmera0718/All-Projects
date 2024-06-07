package com.example.Adhar.Helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Adhar.DTO.Adhar_DTO;
import com.example.Adhar.Entity.Adhar_Entity;
import com.example.Adhar.Repoo.Adhar_Repoo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Adhar_Helper {
	
	@Autowired
	private Adhar_Repoo repo;
	
	public static Adhar_Entity Convert_DTO_To_Entity (Adhar_DTO dtos) 
	{
		ObjectMapper objectMapper =  new ObjectMapper();
		return objectMapper.convertValue(dtos, Adhar_Entity.class);
	}
	
	public static Adhar_DTO Convert_Entity_To_DTO (Adhar_Entity entity) 
	{
		ObjectMapper objectMapper =  new ObjectMapper();
		return objectMapper.convertValue(entity, Adhar_DTO.class);
	}
	/*********************************************************************************************************************************/
	
	public static boolean Check_ExcelFormat(MultipartFile file) 
	{
		if(file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) 
		{
			return true;
		}
		return false;
	}
/************************************************* CONVERT EXCEL INTO LIST *************************************************************************************/	

	public static List<Adhar_Entity> Excel_To_List_Converter(InputStream is)
	{
		List<Adhar_Entity> mainData = new ArrayList<>();
		
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(is);
		
		XSSFSheet  sheet = workbook.getSheet("Sheet1");
		
		Iterator<Row> iterator = sheet.iterator();
		System.err.println("SHEET ITERATOR--------------" + iterator);
		
		int rowCount=0;
		while (iterator.hasNext()) {
			Row row = (Row) iterator.next();
			
			if(rowCount==0) 
			{
				rowCount++;
				continue;
			}
			Iterator<Cell> iterator2 = row.iterator();
			Adhar_Entity adhar_data = new Adhar_Entity();
			int cid=0;
			while (iterator2.hasNext()) {
				Cell cell = (Cell) iterator2.next();
				
				switch (cid) {
				case 0:
					adhar_data.setAdhar_id((long)cell.getNumericCellValue());
					break;
				case 1:
					adhar_data.setAdhar_Name(cell.getStringCellValue());
					break;
				case 2:
					adhar_data.setAdhar_Number(cell.getStringCellValue());
					break;
				default:
					break;
				}
				cid++;	
			}
			mainData.add(adhar_data);
			System.err.println("MainData in Helper class ---------" + adhar_data);
		}
		
	} 		catch (IOException e) 
			{
				e.printStackTrace();
			}
		return mainData;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/********************************************************SAVE MULTIPLE FILE **************************************************************************/	

	public  Adhar_Entity Multiple_Fileuploding(MultipartFile file) 
	{
		
		System.err.println("111");
		try {
			final String path = new ClassPathResource("/documnets").getFile().getAbsolutePath();
		
			File f = new File(path);
			if(!f.exists()) 
			{
				System.err.println("22222");
				f.mkdir();
			    
			}
		System.err.println(path);
		 
/*********************************************************** 2 *******************************************************************/	 
		 String originalName = file.getOriginalFilename();
		 
		 Long convertIntoMb = file.getSize();
		 float fileSizeInMb =  convertIntoMb/(1024*1024);
		 System.err.println("FILE SIZE In MB----------" + fileSizeInMb);
		 
		 String uniqueId = UUID.randomUUID().toString();
		 
		 String FinalName = uniqueId.concat(originalName.substring(originalName.lastIndexOf(".")));
		
/************************************************************* 3 *****************************************************************/		 		 
		 Adhar_Entity mainData = new Adhar_Entity(0l,FinalName,file.getContentType());
		 repo.save(mainData);
		 System.err.println("Main DATA in helper Class MUlti Uploading---------" + mainData);
		 
		 String fullpath = f.getAbsolutePath()+File.separator+FinalName;
		 
//			Files.copy(file.getInputStream(), Paths.get(path+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING) ;
			Files.copy(file.getInputStream(), Path.of(fullpath),StandardCopyOption.REPLACE_EXISTING);
		}
		  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
		}
	
}
