package com.cursos.api.springsecuritycourse.persistence.util;

import java.util.Arrays;

public enum Role {
	 //ROL CON SISTEMA DE PERMISOS
	ROLE_ADMINISTRATOR(Arrays.asList(
			RolePermission.READ_ALL_PRODUCTS,
			RolePermission.READ_ONE_PRODUCT,
			RolePermission.CREATE_ONE_PRODUCT,
			RolePermission.UPDATE_ONE_PRODUCT,
			RolePermission.DISABLE_ONE_PRODUCT,
			
			RolePermission.READ_ALL_CATEGORIES,
			RolePermission.READ_ONE_CATEGORY,
			RolePermission.CREATE_ONE_CATEGORY,
			RolePermission.UPDATE_ONE_CATEGORY,
			RolePermission.DISABLE_ONE_CATEGORY,
			
			RolePermission.READ_MY_PROFILE
			)),
	ROLE_ASSISTANT_ADMINISTRATOR(Arrays.asList(
			RolePermission.READ_ALL_PRODUCTS,
			RolePermission.READ_ONE_PRODUCT,
			RolePermission.UPDATE_ONE_PRODUCT,
			
			RolePermission.READ_ALL_CATEGORIES,
			RolePermission.READ_ONE_CATEGORY,
			RolePermission.UPDATE_ONE_CATEGORY,
			
			RolePermission.READ_MY_PROFILE
			)),
	
	ROLE_CUSTOMER (Arrays.asList(
			RolePermission.READ_MY_PROFILE
			));

	
	private java.util.List<RolePermission> permissions;

	//CONSTRUCTOR
	Role(java.util.List<RolePermission> permissions) {
		this.permissions = permissions;
	}

	//GETTER AND SETTER
	public java.util.List<RolePermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(java.util.List<RolePermission> permissions) {
		this.permissions = permissions;
	}	
	
	
}
