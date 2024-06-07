package com.example.Adhar.Implimantation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Adhar.DTO.Adhar_DTO;
import com.example.Adhar.Entity.Adhar_Entity;
import com.example.Adhar.Helper.Adhar_Helper;
import com.example.Adhar.Repoo.Adhar_Repoo;
import com.example.Adhar.Service.Adhar_Service;

@Component
public class Adhar_Implimantation implements Adhar_Service {

    @Autowired
    private Adhar_Repoo repoo;

    @Autowired
    private Adhar_Helper helper;

    public String SaveData(MultipartFile file) {
        try {
            List<Adhar_Entity> maid_Data = null;
            if (Adhar_Helper.Check_ExcelFormat(file)) {
                final String path = new ClassPathResource("").getFile().getAbsolutePath();
                System.err.println("Path----" + path);
                Files.copy(file.getInputStream(), Paths.get(path + File.separator + file.getOriginalFilename()),
                        StandardCopyOption.REPLACE_EXISTING);
                maid_Data = Adhar_Helper.Excel_To_List_Converter(file.getInputStream());
                this.repoo.saveAll(maid_Data);
            } else {
                helper.Multiple_Fileuploding(file);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Data Has Been Saved";
    }
/********************************************************************************************************************************************/
    @Override
    public List<Adhar_DTO> GetAllData() {
        List<Adhar_Entity> alldata = repoo.findAll();

        List<Adhar_DTO> dummAdhar_DTOs = new ArrayList<>();
        Adhar_DTO main_Dto_data = null;

        for (Adhar_Entity adhar_Entity : alldata) {
            main_Dto_data = Adhar_Helper.Convert_Entity_To_DTO(adhar_Entity);
            dummAdhar_DTOs.add(main_Dto_data);
        }
        return dummAdhar_DTOs;
    }
 /**************************************************** [Download All File ]******************************************************************************************/
    
 public Resource DownloadAnyFile(String filename) 
 {
	 Resource resource = new ClassPathResource("/documnets/" + filename);
	 System.err.println(resource);
	 return resource;
 }   
    
 /*****************************************************[ Download Excel Format ]*************************************************************************/
    
    
 public Resource downloadFormaExcelFormet() 
 {
	 Resource resource = new ClassPathResource("excelformat.xlsx");
	 System.err.println(resource);
	 return resource;
 }  
 
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
