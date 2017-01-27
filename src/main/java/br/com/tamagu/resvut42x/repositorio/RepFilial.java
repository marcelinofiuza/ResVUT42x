package br.com.tamagu.resvut42x.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tamagu.resvut42x.entidades.Filial;

/****************************************************************************/
// Classe Repositório da entidade Filial
// Desenvolvido por : Jedi 
// Criado em 21/01/2017 
/****************************************************************************/

@Repository
public interface RepFilial extends JpaRepository<Filial,Long>{

}
