package com.example.Insurance.Helper;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.PublicKey;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload_Helper  {
	
 //public final String uPLOAD_DIR = "C:\\Users\\DhavalAjmera\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\InsuranceDBMS\\src\\main\\resources\\static\\image";
	
	public final String uPLOAD_DIR = new ClassPathResource("image").getFile().getAbsolutePath();
	
	public FileUpload_Helper() throws IOException
	{
		
	}
//public boolean UploadFile(MultipartFile multipartFile) throws UncheckedIOException
//
//	{
//		boolean image1 = false;
//		try 
//		{
//			/*InputStream inputStream = multipartFile.getInputStream();
//			//Create Byte Type of Array to get(READ) Image from Upper path
//			byte data[]=new byte[inputStream.available()];
//			inputStream.read(data);
//			
//			FileOutputStream DataFromApi= new FileOutputStream(uPLOAD_DIR+"\\" + multipartFile.getOriginalFilename());
//			DataFromApi.write(data);
//			DataFromApi.flush();
//			DataFromApi.close();
//			image1=true;
//			*/
//			Files.copy(multipartFile.getInputStream(),
//					Paths.get(uPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//			
//			image1=true;
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return image1;
//	}
//}
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
				Paths.get(uPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		
		return uPLOAD_DIR+File.separator+multipartFile.getOriginalFilename();
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return "";
		}
	 }
/*************************************************************READ DATA************************************************************************/	
public byte[] readFile(String filePath) {
    try {
        Path path = Paths.get(filePath);
        System.err.println(path);
        return Files.readAllBytes(path);
    } catch (IOException e) {
        e.printStackTrace();
        return new byte[0];
    }
}

}

