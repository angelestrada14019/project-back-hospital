package com.hospitalajea14019.projecthospitalspring.security;

import lombok.extern.slf4j.Slf4j;
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

@Slf4j
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
        log.info("request in filter: "+request);
        String token = obtainJwtFromRequest(request);
        log.info("token in filter: "+ token);
        //validar token
        try {
            if (StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)) {
                //obtener el username del token
                String username = jwtTokenProvider.getEmailFromToken(token);
                log.info("usuario: " + username);
                //cargar usuario asociado al token
                UserDetails userDetails = usuarioDetailsService.loadUserByUsername(username);
                log.info("authorities: " + userDetails.getAuthorities());
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails,null,  userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //establecer seguridad
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }catch (Exception e){
            log.error("Error al autenticar al usuario",e);
        }
        //validar filtro
        filterChain.doFilter(request,response);

    }
    //Bearer token de acceso, formato de autorizacion de un usuario
    private String obtainJwtFromRequest(HttpServletRequest request){
        String bearerToken=request.getHeader("Authorization"); //header de la solicitud
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7,bearerToken.length()); //eliminar "bearer " y obtener el token
        }
        return null;
    }
}
