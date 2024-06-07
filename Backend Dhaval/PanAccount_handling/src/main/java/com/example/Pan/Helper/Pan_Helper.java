package com.example.Pan.Helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Pan.Enitity.Pan_Entity;

@Component
public class Pan_Helper {

	
	public static boolean Check_ExcelFormat(MultipartFile file) 
	{
		if(file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) 
		{
			return true;
		}
		return false;
	}
/************************************************* CONVERT EXCEL INTO LIST *************************************************************************************/	

	public static List<Pan_Entity> Excel_To_List_Converter(InputStream is)
	{
		List<Pan_Entity> mainData = new ArrayList<>();
		
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(is);
		
		XSSFSheet  sheet = workbook.getSheet("pan");
		
		Iterator<Row> iterator = sheet.iterator();
		
		int rowCount=0;
		while (iterator.hasNext()) {
			Row row = (Row) iterator.next();
			
			if(rowCount==0) 
			{
				rowCount++;
				continue;
			}
			Iterator<Cell> iterator2 = row.iterator();
			Pan_Entity pan_data = new Pan_Entity();
			int cid=0;
			while (iterator2.hasNext()) {
				Cell cell = (Cell) iterator2.next();
				
				switch (cid) {
				case 0:
					pan_data.setPan_Id((long)cell.getNumericCellValue());
					break;
				case 1:
					pan_data.setPan_Name(cell.getStringCellValue());
					break;
				case 2:
					pan_data.setPan_Number(cell.getStringCellValue());
					break;
				default:
					break;
				}
				cid++;	
			}
			mainData.add(pan_data);
			System.err.println("MainData---------" + pan_data);
		}
		
	} 		catch (IOException e) 
			{
				e.printStackTrace();
			}
		return mainData;
		
	}
	

}
