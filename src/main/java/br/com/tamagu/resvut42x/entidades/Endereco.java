package br.com.tamagu.resvut42x.entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/****************************************************************************/
// Entidade Endereço para complemento de cadastros diversos
// Desenvolvido por : Jedi 
// Criado em 21/01/2017 
/****************************************************************************/

@Embeddable
public class Endereco {

	@Column(length = 9)
	private String cep;

	@Column(length = 15)
	private String tipoLogradouro;

	@Column(length = 50)
	private String logradouro;

	@Column(length = 10)
	private String numero;

	@Column(length = 20)
	private String complemento;

	@Column(length = 40)
	private String bairro;

	@Column(length = 40)
	private String cidade;

	@Column(length = 2)
	private String uf;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
