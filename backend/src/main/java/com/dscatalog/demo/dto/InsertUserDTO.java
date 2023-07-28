package com.dscatalog.demo.dto;

public class InsertUserDTO extends UserDTO {

	private static final long serialVersionUID = 1L;
	
	private String password;
	
	public InsertUserDTO() {
		super();
	}
	
	public InsertUserDTO(String password) {
		super();
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
