package br.com.tamagu.resvut42x.enums;

/****************************************************************************/
// Enumerador de Ativo e Inativo
// Desenvolvido por : Jedi 
// Criado em 21/01/2017 
/****************************************************************************/

public enum Status {

	ATIVA("Ativa"), 
	INATIVA("Inativa");

	private String descricao;

	Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
