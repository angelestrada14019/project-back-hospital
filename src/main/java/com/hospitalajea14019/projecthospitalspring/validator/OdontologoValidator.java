package com.hospitalajea14019.projecthospitalspring.validator;

import com.hospitalajea14019.projecthospitalspring.exceptions.ValidateServiceExceptions;
import com.hospitalajea14019.projecthospitalspring.model.Odontologo;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class OdontologoValidator extends BaseValidator<Odontologo> {

    @Override
    public void validar(Odontologo odontologo){
        if (odontologo.getMatricula()==null || odontologo.getMatricula().isEmpty()){
            throw new ValidateServiceExceptions("La matricula es obligatorioa");
        }
        if (odontologo.getApellido()==null || odontologo.getApellido().isEmpty()){
            throw new ValidateServiceExceptions("El apellido es obligatorio");
        }
        if (odontologo.getNombre()==null || odontologo.getNombre().isEmpty()){
            throw new ValidateServiceExceptions("El nombrte es obligatorio");
        }
        if (odontologo.getApellido().length()>100){
            throw new ValidateServiceExceptions("El tamaño del apellido es muy grande");
        }
        if (odontologo.getNombre().length()>100){
            throw new ValidateServiceExceptions("El tamaño del nombre es muy grande");
        }
    }


}
