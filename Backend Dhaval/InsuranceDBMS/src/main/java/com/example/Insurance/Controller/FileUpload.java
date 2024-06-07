package com.example.Insurance.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Insurance.Enitity.Upload_EntitityMain;
import com.example.Insurance.Helper.FileUpload_Helper;
import com.example.Insurance.Repository.Image_Repo;
import com.example.Insurance.Services.Service_Insurance;

@RestController
public class FileUpload {
	
	@Autowired
	private FileUpload_Helper upload;
	
	@Autowired
	private Service_Insurance serve;
	@Autowired
	private Image_Repo image_Repo;

//	@PostMapping("/Upload")
//	public ResponseEntity<String> Upload(@RequestParam("image") MultipartFile image)
//	{
//		System.err.println(image.getOriginalFilename());
//		System.err.println(image.getSize());
//		System.err.println(image.getContentType());
//		System.err.println(image.getName());
//		System.err.println(image.isEmpty());
//		
///**********************************************************  VALIDATION  *********************************************************/		
//		try {
//		if(image.isEmpty()) 
//		{
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain File");
//		}
//		if(!image.getContentType().equals("image/jpeg")) 
//		{
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Enter Only png Format");
//		}
//		//Now File Upload Code
//		
//		String uploadFile = upload.UploadFile(image);
//		System.err.println(uploadFile);
//		if (uploadFile!=null) {
//			//return ResponseEntity.ok("File is Uploaded");
//			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(image.getOriginalFilename()).toUriString());
//		}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong Please Wait");
//	}
/****************************************************FETCH IMAGE INTO DATA BASE ********************************************************************************/
	@PostMapping("/Upload_Image")
	public ResponseEntity<String> Upload_Image(@RequestParam("image") MultipartFile file) 
	{
		return new ResponseEntity<String>(serve.Upload_Image(file),HttpStatus.ACCEPTED);
		
		//return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
	}
/**************************************************** READ FILE DATA ******************************************************************************************/	
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id)
	{
		Optional<Upload_EntitityMain> byId = image_Repo.findById(id);
		if(byId.isPresent()) 
		{
			Upload_EntitityMain mainData= byId.get();
			System.err.println(mainData);
			System.err.println(mainData.getImage());
			byte[] content =   upload.readFile(mainData.getImage());
			MediaType mediaType = MediaType.valueOf(mainData.getType());
			String contentDisposition = 
			"xyz filename=\"" + mainData.getName() + "\"" 
			+ "fileSize=\"" + mainData.getSize() + "\""
			+"fileType=\"" + mainData.getType()
			+ "\""+"filepath=\"" + mainData.getPath() + "\"";
			
			return ResponseEntity.ok()
					.contentType(mediaType)
					.header("contentDisposition",contentDisposition)
					.body(content);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
