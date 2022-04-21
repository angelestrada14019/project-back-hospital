package com.hospitalajea14019.projecthospitalspring.controller;



import com.hospitalajea14019.projecthospitalspring.controller.base.BaseControllerImpl;
import com.hospitalajea14019.projecthospitalspring.converter.OdontologoConverter;
import com.hospitalajea14019.projecthospitalspring.dto.OdontologoDto;
import com.hospitalajea14019.projecthospitalspring.model.Odontologo;

import com.hospitalajea14019.projecthospitalspring.service.OdontologoService;
import com.hospitalajea14019.projecthospitalspring.service.OdontologoServiceImpl;

import com.hospitalajea14019.projecthospitalspring.utils.WrapperResponse;
import com.hospitalajea14019.projecthospitalspring.validator.OdontologoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
@CrossOrigin(origins = "*")
public class OdontologoController extends BaseControllerImpl<Odontologo,OdontologoServiceImpl,OdontologoDto,OdontologoConverter, OdontologoValidator> {

    @Autowired
    private OdontologoService odontologoService;

    @Autowired
    private OdontologoConverter odontologoConverter;

    public OdontologoController(OdontologoServiceImpl servicio, OdontologoConverter converter) {
        super(servicio, converter);
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<WrapperResponse<OdontologoDto>> findById(@PathVariable String matricula){
        Odontologo entity = odontologoService.findByMatricula(matricula);
        OdontologoDto dto = odontologoConverter.fromEntity(entity);
        return new WrapperResponse<>(true,"Succes",dto).createResponse(HttpStatus.OK);
    }

}
