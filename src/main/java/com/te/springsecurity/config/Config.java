package com.te.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

	// Adding the Roles//
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()

				.withUser("Aryan")
				.password("1998")
				.roles("Admin")
				.and()
				.withUser("kunal")
				.password("1997")
				.roles("Student");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.

				httpBasic()
				.and()
				.authorizeRequests()
				.antMatchers("/delete")
				.hasRole("Admin")
				.and()
				.formLogin();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();

	}

}
