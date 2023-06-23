package cibertec.edu.pe.DAWI_CL3_CESAR_LEIVA.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import lombok.RequiredArgsConstructor;

 
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Bean
	public SecurityFilterChain 
		configure(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests()
			.antMatchers("/usuario/loginusuario",
					"/usuario/registrarusuario",
					"/usuario/guardarUsuario",
					"/resources/**",
					"/static/**",
					"/css/**",
					"/js/**")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin().loginPage("/usuario/loginusuario")
			.usernameParameter("txtusuario")
			.passwordParameter("txtcontra")
			.defaultSuccessUrl("/home")
			.failureUrl("/usuario/loginusuario?error=true")
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/usuario/loginusuario").and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied");
		return http.build();	
	}
 
}