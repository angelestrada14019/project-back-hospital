package com.hospitalajea14019.projecthospitalspring.service;

import com.hospitalajea14019.projecthospitalspring.model.Paciente;
import com.hospitalajea14019.projecthospitalspring.repository.base.BaseRepository;
import com.hospitalajea14019.projecthospitalspring.repository.PacienteRepository;
import com.hospitalajea14019.projecthospitalspring.service.base.BaseServiceImpl;
import com.hospitalajea14019.projecthospitalspring.validator.PacienteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PacienteServiceImpl extends BaseServiceImpl<Paciente,Integer, PacienteValidator> implements PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public PacienteServiceImpl(BaseRepository<Paciente, Integer> baseRepository) {
        super(baseRepository);
    }
}
