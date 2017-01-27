package br.com.tamagu.resvut42x.entidades;

/****************************************************************************/
// Entidade Filial
// Desenvolvido por : Jedi 
// Criado em 21/01/2017 
/****************************************************************************/

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.tamagu.resvut42x.enums.RamoAtividade;

@Entity
public class Filial implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFilial;

	@NotEmpty
	@Column(length = 80, nullable = false)
	private String razaoSocial;

	@NotEmpty
	@Column(length = 40, nullable = false)
	private String fantasia;

	@CNPJ
	@Column(length = 18, nullable = true)
	@Nullable
	private String cnpj;

	@CPF
	@Column(length = 14, nullable = true)
	@Nullable
	private String cpf;

	@Column(length = 15)
	private String insEstadual;

	@Column(length = 15)
	private String insMunicipal;

	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private RamoAtividade ramoAtividade;

	@Column(length = 9)
	private String cnae;

	@Column(length = 5)
	private String naturezaJuridica;

	@Past
	@Temporal(TemporalType.DATE)
	private Date dataAbertura;

	@Embedded
	private Endereco endereco = new Endereco();

	@Embedded
	private Contato contato = new Contato();

	public Long getIdFilial() {
		return idFilial;
	}

	public void setIdFilial(Long idFilial) {
		this.idFilial = idFilial;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getInsEstadual() {
		return insEstadual;
	}

	public void setInsEstadual(String insEstadual) {
		this.insEstadual = insEstadual;
	}

	public String getInsMunicipal() {
		return insMunicipal;
	}

	public void setInsMunicipal(String insMunicipal) {
		this.insMunicipal = insMunicipal;
	}

	public RamoAtividade getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(RamoAtividade ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
	}

	public String getNaturezaJuridica() {
		return naturezaJuridica;
	}

	public void setNaturezaJuridica(String naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFilial == null) ? 0 : idFilial.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Filial))
			return false;
		Filial other = (Filial) obj;
		if (idFilial == null) {
			if (other.idFilial != null)
				return false;
		} else if (!idFilial.equals(other.idFilial))
			return false;
		return true;
	}

}
