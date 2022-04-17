package com.hospitalajea14019.projecthospitalspring.converter.mongo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospitalajea14019.projecthospitalspring.converter.base.AbstractConverter;
import com.hospitalajea14019.projecthospitalspring.dto.mongo.UsuarioDto;
import com.hospitalajea14019.projecthospitalspring.model.mongo.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter extends AbstractConverter<Usuario, UsuarioDto> {

    ObjectMapper mapper=new ObjectMapper();

    @Override
    public UsuarioDto fromEntity(Usuario entity) {
        return mapper.convertValue(entity,UsuarioDto.class);
    }

    @Override
    public Usuario fromDto(UsuarioDto dto) {
        return mapper.convertValue(dto,Usuario.class);
    }
}
