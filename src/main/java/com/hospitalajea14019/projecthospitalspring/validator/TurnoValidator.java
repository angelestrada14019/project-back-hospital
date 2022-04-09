package com.hospitalajea14019.projecthospitalspring.validator;

import com.hospitalajea14019.projecthospitalspring.exceptions.ValidateServiceExceptions;
import com.hospitalajea14019.projecthospitalspring.model.Turno;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class TurnoValidator extends BaseValidator<Turno> {
    @Override
    public void validar(Turno entity) {
        if (entity.getFecha()==null){
            throw new ValidateServiceExceptions("El nombre es obligatorio");
        }
    }
}
