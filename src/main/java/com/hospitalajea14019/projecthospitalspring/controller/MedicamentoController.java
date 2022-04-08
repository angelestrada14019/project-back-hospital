package com.hospitalajea14019.projecthospitalspring.controller;

import com.hospitalajea14019.projecthospitalspring.controller.base.BaseControllerImpl;
import com.hospitalajea14019.projecthospitalspring.converter.MedicamentoConverter;
import com.hospitalajea14019.projecthospitalspring.converter.OdontologoConverter;
import com.hospitalajea14019.projecthospitalspring.dto.MedicamentoDto;
import com.hospitalajea14019.projecthospitalspring.dto.OdontologoDto;
import com.hospitalajea14019.projecthospitalspring.model.Medicamento;
import com.hospitalajea14019.projecthospitalspring.model.Odontologo;
import com.hospitalajea14019.projecthospitalspring.service.MedicamentoServiceImpl;
import com.hospitalajea14019.projecthospitalspring.service.OdontologoServiceImpl;
import com.hospitalajea14019.projecthospitalspring.validator.MedicamentoValidator;
import com.hospitalajea14019.projecthospitalspring.validator.OdontologoValidator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/odontologo")
@CrossOrigin(origins = "*")
public class MedicamentoController extends BaseControllerImpl<Medicamento, MedicamentoServiceImpl, MedicamentoDto, MedicamentoConverter, MedicamentoValidator> {
    public MedicamentoController(MedicamentoServiceImpl servicio, MedicamentoConverter converter) {
        super(servicio, converter);
    }
}
