package com.example.Excel.Helper;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.binary.XSSFBCommentsTable;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Excel.DTO.File_DTOO;
import com.example.Excel.Main_Entity.Main_Enitity;

@Component
public class MyExcel_Helper {

	/************************Check That File is Excel or not*********************/
	public static boolean CheckFormat(MultipartFile file) {
		String conteType = file.getContentType();
		if(conteType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}
		else {
			return false;
		}
	}
	/************************************CONVERT EXCEL LIST OF PRODUCT*****************************************/
	//@SuppressWarnings("resource")
	public static List<Main_Enitity> ConvertExcet_To_List(InputStream is)
	{
		List<Main_Enitity> list = new ArrayList<>();
		try {

			
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet = workbook.getSheet("data");
			System.err.println("IS-------------->>>>>>>>>" + sheet);
			/*for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			    System.err.println("Sheet Name: " + workbook.getSheetName(i));
			}*/

			int rowNumber=0;
			Iterator<Row> iterator = sheet.iterator();
			
			int flag=1;
			while(iterator.hasNext()) 
			{
				flag++;
				
				Row row = iterator.next();
				
				if(rowNumber==0) 
				{
					rowNumber++;
					continue;
				}
				Iterator<Cell> iterator2 = row.iterator();
				int cid=0;
				Main_Enitity objMain = new Main_Enitity(); 
				while(iterator2.hasNext()) 
				{
					Cell cell = iterator2.next();
					switch(cid) 
					{
					case 0:
						objMain.setPId((long)cell.getNumericCellValue());
						break;
					case 1:
						objMain.setPName(cell.getStringCellValue());
						break;
					case 2:
						objMain.setPPrice((long)cell.getNumericCellValue());
						break;
					default:
						break;
					}
					cid++;
				}
				
				list.add(objMain);
				System.err.println("OBJ_MAIN------------->>>>>>>>>>>>>>" + objMain);
				
			}
			//is.close();
			System.err.println("Total ROW Number-------" + flag);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
}
