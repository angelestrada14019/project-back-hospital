package com.hospitalajea14019.projecthospitalspring.service;

import com.hospitalajea14019.projecthospitalspring.model.Domicilio;
import com.hospitalajea14019.projecthospitalspring.repository.DomicilioRepository;
import com.hospitalajea14019.projecthospitalspring.repository.base.BaseRepository;
import com.hospitalajea14019.projecthospitalspring.service.base.BaseServiceImpl;
import com.hospitalajea14019.projecthospitalspring.validator.DomicilioValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio,Integer, DomicilioValidator> implements DomicilioService{

    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Integer> baseRepository , DomicilioValidator domicilioValidator) {
        super(baseRepository, domicilioValidator);
    }
}
