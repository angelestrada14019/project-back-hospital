package com.hospitalajea14019.projecthospitalspring.controller;

import com.hospitalajea14019.projecthospitalspring.controller.base.BaseControllerImpl;
import com.hospitalajea14019.projecthospitalspring.converter.OdontologoConverter;
import com.hospitalajea14019.projecthospitalspring.converter.TurnoConverter;
import com.hospitalajea14019.projecthospitalspring.dto.OdontologoDto;
import com.hospitalajea14019.projecthospitalspring.dto.TurnoDto;
import com.hospitalajea14019.projecthospitalspring.model.Odontologo;
import com.hospitalajea14019.projecthospitalspring.model.Turno;
import com.hospitalajea14019.projecthospitalspring.service.OdontologoServiceImpl;
import com.hospitalajea14019.projecthospitalspring.service.TurnoServiceImpl;
import com.hospitalajea14019.projecthospitalspring.validator.OdontologoValidator;
import com.hospitalajea14019.projecthospitalspring.validator.TurnoValidator;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turno")
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('administrador')")
public class TurnoController extends BaseControllerImpl<Turno, TurnoServiceImpl, TurnoDto, TurnoConverter, TurnoValidator> {
    public TurnoController(TurnoServiceImpl servicio, TurnoConverter converter) {
        super(servicio, converter);
    }
}
