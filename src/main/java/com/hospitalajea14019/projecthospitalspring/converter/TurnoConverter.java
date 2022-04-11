package com.hospitalajea14019.projecthospitalspring.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hospitalajea14019.projecthospitalspring.converter.base.AbstractConverter;
import com.hospitalajea14019.projecthospitalspring.dto.TurnoDto;
import com.hospitalajea14019.projecthospitalspring.model.Turno;
import org.springframework.stereotype.Component;

@Component
public class TurnoConverter extends AbstractConverter<Turno, TurnoDto> {

    ObjectMapper mapper=new ObjectMapper();

    public TurnoConverter() {

    }

    @Override
    public TurnoDto fromEntity(Turno entity) {
        return TurnoDto.builder()
                .fecha(entity.getFecha())
                .hora(entity.getHora())
                .paciente_id(entity.getIdPaciente())
                .odontologo_id(entity.getIdOdontologo())
                .id(entity.getId())
                .build();
    }

    @Override
    public Turno fromDto(TurnoDto dto) {
        return mapper.convertValue(dto,Turno.class);
    }
}
