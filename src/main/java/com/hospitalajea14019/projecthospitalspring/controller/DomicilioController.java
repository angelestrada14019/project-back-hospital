package com.hospitalajea14019.projecthospitalspring.controller;

import com.hospitalajea14019.projecthospitalspring.controller.base.BaseControllerImpl;
import com.hospitalajea14019.projecthospitalspring.converter.DomicilioConverter;
import com.hospitalajea14019.projecthospitalspring.converter.OdontologoConverter;
import com.hospitalajea14019.projecthospitalspring.dto.DomicilioDto;
import com.hospitalajea14019.projecthospitalspring.dto.OdontologoDto;
import com.hospitalajea14019.projecthospitalspring.model.Domicilio;
import com.hospitalajea14019.projecthospitalspring.model.Odontologo;
import com.hospitalajea14019.projecthospitalspring.service.DomicilioServiceImpl;
import com.hospitalajea14019.projecthospitalspring.service.OdontologoServiceImpl;
import com.hospitalajea14019.projecthospitalspring.validator.DomicilioValidator;
import com.hospitalajea14019.projecthospitalspring.validator.OdontologoValidator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domicilio")
@CrossOrigin(origins = "*")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl, DomicilioDto, DomicilioConverter, DomicilioValidator> {
    public DomicilioController(DomicilioServiceImpl servicio, DomicilioConverter converter) {
        super(servicio, converter);
    }
}
