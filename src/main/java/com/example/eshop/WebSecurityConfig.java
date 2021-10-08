package com.example.eshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private SimpleAuthenticationSuccessHandler successHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/webjars/**", "/error").permitAll().anyRequest().authenticated().and()
				.formLogin().successHandler(successHandler).loginPage("/login").permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")).permitAll();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password(new BCryptPasswordEncoder().encode("password")).roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password(new BCryptPasswordEncoder().encode("password")).roles("ADMIN");
	}

}