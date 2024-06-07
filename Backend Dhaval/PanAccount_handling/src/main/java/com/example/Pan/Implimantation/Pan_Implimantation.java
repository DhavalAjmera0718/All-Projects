package com.example.Pan.Implimantation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Pan.Enitity.Pan_Entity;
import com.example.Pan.Helper.Pan_Helper;
import com.example.Pan.Repoo.Pan_Repoo;
import com.example.Pan.Service.Pan_Service;

@Component
public class Pan_Implimantation  implements Pan_Service{
	
	@Autowired
	private Pan_Repoo repo;

/**************************************************** FOR DOWNLOAD BLANK EXCEL FROM LOACL MACHINE ***********************************************************************************/		
	public Resource Get_Blank_Excel() 
	{
		Resource resource = new ClassPathResource("pan.xlsx");
		return resource;
	}
/**************************************************** UPLOAD THAT BLANK EXCEL WITH NEW DATA ***********************************************************************************/	
	

	public String Upload_Excel(MultipartFile file) 
	{
		
		try {
			if(Pan_Helper.Check_ExcelFormat(file)) {
			
			List<Pan_Entity> check_ExcelFormat = Pan_Helper.Excel_To_List_Converter(file.getInputStream());
			this.repo.saveAll(check_ExcelFormat);
			}
			else {
				return"Please Enter Only Excel Format";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "Exception in Implimentation";
		}
		return "File Has Been Saved........";
	}
	
/**************************************************** DOWNLOAD EXCEL FROM DATABSE***********************************************************************************/	
	
	public void Download_Excel(HttpServletResponse response) 
	{
		List<Pan_Entity> main_Entitity = repo.findAll();
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		
		/*********** ONLY FOR HEADINGS	************************/
		XSSFRow row = sheet.createRow(0);
		
		row.createCell(0).setCellValue("Pan_ID");
		row.createCell(1).setCellValue("Pan_NAME");
		row.createCell(3).setCellValue("Pan_Number");
		/*********** FOR ITERATE DATA HEADINGS	************************/
		int dataRow=1;
		for(Pan_Entity entity:main_Entitity) 
		{
			XSSFRow row2 = sheet.createRow(dataRow);
			row2.createCell(0).setCellValue(entity.getPan_Id());
			row2.createCell(1).setCellValue(entity.getPan_Name());
			row2.createCell(2).setCellValue(entity.getPan_Number());
			dataRow++;
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
/*************************************************** GET ALL DATA IN JSON**************************************************************************************/		
	public List<Pan_Entity>	GetAllData()
	{
		List<Pan_Entity> allData = repo.findAll();
		return allData;
	}
/*************************************************** GET DATA BY ID IN JSON**************************************************************************************/		
			
	public List<Pan_Entity> Get_DataBY_Id(Long id)
	{
		Pan_Entity pan_Entity = repo.findById(id).get();
		
		List<Pan_Entity> dummyList =  new ArrayList<>();
		
		Pan_Entity mainEntity =  new Pan_Entity(pan_Entity.getPan_Id(), pan_Entity.getPan_Name(), pan_Entity.getPan_Number());
		dummyList.add(mainEntity);
		return dummyList;
	}
/******************************************************* ADD MULTIPLE EXCEL INTO ZIP***********************************************************************************************************/	
	
//	public Pan_Entity Save_In_Zip(MultipartFile file) 
//	{
//		try {
//			final String path = new ClassPathResource("").getFile().getAbsolutePath();
//		
//		
//		File f = new File(path, "pan");
//		if(!f.exists()) 
//		{
//			f.mkdir();
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}



























