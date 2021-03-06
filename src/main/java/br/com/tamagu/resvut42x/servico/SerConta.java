package br.com.tamagu.resvut42x.servico;

import java.util.List;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tamagu.resvut42x.entidades.Conta;
import br.com.tamagu.resvut42x.enums.Natureza;
import br.com.tamagu.resvut42x.enums.Status;
import br.com.tamagu.resvut42x.enums.TipoConta;
import br.com.tamagu.resvut42x.repositorio.RepConta;

/****************************************************************************/
// Classe Serviço Regras de negócio da Conta Contábil
// Desenvolvido por : Jedi 
// Criado em 21/01/2017 
/****************************************************************************/

@Service
public class SerConta {

	/****************************************************************************/
	// Variaveis e Dependências
	/****************************************************************************/
	@Autowired
	RepConta repConta;

	private TreeNode raiz;

	/****************************************************************************/
	// Metodo para Validar e salvar
	/****************************************************************************/
	public void Salvar(Conta conta) throws Exception {

		try {

			// Se está inserindoo nova conta
			// adiciona a conta, como conta filho
			// processo bidirecional
			if (conta.getIdConta() == null) {
				conta.getContaPai().getSubConta().add(conta);
				conta.setChave(conta.getContaPai().getSubConta().size());
			}

			repConta.save(conta);

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		}

	}

	/****************************************************************************/
	// Metodo para Validar e Excluir
	/****************************************************************************/
	public void Excluir(Conta conta) throws Exception {

		try {

			repConta.delete(conta);

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		}

	}

	/****************************************************************************/
	// Metodo para Montar e Arvore e Listar os dados
	/****************************************************************************/
	public TreeNode ListarTodos() {

		List<Conta> listaConta = repConta.buscarContaRaiz();

		// se não tem nenhuma conta cadastrada, gerar as 4 contas raizes
		if (listaConta.isEmpty()) {

			criarContaRaiz(listaConta);
			repConta.save(listaConta);
			listaConta = repConta.buscarContaRaiz();

		}

		// Montar TreeNode
		criarTreeNode(listaConta);

		return raiz;

	}

	/****************************************************************************/
	//
	//
	// Metodos privados
	//
	//
	/****************************************************************************/

	/****************************************************************************/
	// Metodo Para criar as contas Raizes caso não tenha
	/****************************************************************************/
	private void criarContaRaiz(List<Conta> listaConta) {

		Conta conta = new Conta();
		conta.setChave(1);
		conta.setDescricao("ATIVO");
		conta.setTipoConta(TipoConta.SINTETICA);
		conta.setStatus(Status.ATIVA);
		conta.setNatureza(Natureza.ATIVO);
		conta.setContaPai(null);
		listaConta.add(conta);

		conta = new Conta();
		conta.setChave(2);
		conta.setDescricao("PASSIVO");
		conta.setTipoConta(TipoConta.SINTETICA);
		conta.setStatus(Status.ATIVA);
		conta.setNatureza(Natureza.PASSIVO);
		conta.setContaPai(null);
		listaConta.add(conta);

		conta = new Conta();
		conta.setChave(3);
		conta.setDescricao("DESPESAS");
		conta.setTipoConta(TipoConta.SINTETICA);
		conta.setStatus(Status.ATIVA);
		conta.setNatureza(Natureza.DESPESA);
		conta.setContaPai(null);
		listaConta.add(conta);

		conta = new Conta();
		conta.setChave(4);
		conta.setDescricao("RECEITAS");
		conta.setTipoConta(TipoConta.SINTETICA);
		conta.setStatus(Status.ATIVA);
		conta.setNatureza(Natureza.RECEITA);
		conta.setContaPai(null);
		listaConta.add(conta);

	}

	/****************************************************************************/
	// Monta TreeNode das contas
	/****************************************************************************/
	private void criarTreeNode(List<Conta> contaRaiz) {

		this.raiz = new DefaultTreeNode("RAIZ", null);
		adicionarNos(contaRaiz, this.raiz);

	}

	/****************************************************************************/
	// Adicionar os registros filhos do Pai
	/****************************************************************************/
	private void adicionarNos(List<Conta> contas, TreeNode pai) {

		for (Conta conta : contas) {

			TreeNode no = new DefaultTreeNode(conta, pai);
			adicionarNos(conta.getSubConta(), no);

		}

	}

}
