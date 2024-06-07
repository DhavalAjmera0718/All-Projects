package com.example.Insurance.Enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Entity_Insurance {

	@Id
	private Long clientAccNo;
	private String clientName;
	private String clientGender;
	private String clientMobileNo;
	private String clientAddress;
	private String clientAccType;  
	private String clinetBankName;
	public Entity_Insurance() {
		super();
	}
	public Entity_Insurance(Long clientAccNo, String clientName, String clientGender, String clientMobileNo,
			String clientAddress, String clientAccType, String clinetBankName) {
		super();
		this.clientAccNo = clientAccNo;
		this.clientName = clientName;
		this.clientGender = clientGender;
		this.clientMobileNo = clientMobileNo;
		this.clientAddress = clientAddress;
		this.clientAccType = clientAccType;
		this.clinetBankName = clinetBankName;
	}
	public Long getClientAccNo() {
		return clientAccNo;
	}
	public void setClientAccNo(Long clientAccNo) {
		this.clientAccNo = clientAccNo;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientGender() {
		return clientGender;
	}
	public void setClientGender(String clientGender) {
		this.clientGender = clientGender;
	}
	public String getClientMobileNo() {
		return clientMobileNo;
	}
	public void setClientMobileNo(String clientMobileNo) {
		this.clientMobileNo = clientMobileNo;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public String getClientAccType() {
		return clientAccType;
	}
	public void setClientAccType(String clientAccType) {
		this.clientAccType = clientAccType;
	}
	public String getClinetBankName() {
		return clinetBankName;
	}
	public void setClinetBankName(String clinetBankName) {
		this.clinetBankName = clinetBankName;
	}
	@Override
	public String toString() {
		return "Entity_Insurance [clientAccNo=" + clientAccNo + ", clientName=" + clientName + ", clientGender="
				+ clientGender + ", clientMobileNo=" + clientMobileNo + ", clientAddress=" + clientAddress
				+ ", clientAccType=" + clientAccType + ", clinetBankName=" + clinetBankName + "]";
	}
	
	
	
}
