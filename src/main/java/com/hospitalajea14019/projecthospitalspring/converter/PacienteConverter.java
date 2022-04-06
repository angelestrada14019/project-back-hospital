package com.hospitalajea14019.projecthospitalspring.converter;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hospitalajea14019.projecthospitalspring.converter.base.AbstractConverter;

import com.hospitalajea14019.projecthospitalspring.dto.PacienteDto;

import com.hospitalajea14019.projecthospitalspring.model.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteConverter extends AbstractConverter<Paciente, PacienteDto> {
    ObjectMapper mapper =new ObjectMapper();

    public PacienteConverter() {
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
    }

    @Override
    public PacienteDto fromEntity(Paciente entity) {
        return mapper.convertValue(entity,PacienteDto.class);
    }

    @Override
    public Paciente fromDto(PacienteDto dto) {

        return mapper.convertValue(dto,Paciente.class);
    }
}
