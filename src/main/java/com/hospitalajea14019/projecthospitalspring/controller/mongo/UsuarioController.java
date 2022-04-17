package com.hospitalajea14019.projecthospitalspring.controller.mongo;

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

    public UsuarioController(UsuarioService booksService) {
        this.usuarioService = booksService;
    }
    @GetMapping("")
    public ResponseEntity<WrapperResponse<List<Usuario>>> findAll(){
        List<Usuario> usuarios=usuarioService.findAll();
        return new WrapperResponse<>(true,"Succes",usuarios).createResponse(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<Usuario>> findById(@PathVariable String id){
        //String idS=String.valueOf(id);
        Usuario usuario=usuarioService.findById(id);
        return new WrapperResponse<>(true,"Succes",usuario).createResponse(HttpStatus.OK);
    }
    @GetMapping({"/email/{email}"})
    public ResponseEntity<WrapperResponse<Usuario>>  findUsuarioByEmail(@PathVariable String email){
        Usuario usuario =usuarioService.findUsuarioByEmail(email);
        return new WrapperResponse<>(true,"Succes",usuario).createResponse(HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<WrapperResponse<Usuario>> save(@RequestBody Usuario usuario) {
        Usuario usuario1=usuarioService.save(usuario);
        return new WrapperResponse<>(true,"Create Succes",usuario1).createResponse(HttpStatus.CREATED);
    }
    @PutMapping("")
    public ResponseEntity<WrapperResponse<Usuario>> update(@RequestBody Usuario usuario) {
        Usuario usuario1=usuarioService.update(usuario);
        return new WrapperResponse<>(true,"Update Succes",usuario1).createResponse(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Boolean>> delete(@PathVariable String id) {
        //String idS=String.valueOf(id);
        Boolean deletS= usuarioService.delete(id);
        return new WrapperResponse<>(true,"Delete Succes",deletS).createResponse(HttpStatus.OK);
    }
}
