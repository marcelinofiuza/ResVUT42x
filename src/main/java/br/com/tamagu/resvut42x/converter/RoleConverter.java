package br.com.tamagu.resvut42x.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.tamagu.resvut42x.enums.Role;

@FacesConverter(value = "roleConverter") 
public class RoleConverter  implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		Role role = Role.valueOf(value);
		return role;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		Role role =  (Role)value;
		return role.toString();
	}

}
