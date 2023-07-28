package com.dscatalog.demo.dto;

import com.dscatalog.demo.entities.Role;

public class RoleDTO {
	
	private String authority;
	private Long id;

	public RoleDTO() {
		
	}
	
	public RoleDTO(String authority, Long id) {
		this.authority = authority;
		this.id = id;
	}
	
	public RoleDTO(Role entity) {
		this.authority = entity.getAuthority();
		this.id = entity.getId();
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
