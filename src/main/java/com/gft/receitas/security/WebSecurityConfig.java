package com.gft.receitas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private ImplementsUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").hasAnyRole("ADMIN", "USER")

                .antMatchers("/receita").hasAnyRole("ADMIN", "USER")
                .antMatchers("/receita/visualizar").hasAnyRole("ADMIN", "USER")
                .antMatchers("/receita/editar").hasRole("ADMIN")
                .antMatchers("/receita/excluir").hasRole("ADMIN")

                .antMatchers("/ingrediente").hasAnyRole("ADMIN", "USER")
                .antMatchers("/ingrediente/visualizar").hasAnyRole("ADMIN", "USER")
                .antMatchers("/ingrediente/editar").hasRole("ADMIN")
                .antMatchers("/ingrediente/excluir").hasRole("ADMIN")

                .antMatchers("/medida").hasAnyRole("ADMIN", "USER")
                .antMatchers("/medida/visualizar").hasAnyRole("ADMIN", "USER")
                .antMatchers("/medida/editar").hasRole("ADMIN")
                .antMatchers("/medida/excluir").hasRole("ADMIN")

                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}