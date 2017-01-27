package br.com.tamagu.resvut42x.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.tamagu.resvut42x.entidades.Filial;
import br.com.tamagu.resvut42x.enums.RamoAtividade;
import br.com.tamagu.resvut42x.servico.SerFilial;
import br.com.tamagu.resvut42x.util.FacesMessages;

/****************************************************************************/
// Classe controle para View da Tela da Filial
// Desenvolvido por : Jedi 
// Criado em 21/01/2017 
/****************************************************************************/

@Named
@ViewScoped
public class ControleFilial implements Serializable {

	/****************************************************************************/
	// Variaveis e Dependências
	/****************************************************************************/
	private static final long serialVersionUID = 1L;
	private List<Filial> listaFiliais = new ArrayList<Filial>();
	private Filial filialEdicao = new Filial();
	private Filial filialSelect;

	@Autowired
	SerFilial serFilia;
	@Autowired
	private FacesMessages mensagens;

	/****************************************************************************/
	// Metodo Salvar
	/****************************************************************************/
	public void salvar() {
		try {
			serFilia.salvar(filialEdicao);
			listar();
			mensagens.info("Registro salvo com sucesso!");
		} catch (Exception e) {
			mensagens.error(e.getMessage());
		}
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msg-frm", "frm:tabela"));
	}

	/****************************************************************************/
	// Metodo Excluir
	/****************************************************************************/
	public void excluir() {
		try {
			serFilia.excluir(filialSelect);
			filialSelect = null;
			listar();
			mensagens.info("Registro excluido com sucesso!");
		} catch (Exception e) {
			mensagens.error(e.getMessage());
		}
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msg-frm", "frm:tabela"));
	}

	/****************************************************************************/
	// Buscar lista dos dados no banco
	/****************************************************************************/
	public void listar() {
		listaFiliais = serFilia.ListarTodos();
	}

	/****************************************************************************/
	// Preparar objetos para novo cadastro
	/****************************************************************************/
	public void novoCadastro() {
		filialEdicao = new Filial();
	}

	/****************************************************************************/
	// -- Lista de opções de enums
	/****************************************************************************/
	public RamoAtividade[] getRamosAtividade() {
		return RamoAtividade.values();
	}

	/****************************************************************************/
	// Gets e Sets do controle
	/****************************************************************************/
	public List<Filial> getListaFiliais() {
		return listaFiliais;
	}

	public Filial getFilialEdicao() {
		return filialEdicao;
	}

	public void setFilialEdicao(Filial filialEdicao) {
		this.filialEdicao = filialEdicao;
	}

	public Filial getFilialSelect() {
		return filialSelect;
	}

	public void setFilialSelect(Filial filialSelect) {
		this.filialSelect = filialSelect;
	}

}
