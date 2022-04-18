package com.hospitalajea14019.projecthospitalspring.controller.base;


import com.hospitalajea14019.projecthospitalspring.converter.base.AbstractConverter;
import com.hospitalajea14019.projecthospitalspring.model.base.Base;
import com.hospitalajea14019.projecthospitalspring.service.base.BaseServiceImpl;
import com.hospitalajea14019.projecthospitalspring.utils.WrapperResponse;
import com.hospitalajea14019.projecthospitalspring.validator.BaseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@PreAuthorize("hasAnyRole('administrador','paciente','odontologo')")
public abstract class BaseControllerImpl<E extends Base,
        S extends BaseServiceImpl<E, Integer, V >, D, C extends AbstractConverter<E, D>,
        V extends BaseValidator<E>> implements  BaseController<E,Integer,D> {


    private S servicio;
    private C converter;


    public BaseControllerImpl(S servicio, C converter) {
        this.servicio = servicio;
        this.converter = converter;
    }


    @GetMapping("")
    @Override
    public ResponseEntity<WrapperResponse<List<D>>> findAll() {
        List<E> entitys = servicio.findAll();
        List<D> dtos = converter.fromEntity(entitys);
        log.info("oase por base controller findall");
        log.info(String.valueOf(dtos));
        return new WrapperResponse<>(true, "Succes", dtos).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<WrapperResponse<D>> findById(@PathVariable Integer id) {
        E entity = servicio.findById(id);
        D dto = converter.fromEntity(entity);
        return new WrapperResponse<>(true, "Succes", dto).createResponse(HttpStatus.OK);
    }

    @PostMapping("")
    @Override
    public ResponseEntity<WrapperResponse<D>> save(@RequestBody D dto) {//@Valid
        E entity = servicio.save(converter.fromDto(dto));
        log.info("pase por save de controller");
        D dtoS = converter.fromEntity(entity);

        return new WrapperResponse<>(true, "Create Succes", dtoS).createResponse(HttpStatus.CREATED);
    }

    @PutMapping("")
    @Override
    public ResponseEntity<WrapperResponse<D>> update(@RequestBody D dto) {//@Valid
        E entity = servicio.update(converter.fromDto(dto));
        D dtoS = converter.fromEntity(entity);

        return new WrapperResponse<>(true, "Update Succes", dtoS).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<WrapperResponse<Boolean>> delete(@PathVariable Integer id) {
        Boolean deletS = servicio.delete(id);
        return new WrapperResponse<>(true, "Delete Succes", deletS).createResponse(HttpStatus.OK);
    }
}


