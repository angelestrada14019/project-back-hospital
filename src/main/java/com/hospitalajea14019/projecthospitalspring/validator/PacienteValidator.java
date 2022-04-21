package com.hospitalajea14019.projecthospitalspring.validator;

import com.hospitalajea14019.projecthospitalspring.exceptions.ValidateServiceExceptions;
import com.hospitalajea14019.projecthospitalspring.model.Paciente;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@NoArgsConstructor
@Component
public class PacienteValidator extends BaseValidator<Paciente>{
    @Override
    public void validar(Paciente entity) {
        if (entity.getNombre()==null || entity.getNombre().trim().isEmpty()){
            throw new ValidateServiceExceptions("El nombre es obligatorio");
        }
        if (entity.getApellido()==null || entity.getApellido().trim().isEmpty()){
            throw new ValidateServiceExceptions("El apellido es obligatorio");
        }
        if (entity.getDni()==null || entity.getDni().trim().isEmpty()){
            throw new ValidateServiceExceptions("El DNI es obligatorio");
        }
        if (entity.getDomicilio_id()==null){
            throw new ValidateServiceExceptions("El Domicilio es obligatorio");
        }
        if (entity.getFechaIngreso()==null){
            throw new ValidateServiceExceptions("La fecha de ingreso es obligatoria");
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            dateFormat.parse(entity.getFechaIngreso().toString());
        } catch (ParseException e) {
            throw new ValidateServiceExceptions("La fecha no tiene un formato valido");
        }
    }
}
