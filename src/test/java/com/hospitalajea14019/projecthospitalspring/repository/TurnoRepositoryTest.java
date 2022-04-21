package com.hospitalajea14019.projecthospitalspring.repository;

import com.hospitalajea14019.projecthospitalspring.model.Odontologo;
import com.hospitalajea14019.projecthospitalspring.model.Paciente;
import com.hospitalajea14019.projecthospitalspring.model.Turno;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Slf4j
class TurnoRepositoryTest {

    @Autowired
    private TurnoRepository turnoRepository;

    @Test
    void findByOdontologo_id() {
        List<Turno> turnos = turnoRepository.findByOdontologo_id(1);
        for (Turno turno : turnos) {
            log.info(turno.toString());
        }
        assertTrue(turnos.size()>0);
    }

    @Test
    void findByPaciente_id() {
        List<Turno> turnos = turnoRepository.findByPaciente_id(1);
        for (Turno turno : turnos) {
            log.info(turno.toString());
        }
        assertTrue(turnos.size()>0);
    }
    @Test
    void saveTurno(){
        Paciente paciente =new Paciente(1);
        Odontologo odontologo =new Odontologo(1);
        Odontologo odontologoP =new Odontologo(2);
        Turno turno =new Turno(paciente,odontologo,
                LocalDate.of(2022,4,2),
                LocalTime.of(13,30,0));
        Turno turnoG = turnoRepository.save(turno);

        //assertNotNull(turnoG);
        assertEquals(turnoG.getOdontologo_id().getId(),odontologo.getId());

    }
}