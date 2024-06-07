package com.Admin.Service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.Admin.Proxi.FeeDetails_DTO;



@Service
public interface FeeDetailsServices {
	
	public String addFeeDetails(FeeDetails_DTO feeDetails_DTO) ;
	public List<FeeDetails_DTO> getFeeDetails();

}
