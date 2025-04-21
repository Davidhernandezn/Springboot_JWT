package com.cursos.api.springsecuritycourse.persistence.entity;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cursos.api.springsecuritycourse.persistence.util.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"user\"") //Para agregar nombre a la tabla \"user  es palabra reservada en varias bd
public class User implements UserDetails {
	//DEBE IMPLEMENTAR INTERFACE USER DETAILS 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	private String name;
	
	private String password;
	
	//ROL CON ENUM
	@Enumerated(EnumType.STRING)
	private Role role;

	//METODOS DEL IMPLEMENT
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		// PERMISOS DEL ROL convertirlo en collection de objetos que implementen grandted autotorities solo obtiene el permiso
		
		if (role == null) return null;
		
		if (role.getPermissions() == null) return null;
		
		/*obtine permisos y convertir a stream de datos, se mapea a los objetos ganted autorities
		 * */
		return role.getPermissions().stream()
			.map(each -> each.name())
			.map(each -> new SimpleGrantedAuthority(each))
			.collect(Collectors.toList());		
	}

	@Override
	public String getPassword() {
		// DEVUELVE CONTRASEÑA
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	//getter and setter de rol
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
