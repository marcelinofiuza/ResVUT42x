package br.com.tamagu.resvut42x.servico;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tamagu.resvut42x.entidades.Usuario;
import br.com.tamagu.resvut42x.entidades.UsuarioRoles;
import br.com.tamagu.resvut42x.enums.Role;

@RunWith(SpringRunner.class)
@WebMvcTest(SerUsuario.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestSerUsuario {

	@Autowired
	SerUsuario serUsuario;

	@Test
	public void salvarUsuario() {

		Usuario usuario = new Usuario();
		Set<UsuarioRoles> roles = new HashSet<UsuarioRoles>();

		usuario.setCredencial("tamagu");
		usuario.setSenha("bobodin");
		usuario.setNome("Resposta para vida o universo e tudo mais");
		usuario.setBloqueado(false);

		UsuarioRoles role = new UsuarioRoles();
		role.setRole(Role.ADMIN);
		role.setUsuario(usuario);
		roles.add(role);

		try {
			serUsuario.salvar(usuario);
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}

	}

}
