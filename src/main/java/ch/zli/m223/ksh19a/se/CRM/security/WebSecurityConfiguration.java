package ch.zli.m223.ksh19a.se.CRM.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.zli.m223.ksh19a.se.CRM.roles.AppRoles;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	UserDetailsService userDetailService;
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurityConfiguration(UserDetailsService userDetailService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailService = userDetailService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		configureWeb(http);
		// configureRest(http);
		super.configure(http);
	}
	/*
	 * private void configureRest(HttpSecurity http) {
	 * 
	 * }
	 */

	private void configureWeb(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("admin/**").hasAuthority(AppRoles.ADMIN)
				.antMatchers("/user/**").hasAuthority(AppRoles.SCHUEHLER).antMatchers("/logedin").authenticated().and()
				.formLogin().permitAll()// Alle dürfen zugreifen
				.and().logout().permitAll();
	}

}
