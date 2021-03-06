package br.com.tamagu.resvut42x.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.tamagu.resvut42x.enums.Natureza;
import br.com.tamagu.resvut42x.enums.Status;
import br.com.tamagu.resvut42x.enums.TipoConta;

/****************************************************************************/
// Entidade Conta (Plano de Contas)
// Desenvolvido por : Jedi 
// Criado em 21/01/2017 
/****************************************************************************/

@Entity
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idConta;

	@NotNull
	@Column(nullable = false)
	private Integer chave;

	@NotEmpty
	@Column(length = 50, nullable = false)
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private TipoConta tipoConta;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Status status;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Natureza natureza;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idContaPai")
	private Conta contaPai;

	@OneToMany(mappedBy = "contaPai", fetch = FetchType.EAGER)
	private List<Conta> subConta;

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public Integer getChave() {
		return chave;
	}

	public void setChave(Integer chave) {
		this.chave = chave;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Natureza getNatureza() {
		return natureza;
	}

	public void setNatureza(Natureza natureza) {
		this.natureza = natureza;
	}

	public Conta getContaPai() {
		return contaPai;
	}

	public void setContaPai(Conta contaPai) {
		this.contaPai = contaPai;
	}

	public List<Conta> getSubConta() {
		return subConta;
	}

	public void setSubConta(List<Conta> subConta) {
		this.subConta = subConta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConta == null) ? 0 : idConta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Conta))
			return false;
		Conta other = (Conta) obj;
		if (idConta == null) {
			if (other.idConta != null)
				return false;
		} else if (!idConta.equals(other.idConta))
			return false;
		return true;
	}

}
