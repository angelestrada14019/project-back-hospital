package com.hospitalajea14019.projecthospitalspring.controller;

import com.hospitalajea14019.projecthospitalspring.controller.base.BaseControllerImpl;
import com.hospitalajea14019.projecthospitalspring.converter.OdontologoConverter;
import com.hospitalajea14019.projecthospitalspring.converter.TurnoConverter;
import com.hospitalajea14019.projecthospitalspring.dto.OdontologoDto;
import com.hospitalajea14019.projecthospitalspring.dto.TurnoDto;
import com.hospitalajea14019.projecthospitalspring.model.Odontologo;
import com.hospitalajea14019.projecthospitalspring.model.Turno;
import com.hospitalajea14019.projecthospitalspring.service.OdontologoServiceImpl;
import com.hospitalajea14019.projecthospitalspring.service.TurnoService;
import com.hospitalajea14019.projecthospitalspring.service.TurnoServiceImpl;
import com.hospitalajea14019.projecthospitalspring.utils.WrapperResponse;
import com.hospitalajea14019.projecthospitalspring.validator.OdontologoValidator;
import com.hospitalajea14019.projecthospitalspring.validator.TurnoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turno")
@CrossOrigin(origins = "*")
@Slf4j
public class TurnoController extends BaseControllerImpl<Turno, TurnoServiceImpl, TurnoDto, TurnoConverter, TurnoValidator> {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private TurnoConverter turnoConverter;
    public TurnoController(TurnoServiceImpl servicio, TurnoConverter converter) {
        super(servicio, converter);
    }

    @PostMapping("/correct")
    public ResponseEntity<WrapperResponse<TurnoDto>> save(@RequestBody TurnoDto turnoDto) {
        Turno entity = turnoService.saveTurnoWithNotEqualsDateTime(turnoConverter.fromDto(turnoDto));
        log.info("pase por save de controller");
        TurnoDto dtoS = turnoConverter.fromEntity(entity);

        return new WrapperResponse<>(true, "Create Succes", dtoS).createResponse(HttpStatus.CREATED);
    }
}
