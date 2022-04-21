package com.hospitalajea14019.projecthospitalspring.repository;


import com.hospitalajea14019.projecthospitalspring.model.Turno;
import com.hospitalajea14019.projecthospitalspring.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TurnoRepository extends BaseRepository<Turno,Integer> {

    @Query("select t from Turno t where t.odontologo_id.id=?1")
    public List<Turno> findByOdontologo_id(Integer odontologo_id);
    @Query("select t from Turno t where t.paciente_id.id=?1")
    public List<Turno> findByPaciente_id(Integer paciente_id);
}
