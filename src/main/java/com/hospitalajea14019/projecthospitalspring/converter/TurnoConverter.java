package com.hospitalajea14019.projecthospitalspring.converter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hospitalajea14019.projecthospitalspring.converter.base.AbstractConverter;
import com.hospitalajea14019.projecthospitalspring.dto.TurnoDto;
import com.hospitalajea14019.projecthospitalspring.model.Turno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j

public class TurnoConverter extends AbstractConverter<Turno, TurnoDto> {



    public TurnoConverter() {

    }

    @Override
    public TurnoDto fromEntity(Turno entity) {
        log.info("pase por converter fromEntity");
        return TurnoDto.builder()
                .fecha(entity.getFecha())
                .hora(entity.getHora())
                .paciente_id(entity.getPaciente_id())
                .odontologo_id(entity.getOdontologo_id())
                .id(entity.getId())
                .build();
    }

    @Override
    public Turno fromDto(TurnoDto dto) {
        log.info("pase por converter fromDto");
        Turno t = new Turno();
        t.setId(dto.getId());
        t.setFecha(dto.getFecha());
        t.setHora(dto.getHora());
        t.setOdontologo_id(dto.getOdontologo_id());
        t.setPaciente_id(dto.getPaciente_id());
        return t;
    }
}
