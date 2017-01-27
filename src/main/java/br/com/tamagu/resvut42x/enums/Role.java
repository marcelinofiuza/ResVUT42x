package br.com.tamagu.resvut42x.enums;

/****************************************************************************/
// Enumerador de Roles de perfil
// Desenvolvido por : Jedi 
// Criado em 24/01/2017 
/****************************************************************************/

public enum Role {
	
	ADMIN("Administrador"),
	USUARIO("Usuario");
	
	private String descricao;

	Role(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}	
}
