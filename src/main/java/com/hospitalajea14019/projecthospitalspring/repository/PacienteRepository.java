package com.hospitalajea14019.projecthospitalspring.repository;

import com.hospitalajea14019.projecthospitalspring.model.Paciente;
import com.hospitalajea14019.projecthospitalspring.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends BaseRepository<Paciente,Integer> {
}
