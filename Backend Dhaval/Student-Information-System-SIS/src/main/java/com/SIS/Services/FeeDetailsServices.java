package com.SIS.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SIS.Proxies.FeeDetails_DTO;

@Service
public interface FeeDetailsServices {
	
	public String addFeeDetails(FeeDetails_DTO feeDetails_DTO) ;
	public List<FeeDetails_DTO> getFeeDetails();

}
