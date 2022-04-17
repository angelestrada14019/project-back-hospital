package com.hospitalajea14019.projecthospitalspring.controller.mongo;

import com.hospitalajea14019.projecthospitalspring.converter.mongo.UsuarioConverter;
import com.hospitalajea14019.projecthospitalspring.dto.mongo.UsuarioDto;
import com.hospitalajea14019.projecthospitalspring.model.mongo.Usuario;
import com.hospitalajea14019.projecthospitalspring.service.mongo.UsuarioService;
import com.hospitalajea14019.projecthospitalspring.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;
    private UsuarioConverter usuarioConverter;

    public UsuarioController(UsuarioService usuarioService, UsuarioConverter usuarioConverter) {
        this.usuarioService = usuarioService;
        this.usuarioConverter=usuarioConverter;
    }
    @GetMapping("")
    public ResponseEntity<WrapperResponse<List<UsuarioDto>>> findAll(){
        List<Usuario> usuarios=usuarioService.findAll();
        List<UsuarioDto> dtos = usuarioConverter.fromEntity(usuarios);
        return new WrapperResponse<>(true,"Succes",dtos).createResponse(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<UsuarioDto>> findById(@PathVariable String id){
        Usuario usuario=usuarioService.findById(id);
        UsuarioDto usuarioDto=usuarioConverter.fromEntity(usuario);
        return new WrapperResponse<>(true,"Succes",usuarioDto).createResponse(HttpStatus.OK);
    }
    @GetMapping({"/email/{email}"})
    public ResponseEntity<WrapperResponse<UsuarioDto>>  findUsuarioByEmail(@PathVariable String email){
        Usuario usuario =usuarioService.findUsuarioByEmail(email);
        UsuarioDto usuarioDto =usuarioConverter.fromEntity(usuario);
        return new WrapperResponse<>(true,"Succes",usuarioDto).createResponse(HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<WrapperResponse<UsuarioDto>> save(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuario1=usuarioService.save(usuarioConverter.fromDto(usuarioDto));
        UsuarioDto usuarioDto1=usuarioConverter.fromEntity(usuario1);
        return new WrapperResponse<>(true,"Create Succes",usuarioDto1).createResponse(HttpStatus.CREATED);
    }
    @PutMapping("")
    public ResponseEntity<WrapperResponse<UsuarioDto>> update(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuario1=usuarioService.update(usuarioConverter.fromDto(usuarioDto));
        UsuarioDto usuarioDto1 =usuarioConverter.fromEntity(usuario1);
        return new WrapperResponse<>(true,"Update Succes",usuarioDto1).createResponse(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Boolean>> delete(@PathVariable String id) {
        //String idS=String.valueOf(id);
        Boolean deletS= usuarioService.delete(id);
        return new WrapperResponse<>(true,"Delete Succes",deletS).createResponse(HttpStatus.OK);
    }
}
