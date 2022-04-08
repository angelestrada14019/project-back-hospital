package com.hospitalajea14019.projecthospitalspring.validator;

import com.hospitalajea14019.projecthospitalspring.model.Odontologo;
import com.hospitalajea14019.projecthospitalspring.model.Paciente;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class PacienteValidator extends BaseValidator<Paciente>{
    @Override
    public void validar(Paciente entity) {

    }
}
