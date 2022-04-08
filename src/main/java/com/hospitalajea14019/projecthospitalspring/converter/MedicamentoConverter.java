package com.hospitalajea14019.projecthospitalspring.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospitalajea14019.projecthospitalspring.converter.base.AbstractConverter;
import com.hospitalajea14019.projecthospitalspring.dto.MedicamentoDto;
import com.hospitalajea14019.projecthospitalspring.model.Medicamento;
import org.springframework.stereotype.Component;

@Component
public class MedicamentoConverter extends AbstractConverter<Medicamento, MedicamentoDto> {

    ObjectMapper mapper=new ObjectMapper();

    @Override
    public MedicamentoDto fromEntity(Medicamento entity) {
        return mapper.convertValue(entity,MedicamentoDto.class);
    }

    @Override
    public Medicamento fromDto(MedicamentoDto dto) {
        return mapper.convertValue(dto,Medicamento.class);
    }
}
