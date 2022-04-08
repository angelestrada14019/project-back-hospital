package com.hospitalajea14019.projecthospitalspring.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospitalajea14019.projecthospitalspring.converter.base.AbstractConverter;
import com.hospitalajea14019.projecthospitalspring.dto.DomicilioDto;
import com.hospitalajea14019.projecthospitalspring.model.Domicilio;
import org.springframework.stereotype.Component;

@Component
public class DomicilioConverter extends AbstractConverter<Domicilio, DomicilioDto> {

    ObjectMapper mapper =new ObjectMapper();

    @Override
    public DomicilioDto fromEntity(Domicilio entity) {
        return mapper.convertValue(entity,DomicilioDto.class);
    }

    @Override
    public Domicilio fromDto(DomicilioDto dto) {
        return mapper.convertValue(dto,Domicilio.class);
    }
}
