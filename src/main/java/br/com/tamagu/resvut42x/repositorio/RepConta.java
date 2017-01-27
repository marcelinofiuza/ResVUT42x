package br.com.tamagu.resvut42x.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tamagu.resvut42x.entidades.Conta;

/****************************************************************************/
// Classe Repositório da entidade Conta
// Desenvolvido por : Jedi 
// Criado em 21/01/2017 
/****************************************************************************/

@Repository
public interface RepConta extends JpaRepository<Conta, Long> {

	/****************************************************************************/
	// Metodo para retornar a lista de contas Raiz 
	/****************************************************************************/	
	@Query("Select c from Conta c where c.contaPai is null")
	public List<Conta> buscarContaRaiz();
	
}
