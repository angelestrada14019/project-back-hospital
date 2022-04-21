package com.hospitalajea14019.projecthospitalspring.validator;
import com.hospitalajea14019.projecthospitalspring.exceptions.ValidateServiceExceptions;
import com.hospitalajea14019.projecthospitalspring.model.Perfil;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class PerfilValidator extends BaseValidator<Perfil>{
    @Override
    public void validar(Perfil entity) {
        if (entity.getNombre()==null || entity.getNombre().trim().isEmpty()){
            throw new ValidateServiceExceptions("El nombre es obligatorio");
        }
    }
}
