package com.hospitalajea14019.projecthospitalspring.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospitalajea14019.projecthospitalspring.converter.base.AbstractConverter;
import com.hospitalajea14019.projecthospitalspring.dto.TurnoDto;
import com.hospitalajea14019.projecthospitalspring.model.Turno;
import org.springframework.stereotype.Component;

@Component
public class TurnoConverter extends AbstractConverter<Turno, TurnoDto> {

    ObjectMapper mapper=new ObjectMapper();

    @Override
    public TurnoDto fromEntity(Turno entity) {
        return mapper.convertValue(entity,TurnoDto.class);
    }

    @Override
    public Turno fromDto(TurnoDto dto) {
        return mapper.convertValue(dto,Turno.class);
    }
}
