package com.example.Insurance.Helper;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Insurance.Enitity.MainEntity_Excel;

@Component
public class Excel_Helper {

	public static boolean CheckExcelFormat(MultipartFile file) 
	{
		//String contentType = file.getContentType();
		if(file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) 
		{
			return true;
		}
		return false;
	}
	
/******************************************************** CONVERT EXCEL INTO LIST **************************************************************************/

	public static List<MainEntity_Excel> ConvertExcel_To_List(InputStream is) throws UncheckedIOException
	{
		List<MainEntity_Excel> list = new ArrayList<>();
		try {
			
			
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			System.err.println("SHEET DATA--------------->>>>>>>>>>>>>>>>>>>>  " + sheet);
			
			int rowNumber=0;
			Iterator<Row> iterator = sheet.iterator();
			
			MainEntity_Excel mainData = new MainEntity_Excel();
			while (iterator.hasNext()) {
				Row row =  iterator.next();
				if(rowNumber==0) 
				{
					rowNumber++;
					continue;
				}

				 Iterator<Cell> iterator2 = row.iterator();
				 int cid=0;
				 
				 while (iterator2.hasNext()) {
					Cell cell = iterator2.next();
					switch (cid) {
					case 0:
						mainData.setId((long)cell.getNumericCellValue());						
						break;
					case 1:
						mainData.setName(cell.getStringCellValue());
						break;
					case 2 :
						mainData.setPrice((long)cell.getNumericCellValue());
						break;

					default:
						break;
					}
					cid++;
					
				}
				 list.add(mainData);
				 System.err.println("MAIN ENTITY DATA ------------->>>>>>>>>>>>>" + mainData);
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}




















