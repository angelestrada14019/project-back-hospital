package com.hospitalajea14019.projecthospitalspring.repository;

import com.hospitalajea14019.projecthospitalspring.model.Odontologo;
import com.hospitalajea14019.projecthospitalspring.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends BaseRepository<Odontologo,Integer> {

    @Query("select o from Odontologo o where o.matricula=?1")
    public Odontologo findByMatricula(String matricula);

}
