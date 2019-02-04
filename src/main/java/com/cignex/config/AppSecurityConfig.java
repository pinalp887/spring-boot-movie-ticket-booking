package com.cignex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.cignex.entities.CustomUserDetails;
import com.cignex.services.MyUserDetailsService;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/user/**").permitAll()
		.antMatchers("/movie/**").hasRole("ADMIN")
		.antMatchers("/screen/**").hasRole("ADMIN")
		.antMatchers("/book/**").hasAnyRole("ADMIN","USER")
		.anyRequest().authenticated()
		.and().authorizeRequests()
		.anyRequest().authenticated().and().formLogin().loginPage("/login")
		.loginProcessingUrl("/login-process")
		.defaultSuccessUrl("/book/datewise")
		.failureUrl("/login?error=true")
		.and().exceptionHandling()
		.accessDeniedPage("/acess-denied")
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/logout-sucess").permitAll()
		.and()
		.httpBasic();
		
	}

}
