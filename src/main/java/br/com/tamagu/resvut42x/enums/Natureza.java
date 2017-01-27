package br.com.tamagu.resvut42x.enums;

/****************************************************************************/
// Enumerador Natureza da Conta
// Desenvolvido por : Jedi 
// Criado em 21/01/2017 
/****************************************************************************/

public enum Natureza {

	ATIVO("Ativo"),
	PASSIVO("Passivo"),
	DESPESA("Despesas - Devedora de resultado"), 
	RECEITA("Receita - Credora de resultado");
	
	private String descricao;

	Natureza(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}	
}
