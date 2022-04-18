package com.hospitalajea14019.projecthospitalspring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        //obtener el token
        String token = obtainJwtFromRequest(request);
        //validar token
        if (StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)){
            //obtener el username del token
            String username=jwtTokenProvider.getEmailFromToken(token);
            //cargar usuario asociado al token
            UserDetails userDetails =usuarioDetailsService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userDetails,userDetails.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            //establecer seguridad
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        //validar filtro
        filterChain.doFilter(request,response);

    }
    //Bearer token de acceso, formato de autorizacion de un usuario
    private String obtainJwtFromRequest(HttpServletRequest request){
        String bearerToken=request.getHeader("Authorization"); //cabecera del header de la solicitud
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")){
            return bearerToken.substring(7,bearerToken.length()); //eliminar "bearer " y obtener el token
        }
        return null;
    }
}
