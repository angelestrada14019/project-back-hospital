package com.hospitalajea14019.projecthospitalspring.service;


import com.hospitalajea14019.projecthospitalspring.exceptions.GeneralServicesExceptions;
import com.hospitalajea14019.projecthospitalspring.exceptions.NoDataFoundExceptions;
import com.hospitalajea14019.projecthospitalspring.exceptions.ValidateServiceExceptions;
import com.hospitalajea14019.projecthospitalspring.model.Turno;

import com.hospitalajea14019.projecthospitalspring.repository.TurnoRepository;
import com.hospitalajea14019.projecthospitalspring.repository.base.BaseRepository;
import com.hospitalajea14019.projecthospitalspring.service.base.BaseServiceImpl;

import com.hospitalajea14019.projecthospitalspring.validator.TurnoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TurnoServiceImpl extends BaseServiceImpl<Turno,Integer, TurnoValidator> implements TurnoService{

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    TurnoValidator turnoValidator;
    public TurnoServiceImpl(BaseRepository<Turno, Integer> baseRepository, TurnoValidator turnoValidator) {
        super(baseRepository, turnoValidator);
    }

    @Override
    public Turno saveTurnoWithNotEqualsDateTime(Turno turno) {
        List<Turno> turnosByOdo = turnoRepository.findByOdontologo_id(turno.getOdontologo_id().getId());
        List<Turno> turnosByPaci = turnoRepository.findByPaciente_id(turno.getPaciente_id().getId());
        log.info(turnosByOdo.toString());
        try {
            //validator
            turnoValidator.validar(turno);
            for (Turno turnoOdo : turnosByOdo) {
                if (turnoOdo.getFecha().equals(turno.getFecha()) && (turnoOdo.getHora().equals(turno.getHora())) ){
                    throw new ValidateServiceExceptions("fechas iguales en odontologos");
                }
            }
            for (Turno turnoPaci : turnosByPaci) {
                if (turnoPaci.getFecha().equals(turno.getFecha()) && turnoPaci.getHora().equals(turno.getHora())){
                    throw new ValidateServiceExceptions("fechas iguales en pacientes");
                }
            }
            return  baseRepository.save(turno);

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }

    }
}
