package com.hospitalajea14019.projecthospitalspring.converter;

import com.hospitalajea14019.projecthospitalspring.converter.base.AbstractConverter;
import com.hospitalajea14019.projecthospitalspring.dto.OdontologoDto;
import com.hospitalajea14019.projecthospitalspring.dto.PacienteDto;
import com.hospitalajea14019.projecthospitalspring.model.Odontologo;
import com.hospitalajea14019.projecthospitalspring.model.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteConverter extends AbstractConverter<Paciente, PacienteDto> {
    @Override
    public PacienteDto fromEntity(Paciente entity) {
        return PacienteDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .dni(entity.getDni())
                .fechaIngreso(entity.getFechaIngreso())
                .domicilio_id(entity.getDomicilio_id())
                .build();
    }

    @Override
    public Paciente fromDto(PacienteDto dto) {
        Paciente paciente=new Paciente();
        paciente.setId(dto.getId());
        paciente.setNombre(dto.getNombre());
        paciente.setApellido(dto.getApellido());
        paciente.setDni(dto.getDni());
        paciente.setFechaIngreso(dto.getFechaIngreso());
        paciente.setDomicilio_id(dto.getDomicilio_id());
        return paciente;
    }
}
