package br.com.tamagu.resvut42x.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tamagu.resvut42x.entidades.Usuario;

/****************************************************************************/
// Classe Repositório da entidade Usuário
// Desenvolvido por : Jedi 
// Criado em 21/01/2017 
/****************************************************************************/

@Repository
public interface RepUsuario extends JpaRepository<Usuario, Long> {

	/****************************************************************************/
	// Metodo para retornar pela credencial
	/****************************************************************************/
	public Usuario findByCredencial(String credencial);

}
