package com.hospitalajea14019.projecthospitalspring.controller.mongo;

import com.hospitalajea14019.projecthospitalspring.converter.mongo.UsuarioConverter;
import com.hospitalajea14019.projecthospitalspring.dto.mongo.UsuarioDto;
import com.hospitalajea14019.projecthospitalspring.model.mongo.Usuario;
import com.hospitalajea14019.projecthospitalspring.service.mongo.UsuarioService;
import com.hospitalajea14019.projecthospitalspring.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;
    private UsuarioConverter usuarioConverter;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioService usuarioService, UsuarioConverter usuarioConverter) {
        this.usuarioService = usuarioService;
        this.usuarioConverter=usuarioConverter;
    }
    @GetMapping("")
    @PreAuthorize("hasRole('administrador')")
    public ResponseEntity<WrapperResponse<List<UsuarioDto>>> findAll(){
        List<Usuario> usuarios=usuarioService.findAll();
        List<UsuarioDto> dtos = usuarioConverter.fromEntity(usuarios);
        return new WrapperResponse<>(true,"Succes",dtos).createResponse(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('administrador','odontologo','paciente')")
    public ResponseEntity<WrapperResponse<UsuarioDto>> findById(@PathVariable String id){
        Usuario usuario=usuarioService.findById(id);
        UsuarioDto usuarioDto=usuarioConverter.fromEntity(usuario);
        return new WrapperResponse<>(true,"Succes",usuarioDto).createResponse(HttpStatus.OK);
    }
    @GetMapping({"/email/{email}"})
    @PreAuthorize("hasAnyRole('administrador','odontologo','paciente')")
    public ResponseEntity<WrapperResponse<UsuarioDto>>  findUsuarioByEmail(@PathVariable String email){
        Usuario usuario =usuarioService.findUsuarioByEmail(email);
        UsuarioDto usuarioDto =usuarioConverter.fromEntity(usuario);
        return new WrapperResponse<>(true,"Succes",usuarioDto).createResponse(HttpStatus.OK);
    }
    @PostMapping("")
    @PreAuthorize("hasAnyRole('administrador','odontologo','paciente')")
    public ResponseEntity<WrapperResponse<UsuarioDto>> save(@Valid @RequestBody UsuarioDto usuarioDto) { //el valid al costado del requestBody
        Usuario usuarioS =usuarioConverter.fromDto(usuarioDto);
        usuarioS.setClave(passwordEncoder.encode(usuarioS.getClave()));
        Usuario usuario1=usuarioService.save(usuarioS);
        UsuarioDto usuarioDto1=usuarioConverter.fromEntity(usuario1);
        return new WrapperResponse<>(true,"Create Succes",usuarioDto1).createResponse(HttpStatus.CREATED);
    }
    @PutMapping("")
    @PreAuthorize("hasAnyRole('administrador','odontologo','paciente')")
    public ResponseEntity<WrapperResponse<UsuarioDto>> update(@Valid @RequestBody UsuarioDto usuarioDto) {
        Usuario usuarioS =usuarioConverter.fromDto(usuarioDto);
        usuarioS.setClave(passwordEncoder.encode(usuarioS.getClave()));
        Usuario usuario1=usuarioService.update(usuarioS);
        UsuarioDto usuarioDto1 =usuarioConverter.fromEntity(usuario1);
        return new WrapperResponse<>(true,"Update Succes",usuarioDto1).createResponse(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('administrador','odontologo','paciente')")
    public ResponseEntity<WrapperResponse<Boolean>> delete(@PathVariable String id) {
        Boolean deletS= usuarioService.delete(id);
        return new WrapperResponse<>(true,"Delete Succes",deletS).createResponse(HttpStatus.OK);
    }
}
