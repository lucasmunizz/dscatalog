package com.dscatalog.demo.dto;

import com.dscatalog.demo.services.validation.UserInsertValid;

@UserInsertValid
public class UserUpdateDTO extends UserDTO {

	private static final long serialVersionUID = 1L;
	
	private String password;
	
	public UserUpdateDTO() {
		super();
	}
	
	public UserUpdateDTO(String password) {
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
