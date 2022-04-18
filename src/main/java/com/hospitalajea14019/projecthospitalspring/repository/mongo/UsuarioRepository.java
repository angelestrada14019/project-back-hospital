package com.hospitalajea14019.projecthospitalspring.repository.mongo;

import com.hospitalajea14019.projecthospitalspring.model.mongo.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    public Usuario findUsuarioByEmail(String email);
    public Boolean existsUsuarioByEmail(String email);
}
