package com.hospitalajea14019.projecthospitalspring.converter;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hospitalajea14019.projecthospitalspring.converter.base.AbstractConverter;

import com.hospitalajea14019.projecthospitalspring.dto.PacienteDto;

import com.hospitalajea14019.projecthospitalspring.model.Paciente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PacienteConverter extends AbstractConverter<Paciente, PacienteDto> {
    ObjectMapper mapper =new ObjectMapper();

    public PacienteConverter() {

    }

    @Override
    public PacienteDto fromEntity(Paciente entity) {
        log.info("pase por converter fromEntity");
        return PacienteDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .dni(entity.getDni())
                .domicilio_id(entity.getDomicilio_id())
                .fechaIngreso(entity.getFechaIngreso())
                .build();
    }

    @Override
    public Paciente fromDto(PacienteDto dto) {
        log.info("pase por converter fromDto");
        return Paciente.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .dni(dto.getDni())
                .domicilio_id(dto.getDomicilio_id())
                .fechaIngreso(dto.getFechaIngreso())
                .build();
    }
}
