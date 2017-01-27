package br.com.tamagu.resvut42x.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.tamagu.resvut42x.entidades.Usuario;
import br.com.tamagu.resvut42x.entidades.UsuarioRoles;
import br.com.tamagu.resvut42x.servico.SerUsuario;

@Component
public class SecurityUserService implements UserDetailsService {

	@Autowired
	SerUsuario serUsuario;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		Usuario usuario = serUsuario.buscarPorCredencial(username);

		if (usuario != null) {

			SecurityUserDetails userDetails = new SecurityUserDetails();
			userDetails.setUsername(usuario.getCredencial());
			userDetails.setPassword(usuario.getSenha());
			userDetails.setContaBloqueada(usuario.isBloqueado());

			for (UsuarioRoles usuarioRole : usuario.getRoles()) {
				userDetails.addAuthorities("ROLE_"+usuarioRole.getRole().toString());
			}

			return userDetails;
			
		}
		
		throw new UsernameNotFoundException("Usuário não cadastrado");

	}

}
