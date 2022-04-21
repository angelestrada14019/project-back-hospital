package com.hospitalajea14019.projecthospitalspring.validator;

import com.hospitalajea14019.projecthospitalspring.exceptions.ValidateServiceExceptions;
import com.hospitalajea14019.projecthospitalspring.model.Turno;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


@Component
@NoArgsConstructor
@Slf4j
public class TurnoValidator extends BaseValidator<Turno> {
    @Override
    public void validar(Turno entity) {
        if (entity.getFecha()==null){
            throw new ValidateServiceExceptions("La fecha es obligatoria");
        }
        if (entity.getHora()==null){
            throw new ValidateServiceExceptions("La hora es obligatoria");
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            dateFormat.parse(entity.getFecha().toString());
        } catch (ParseException e) {
            throw new ValidateServiceExceptions("La fecha no tiene un formato valido");
        }
        try {
            String timeColonPattern = "HH:mm:ss";
            DateTimeFormatter hourFormat= DateTimeFormatter.ofPattern(timeColonPattern);
            hourFormat.format(entity.getHora());
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new ValidateServiceExceptions("La hora no tiene un formato valido");
        }


    }
}
