package com.hospitalajea14019.projecthospitalspring.service;

import com.hospitalajea14019.projecthospitalspring.model.Odontologo;
import com.hospitalajea14019.projecthospitalspring.service.base.BaseService;

public interface OdontologoService extends BaseService<Odontologo,Integer> {

    public Odontologo findByMatricula(String matricula);
}
