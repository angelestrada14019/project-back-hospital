package com.hospitalajea14019.projecthospitalspring.security;

import com.hospitalajea14019.projecthospitalspring.exceptions.ValidateServiceExceptions;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Slf4j
public class JwtTokenProvider {//se va a generar el token, obtener y geenrar las 3 etapas de un token
    @Value("${app.jwt-secret}")
    private String jwtSecret;
    @Value("${app.jwt-expiration-milliseconds}")
    private Integer jwtExpiration;

    public String generateToken(Authentication authentication){
        // token -> JOSE(algoritmo y tipo de token), Claims(Usuario, fecha expiracion), Hash(secretKey con CLaim y header)
        String username=authentication.getName(); //obtener usuario cuando se autentica
        Date fechaActual=new Date();
        Date fechaExpiracion =new Date(fechaActual.getTime()+jwtExpiration); //fecha de expiracion
        String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(fechaExpiracion)
                .signWith(SignatureAlgorithm.HS512,jwtSecret).compact(); //el token contendra el algoritmo de hash, usuario y fecha de expiracion, y con que clave secrta se va a hashear
        return token;
    }
    public String getEmailFromToken(String token){
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public Boolean validateToken(String token){
        try {
            log.info("antes de validar");
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            log.info("despues de validar");
            return true;
        }catch (SignatureException e){
            throw new ValidateServiceExceptions("firma jwt no valida");
        }catch (MalformedJwtException e){
            throw new ValidateServiceExceptions("Token jwt no valido");
        }catch (ExpiredJwtException e){
            throw new ValidateServiceExceptions("Token jwt caducado");
        }catch (UnsupportedJwtException e){
            throw new ValidateServiceExceptions("Token jwt no compatible");
        }catch (IllegalArgumentException e){
            throw new ValidateServiceExceptions("La cadena del pyload esta vacia");
        }
    }
}
