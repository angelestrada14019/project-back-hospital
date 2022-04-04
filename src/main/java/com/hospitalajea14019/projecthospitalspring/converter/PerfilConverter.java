package com.hospitalajea14019.projecthospitalspring.converter;

import com.hospitalajea14019.projecthospitalspring.converter.base.AbstractConverter;
import com.hospitalajea14019.projecthospitalspring.dto.PerfilDto;
import com.hospitalajea14019.projecthospitalspring.model.Perfil;
import org.springframework.stereotype.Component;

@Component
public class PerfilConverter extends AbstractConverter<Perfil, PerfilDto> {
    @Override
    public PerfilDto fromEntity(Perfil entity) {
        return PerfilDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .build();
    }

    @Override
    public Perfil fromDto(PerfilDto dto) {
        Perfil perfil=new Perfil();
        perfil.setId(dto.getId());
        perfil.setNombre(dto.getNombre());
        return perfil;
    }
}
