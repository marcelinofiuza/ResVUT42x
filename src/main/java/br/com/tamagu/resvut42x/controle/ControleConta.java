package br.com.tamagu.resvut42x.controle;

import java.io.Serializable;
import java.util.Arrays;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.tamagu.resvut42x.entidades.Conta;
import br.com.tamagu.resvut42x.enums.Natureza;
import br.com.tamagu.resvut42x.enums.Status;
import br.com.tamagu.resvut42x.enums.TipoConta;
import br.com.tamagu.resvut42x.servico.SerConta;
import br.com.tamagu.resvut42x.util.FacesMessages;

/****************************************************************************/
// Classe controle para View da Tela do Plano de contas 
// Desenvolvido por : Jedi 
// Criado em 21/01/2017 
/****************************************************************************/

@Named
@ViewScoped
public class ControleConta implements Serializable {

	/****************************************************************************/
	// Variaveis e Dependências
	/****************************************************************************/
	private static final long serialVersionUID = 1L;
	private TreeNode treeContas;
	private TreeNode contaSelect;
	private Conta contaEdicao = new Conta();

	@Autowired
	SerConta serConta;
	@Autowired
	private FacesMessages mensagens;

	/****************************************************************************/
	// Metodo Salvar
	/****************************************************************************/
	public void salvar() {
		try {
			serConta.Salvar(contaEdicao);
			listar();
			contaSelect = null;
			contaEdicao = new Conta();
			mensagens.info("Registro salvo com sucesso!");
		} catch (Exception e) {
			mensagens.error(e.getMessage());
		}
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msg-frm", "frm:tabela", "frm:toolbar"));
	}

	/****************************************************************************/
	// Metodo Excluir
	/****************************************************************************/
	public void excluir() {
		try {
			Conta contatmp = (Conta) contaSelect.getData();
			serConta.Excluir(contatmp);
			listar();
			contaSelect = null;
			contaEdicao = new Conta();
			mensagens.info("Registro excluido com sucesso!");
		} catch (Exception e) {
			mensagens.error(e.getMessage());
		}
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msg-frm", "frm:tabela", "frm:toolbar"));
	}

	/****************************************************************************/
	// Buscar lista dos dados no banco
	/****************************************************************************/
	public void listar() {
		treeContas = serConta.ListarTodos();
	}

	/****************************************************************************/
	// Preparar objetos para novo cadastro
	/****************************************************************************/
	public void novoCadastro() {

		Conta contatmp = (Conta) contaSelect.getData();

		if (contatmp.getTipoConta().equals(TipoConta.ANALITICA)) {
			contatmp = (Conta) contaSelect.getData();
			contatmp = contatmp.getContaPai();
		}

		contaEdicao = new Conta();
		contaEdicao.setContaPai(contatmp);
		contaEdicao.setNatureza(contatmp.getNatureza());
		contaEdicao.setStatus(contatmp.getStatus());

	}

	/****************************************************************************/
	// Atribuir no controle o registro selecionado na tela
	/****************************************************************************/
	public void registroSelecionado() {
		contaEdicao = (Conta) contaSelect.getData();
	}

	/****************************************************************************/
	// -- Lista de opções de enums
	/****************************************************************************/
	public TipoConta[] getTiposConta() {
		return TipoConta.values();
	}

	public Status[] getStatusConta() {
		return Status.values();
	}

	public Natureza[] getNaturezas() {
		return Natureza.values();
	}

	/****************************************************************************/
	// Gets e Sets do controle
	/****************************************************************************/
	public TreeNode getTreeContas() {
		return treeContas;
	}

	public Conta getContaEdicao() {
		return contaEdicao;
	}

	public void setContaEdicao(Conta contaEdicao) {
		this.contaEdicao = contaEdicao;
	}

	public TreeNode getContaSelect() {
		return contaSelect;
	}

	public void setContaSelect(TreeNode contaSelect) {
		this.contaSelect = contaSelect;
	}

}
