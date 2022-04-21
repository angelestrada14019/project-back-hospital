package com.hospitalajea14019.projecthospitalspring.service;

import com.hospitalajea14019.projecthospitalspring.exceptions.NoDataFoundExceptions;
import com.hospitalajea14019.projecthospitalspring.model.Odontologo;

import com.hospitalajea14019.projecthospitalspring.repository.base.BaseRepository;
import com.hospitalajea14019.projecthospitalspring.repository.OdontologoRepository;
import com.hospitalajea14019.projecthospitalspring.service.base.BaseServiceImpl;
import com.hospitalajea14019.projecthospitalspring.validator.OdontologoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OdontologoServiceImpl extends BaseServiceImpl<Odontologo,Integer, OdontologoValidator> implements OdontologoService{

    @Autowired
    private OdontologoRepository odontologoRepository;

    public OdontologoServiceImpl(BaseRepository<Odontologo,Integer> baseRepository, OdontologoValidator odontologoValidator) {
        super(baseRepository, odontologoValidator);
    }


    @Override
    public Odontologo findByMatricula(String matricula) {

            Odontologo odontologo= Optional.ofNullable(odontologoRepository.findByMatricula(matricula))
                    .orElseThrow(()->new NoDataFoundExceptions("No se encuentra la matricula: "+ matricula));
            return odontologo;


    }
}
