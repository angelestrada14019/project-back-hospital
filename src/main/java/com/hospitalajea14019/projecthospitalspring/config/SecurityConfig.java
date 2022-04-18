package com.hospitalajea14019.projecthospitalspring.config;

import com.hospitalajea14019.projecthospitalspring.security.JwtAuthenticationEntryPoint;
import com.hospitalajea14019.projecthospitalspring.security.JwtAuthenticationFilter;
import com.hospitalajea14019.projecthospitalspring.security.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity //clase de seguridad personalizada
@EnableGlobalMethodSecurity(prePostEnabled = true) //seguridad de nivel  de metodo, cprePostEnable=true habilita preAuthorize y postAuthorize
public class SecurityConfig extends WebSecurityConfigurerAdapter { //redefinir algunos de los metodos de springSecurity

    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(){
        return new JwtAuthenticationFilter();
    }

    @Bean //genere un objeto bean, se debe crear bajo la anotacion configuration
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint) //manejar excepcion
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // sin estado
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/perfil/**").permitAll()
                .antMatchers("/auth/**").permitAll()
                .anyRequest()
                .authenticated();
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class); //autenticacion por token (filtro usado y la clase del filtro
    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//
//        UserDetails jesus= User.builder().username("j@a.com")
//                .password(passwordEncoder().encode("jesus"))
//                .roles("paciente").build();
//        UserDetails rob= User.builder().username("r@b.com")
//                .password(passwordEncoder().encode("rob"))
//                .roles("odontologo").build();
//        UserDetails angel= User.builder().username("a@e.com")
//                .password(passwordEncoder().encode("angel"))
//                .roles("administrador").build();
//        return new InMemoryUserDetailsManager(angel,jesus,rob);
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { //crear roles y usuarios personalizados
        auth.userDetailsService(usuarioDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {//para poder autenticarse
        return super.authenticationManagerBean();
    }
}

