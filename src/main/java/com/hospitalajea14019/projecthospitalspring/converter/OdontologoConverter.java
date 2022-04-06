package com.hospitalajea14019.projecthospitalspring.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospitalajea14019.projecthospitalspring.converter.base.AbstractConverter;
import com.hospitalajea14019.projecthospitalspring.dto.OdontologoDto;
import com.hospitalajea14019.projecthospitalspring.model.Odontologo;
import org.springframework.stereotype.Component;


@Component
public class OdontologoConverter extends AbstractConverter<Odontologo,OdontologoDto> {

    ObjectMapper mapper =new ObjectMapper();

    @Override
    public OdontologoDto fromEntity(Odontologo entity) {
        return mapper.convertValue(entity,OdontologoDto.class);
    }

    @Override
    public Odontologo fromDto(OdontologoDto dto) {

        return mapper.convertValue(dto,Odontologo.class);
    }
}
