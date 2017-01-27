package br.com.tamagu.resvut42x.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tamagu.resvut42x.entidades.Filial;
import br.com.tamagu.resvut42x.repositorio.RepFilial;

/****************************************************************************/
// Classe Serviço Regras de negócio da Filial
// Desenvolvido por : Jedi 
// Criado em 21/01/2017 
/****************************************************************************/

@Service
public class SerFilial {

	/****************************************************************************/
	// Variaveis e Dependências
	/****************************************************************************/
	@Autowired
	RepFilial repFilial;

	/****************************************************************************/
	// Metodo para Validar e salvar
	/****************************************************************************/
	public void salvar(Filial filial) throws Exception {

		try {

			ajustaDados(filial);
			repFilial.save(filial);

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		}

	}

	/****************************************************************************/
	// Metodo para Validar e excluir
	/****************************************************************************/
	public void excluir(Filial filial) throws Exception {

		try {

			repFilial.delete(filial);

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		}

	}

	/****************************************************************************/
	// Metodo para Listar todos os registros
	/****************************************************************************/
	public List<Filial> ListarTodos() {

		return repFilial.findAll();

	}

	/****************************************************************************/
	//
	//
	// Metodos privados
	//
	//
	/****************************************************************************/

	/****************************************************************************/
	// Metodo para validar dados antes de salvar
	/****************************************************************************/
	private void ajustaDados(Filial filial) {

		// Seta null no cnpj quando estiver em branco para validação
		if (filial.getCnpj().isEmpty()) {

			filial.setCnpj(null);

		}

		// Seta null no cpf quando estiver em branco para validação
		if (filial.getCpf().isEmpty()) {

			filial.setCpf(null);

		}

	}

}
