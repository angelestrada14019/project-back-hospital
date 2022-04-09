package com.hospitalajea14019.projecthospitalspring.validator;

import com.hospitalajea14019.projecthospitalspring.exceptions.ValidateServiceExceptions;
import com.hospitalajea14019.projecthospitalspring.model.Medicamento;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class MedicamentoValidator extends BaseValidator<Medicamento> {
    @Override
    public void validar(Medicamento entity) {
        if (entity.getNombre()==null || entity.getNombre().trim().isEmpty()){
            throw new ValidateServiceExceptions("El nombre es obligatorio");
        }
    }
}
