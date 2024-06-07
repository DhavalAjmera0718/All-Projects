package com.example.Demat_Helper_Class;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartFile;

import com.example.Demat.Entity.Demat_MainEntity;

@RestControllerAdvice
public class Demat_Helper {

	public static boolean ContentType_Excel(MultipartFile file) 
	{
		String content = file.getContentType();
		if(content.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) 
		{
			return true;
		}
		return false;
	}
	

/**************************************************** CONVERT EXCEL TO LIST ******************************************************************************************/

	public static List<Demat_MainEntity> convert_Excel_To_List(InputStream is)
	{
		List<Demat_MainEntity> list = new ArrayList<>();
		try {
		XSSFWorkbook workbook = new XSSFWorkbook(is);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		Iterator<Row> iterator = sheet.iterator();
		int rowNumber = 0;
		
		
		while (iterator.hasNext()) {
			Row row = (Row) iterator.next();
			
			if(rowNumber==0) 
			{
				rowNumber++;
				continue;
			}
			Iterator<Cell> iterator2 = row.iterator();
			int cid = 0;
			Demat_MainEntity mainData = new Demat_MainEntity();
			while (iterator2.hasNext()) {
				Cell cell = (Cell) iterator2.next();
				switch (cid) {
				case 0:
					mainData.setDid((long)cell.getNumericCellValue());
					break;
				case 1:
					mainData.setName(cell.getStringCellValue());
					break;
				case 2:
					mainData.setSprice((long)cell.getNumericCellValue());
					break;					
				default:
					break;
				}
				cid++;
			}
			list.add(mainData);
			System.err.println("------------->>>>>>>>>>" + mainData);
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}


}
