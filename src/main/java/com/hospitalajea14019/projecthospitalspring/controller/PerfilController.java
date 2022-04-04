package com.hospitalajea14019.projecthospitalspring.controller;

import com.hospitalajea14019.projecthospitalspring.controller.base.BaseControllerImpl;
import com.hospitalajea14019.projecthospitalspring.converter.PerfilConverter;
import com.hospitalajea14019.projecthospitalspring.dto.PerfilDto;
import com.hospitalajea14019.projecthospitalspring.model.Perfil;
import com.hospitalajea14019.projecthospitalspring.service.PerfilServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil")
@CrossOrigin(origins = "*")
public class PerfilController extends BaseControllerImpl<Perfil, PerfilServiceImpl, PerfilDto, PerfilConverter> {
    public PerfilController(PerfilServiceImpl servicio, PerfilConverter converter) {
        super(servicio, converter);
    }
}
