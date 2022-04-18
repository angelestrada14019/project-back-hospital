package com.hospitalajea14019.projecthospitalspring.service.mongo;

import com.hospitalajea14019.projecthospitalspring.exceptions.GeneralServicesExceptions;
import com.hospitalajea14019.projecthospitalspring.exceptions.NoDataFoundExceptions;
import com.hospitalajea14019.projecthospitalspring.exceptions.ValidateServiceExceptions;
import com.hospitalajea14019.projecthospitalspring.model.mongo.Usuario;
import com.hospitalajea14019.projecthospitalspring.repository.mongo.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository booksRepository) {
        this.usuarioRepository = booksRepository;
    }
    @Transactional
    public List<Usuario> findAll(){
        try {
            log.info("pase por findAll de service");
            return usuarioRepository.findAll();

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }
    @Transactional
    public Usuario findById(String id){
        return usuarioRepository.findById(id).orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + id));
    }
    @Transactional
    public Usuario findUsuarioByEmail(String email){
        try {
            Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.findUsuarioByEmail(email));
            Usuario usuario1 = usuario.orElseThrow(() -> new NoDataFoundExceptions("no existe el email: " + email));
            return usuario1;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }
    public Boolean existsUsuarioByEmail(String email){
        return usuarioRepository.existsUsuarioByEmail(email);
    }
    @Transactional
    public Usuario save(Usuario usuario) {
        try {
            //validator
            return  usuarioRepository.save(usuario);

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }
    @Transactional
    public Usuario update(Usuario usuario) {
        try {
            //validator
            Usuario usuario1=usuarioRepository.
                    findById( usuario.getId()).orElseThrow(()-> new NoDataFoundExceptions("error al actualizar el id: " + usuario.getId()));;
            usuario1.setEmail(usuario.getEmail());
            usuario1.setClave(usuario.getClave());
            usuario1.setOdontologo_id(usuario.getOdontologo_id());
            usuario1.setPaciente_id(usuario.getPaciente_id());
            usuario1.setPerfil_id(usuario.getPerfil_id());
            usuarioRepository.save(usuario1);
            return usuario1;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }
    @Transactional
    public Boolean delete(String id) {
        try {
            Usuario usuario = usuarioRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + id));
            usuarioRepository.delete(usuario);
            return true;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }
}
