package br.com.tamagu.resvut42x.enums;

/****************************************************************************/
// Enumerador do Tipo de Conta contábil
// Desenvolvido por : Jedi 
// Criado em 21/01/2017 
/****************************************************************************/

public enum TipoConta {

	ANALITICA("Analítica"), 
	SINTETICA("Sintética");

	private String descricao;

	TipoConta(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
