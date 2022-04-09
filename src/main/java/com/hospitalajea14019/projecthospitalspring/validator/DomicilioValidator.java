package com.hospitalajea14019.projecthospitalspring.validator;

import com.hospitalajea14019.projecthospitalspring.exceptions.ValidateServiceExceptions;
import com.hospitalajea14019.projecthospitalspring.model.Domicilio;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DomicilioValidator extends BaseValidator<Domicilio> {
    @Override
    public void validar(Domicilio entity) {
        if (entity.getCalle()==null || entity.getCalle().trim().isEmpty()){
            throw new ValidateServiceExceptions("La calle es obligatoria");
        }
    }
}
