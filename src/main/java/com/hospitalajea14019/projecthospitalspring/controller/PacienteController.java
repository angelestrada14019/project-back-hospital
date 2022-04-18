package com.hospitalajea14019.projecthospitalspring.controller;

import com.hospitalajea14019.projecthospitalspring.controller.base.BaseControllerImpl;

import com.hospitalajea14019.projecthospitalspring.converter.PacienteConverter;

import com.hospitalajea14019.projecthospitalspring.dto.PacienteDto;

import com.hospitalajea14019.projecthospitalspring.model.Paciente;

import com.hospitalajea14019.projecthospitalspring.service.PacienteServiceImpl;
import com.hospitalajea14019.projecthospitalspring.validator.PacienteValidator;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
@CrossOrigin(origins = "*")
@PreAuthorize("hasAnyRole('administrador','paciente')")
public class PacienteController extends BaseControllerImpl<Paciente,
        PacienteServiceImpl, PacienteDto, PacienteConverter, PacienteValidator> {
    public PacienteController(PacienteServiceImpl servicio, PacienteConverter converter) {
        super(servicio, converter);
    }

}
