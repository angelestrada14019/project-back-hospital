package com.hospitalajea14019.projecthospitalspring.controller.mongo;

import com.hospitalajea14019.projecthospitalspring.converter.mongo.UsuarioConverter;
import com.hospitalajea14019.projecthospitalspring.dto.mongo.LoginRequestDto;
import com.hospitalajea14019.projecthospitalspring.dto.mongo.LoginResponseUserDto;
import com.hospitalajea14019.projecthospitalspring.dto.mongo.UsuarioDto;
import com.hospitalajea14019.projecthospitalspring.model.mongo.Usuario;
import com.hospitalajea14019.projecthospitalspring.security.JwtTokenProvider;
import com.hospitalajea14019.projecthospitalspring.service.PerfilServiceImpl;
import com.hospitalajea14019.projecthospitalspring.service.mongo.UsuarioService;
import com.hospitalajea14019.projecthospitalspring.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioService usuarioService;


    @Autowired
    private UsuarioConverter usuarioConverter;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("login")
    public ResponseEntity<WrapperResponse<LoginResponseUserDto>> login(@RequestBody LoginRequestDto loginRequestDto){
        Usuario usuario = usuarioService.findUsuarioByEmail(loginRequestDto.getEmail());
        UsuarioDto usuarioDto =usuarioConverter.fromEntity(usuario);

        Authentication authentication=authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(),loginRequestDto.getClave()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //obtener token
        String token = jwtTokenProvider.generateToken(authentication);

        LoginResponseUserDto loginResponseUserDto =new LoginResponseUserDto(usuarioDto,token);
        return  new WrapperResponse<>(true,"Auth Succes",loginResponseUserDto).createResponse(HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<?> signUn(@RequestBody UsuarioDto usuarioDto){
        if(usuarioService.existsUsuarioByEmail(usuarioDto.getEmail())){
            return  new ResponseEntity<>("el usuario ya existe",HttpStatus.BAD_REQUEST);

        }
        Usuario usuarioS= usuarioConverter.fromDto(usuarioDto);
        usuarioS.setClave(passwordEncoder.encode(usuarioS.getClave()));
        Usuario usuario =usuarioService.save(usuarioS);
        UsuarioDto usuarioDto1 =usuarioConverter.fromEntity(usuario);

        return  new WrapperResponse<>(true,"Register Succes",usuarioDto1).createResponse(HttpStatus.OK);
    }
}
