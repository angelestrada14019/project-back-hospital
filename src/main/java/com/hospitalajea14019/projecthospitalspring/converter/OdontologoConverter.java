package com.hospitalajea14019.projecthospitalspring.converter;

import com.hospitalajea14019.projecthospitalspring.converter.base.AbstractConverter;
import com.hospitalajea14019.projecthospitalspring.dto.OdontologoDto;
import com.hospitalajea14019.projecthospitalspring.model.Odontologo;
import org.springframework.stereotype.Component;


@Component
public class OdontologoConverter extends AbstractConverter<Odontologo,OdontologoDto> {


    @Override
    public OdontologoDto fromEntity(Odontologo entity) {
        return OdontologoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .matricula(entity.getMatricula())
                .turnos(entity.getTurnos())
                .build();
    }

    @Override
    public Odontologo fromDto(OdontologoDto dto) {
        Odontologo odontologo=new Odontologo();
        odontologo.setId(dto.getId());
        odontologo.setNombre(dto.getNombre());
        odontologo.setApellido(dto.getApellido());
        odontologo.setMatricula(dto.getMatricula());
        return odontologo;
    }
}
