#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.security;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.ExceptionTranslationFilter;

import hornet.framework.web.security.RestAccessDeniedHandler;
import hornet.framework.web.security.SecurityAuthenticationEntryPoint;
import hornet.framework.web.security.jwt.filter.JwtAuthFilter;

@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true) for annotation on method (only old version spring)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Resource
	JwtAuthenticationProvider jwtAuthenticationProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(jwtAuthenticationProvider);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterAfter(new JwtAuthFilter(), ExceptionTranslationFilter.class).sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.csrf().disable()
		.exceptionHandling().authenticationEntryPoint(new SecurityAuthenticationEntryPoint()).accessDeniedHandler(new RestAccessDeniedHandler())
		.and().authorizeRequests()
			//.antMatchers(HttpMethod.POST, "/partenaires/**").hasRole("${artifactId}_ADMIN")
			//.antMatchers(HttpMethod.DELETE, "/partenaires/**").hasRole("${artifactId}_ADMIN")
			//.antMatchers(HttpMethod.PUT, "/partenaires/**").hasRole("${artifactId}_ADMIN")
			.antMatchers("/contact").access("hasRole('${artifactId}_USER') and hasRole('${artifactId}_ADMIN')")
			.anyRequest().permitAll();
	}
	
	
}
