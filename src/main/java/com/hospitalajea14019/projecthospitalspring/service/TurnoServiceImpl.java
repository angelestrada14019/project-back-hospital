package com.hospitalajea14019.projecthospitalspring.service;


import com.hospitalajea14019.projecthospitalspring.model.Turno;

import com.hospitalajea14019.projecthospitalspring.repository.base.BaseRepository;
import com.hospitalajea14019.projecthospitalspring.service.base.BaseServiceImpl;

import com.hospitalajea14019.projecthospitalspring.validator.TurnoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TurnoServiceImpl extends BaseServiceImpl<Turno,Integer, TurnoValidator> implements TurnoService{
    public TurnoServiceImpl(BaseRepository<Turno, Integer> baseRepository) {
        super(baseRepository);
    }
}
