package com.hospitalajea14019.projecthospitalspring.controller;


import com.hospitalajea14019.projecthospitalspring.controller.base.BaseController;
import com.hospitalajea14019.projecthospitalspring.controller.base.BaseControllerImpl;
import com.hospitalajea14019.projecthospitalspring.converter.OdontologoConverter;
import com.hospitalajea14019.projecthospitalspring.dto.OdontologoDto;
import com.hospitalajea14019.projecthospitalspring.model.Odontologo;

import com.hospitalajea14019.projecthospitalspring.service.OdontologoService;
import com.hospitalajea14019.projecthospitalspring.service.OdontologoServiceImpl;

import com.hospitalajea14019.projecthospitalspring.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
@CrossOrigin(origins = "*")
public class OdontologoController extends BaseControllerImpl<Odontologo,OdontologoServiceImpl,OdontologoDto,OdontologoConverter> {

    @Autowired
    private OdontologoService odontologoService;

    public OdontologoController(OdontologoServiceImpl servicio, OdontologoConverter converter) {
        super(servicio, converter);
    }
}
