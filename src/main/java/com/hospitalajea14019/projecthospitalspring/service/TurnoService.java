package com.hospitalajea14019.projecthospitalspring.service;

import com.hospitalajea14019.projecthospitalspring.model.Turno;
import com.hospitalajea14019.projecthospitalspring.service.base.BaseService;

public interface TurnoService  extends BaseService<Turno,Integer> {

    public Turno saveTurnoWithNotEqualsDateTime(Turno turno);

}
