package com.hospitalajea14019.projecthospitalspring.security;

import com.hospitalajea14019.projecthospitalspring.model.Perfil;
import com.hospitalajea14019.projecthospitalspring.model.mongo.Usuario;
import com.hospitalajea14019.projecthospitalspring.service.PerfilServiceImpl;
import com.hospitalajea14019.projecthospitalspring.service.mongo.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PerfilServiceImpl perfilService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {//buscar ususario por username
        Usuario usuario =usuarioService.findUsuarioByEmail(email);
        Perfil perfil =perfilService.findById(usuario.getPerfil_id());
        return new User(usuario.getEmail(),usuario.getClave(),mapperRoles(perfil.getNombre()));
    }
    private Collection<? extends GrantedAuthority> mapperRoles(String perfil){
        List<GrantedAuthority> authorities= Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+perfil));
        return authorities;
    }
}
