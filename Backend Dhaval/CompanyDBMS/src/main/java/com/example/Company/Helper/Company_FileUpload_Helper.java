	package com.example.Company.Helper;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Company_FileUpload_Helper {

	public final String UPLOAD_DOC =new ClassPathResource("static/image").getFile().getAbsolutePath();
	//public final String UPLOAD_DOC="C:\\Users\\DhavalAjmera\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\CompanyDBMS\\src\\main\\resources\\static\\image";	
	public Company_FileUpload_Helper() throws IOException 
	{
		
	}
	public String UploadFile(MultipartFile multipartFile) throws UncheckedIOException

	{
		
		try 
		{
			/*InputStream inputStream = multipartFile.getInputStream();
			//Create Byte Type of Array to get(READ) Image from Upper path
			byte data[]=new byte[inputStream.available()];
			inputStream.read(data);
			
			FileOutputStream DataFromApi= new FileOutputStream(uPLOAD_DIR+"\\" + multipartFile.getOriginalFilename());
			DataFromApi.write(data);
			DataFromApi.flush();
			DataFromApi.close();
			image1=true;
			*/
			Files.copy(multipartFile.getInputStream(),
					Paths.get(UPLOAD_DOC+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			return UPLOAD_DOC+File.separator+multipartFile.getOriginalFilename();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "";
		}
			}
/*************************************************** HELPER FOR READ FILR FROM POSTMEN***********************************************************************************/	
	public byte[] readFile(String filepath) 
	{
		try {
			Path path = Paths.get(filepath);
			return Files.readAllBytes(path);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new byte[0]; 
		}
	}
	
	
}
