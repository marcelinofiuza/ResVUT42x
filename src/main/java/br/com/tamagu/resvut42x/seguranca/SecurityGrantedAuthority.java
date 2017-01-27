package br.com.tamagu.resvut42x.seguranca;

import org.springframework.security.core.GrantedAuthority;

public class SecurityGrantedAuthority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return role;
	}

}
