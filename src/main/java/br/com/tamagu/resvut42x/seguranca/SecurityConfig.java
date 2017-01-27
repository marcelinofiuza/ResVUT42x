package br.com.tamagu.resvut42x.seguranca;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/****************************************************************************/
// Classe Controle Segurança
// Desenvolvido por : Jedi 
// Criado em 21/01/2017 
/****************************************************************************/

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/****************************************************************************/
	// Variaveis e Dependências
	/****************************************************************************/
	@Autowired
	SecurityUserService securityUserService;

	/****************************************************************************/
	// Metodo de configuração
	/****************************************************************************/
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.userDetailsService(securityUserService)
			.formLogin()
				.loginPage("/TmgLogin.xhtml").permitAll()
				.failureUrl("/TmgLogin.xhtml?error").permitAll()			
				.defaultSuccessUrl("/Inicio.xhtml")
		.and()
			.logout().permitAll()
		.and()
			.csrf()
				.disable()
			.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/Usuario.xhtml").hasRole("ADMIN")
				.anyRequest().authenticated();
		
	}

}
