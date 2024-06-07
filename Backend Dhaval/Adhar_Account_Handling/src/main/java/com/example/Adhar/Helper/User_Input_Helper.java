package com.example.Adhar.Helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Adhar.Entity.User_Input_Data_ForAngular;
import com.example.Adhar.Repoo.User_Input_Repository;

@Component
public class User_Input_Helper {

	@Autowired
	private User_Input_Repository userRepo;
	
//	
/*************************************************************************************************************************************************/
	public static boolean Check_ExcelFormat(MultipartFile file) 
	{
		if(file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) 
		{
			return true;
		}
		return false;
	}
/************************************************* CONVERT EXCEL INTO LIST *************************************************************************************/	

	public static List<User_Input_Data_ForAngular> Excel_To_List_Converter(InputStream is)
	{
		List<User_Input_Data_ForAngular> mainData = new ArrayList<>();
		
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
			User_Input_Data_ForAngular adhar_data = new User_Input_Data_ForAngular();
			int cid=0;
			while (iterator2.hasNext()) {
				Cell cell = (Cell) iterator2.next();
				
				switch (cid) {
				case 0:
//					adhar_data.setAdhar_id((long)cell.getNumericCellValue());
					adhar_data.setIdLong((long)cell.getNumericCellValue());
					break;
				case 1:
					adhar_data.setUserName(cell.getStringCellValue());
					break;
				case 2:
					adhar_data.setCity(cell.getStringCellValue());
					break;					
				case 3:
					adhar_data.setDisplayPicture(cell.getStringCellValue());
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
	
	
	
	
}





