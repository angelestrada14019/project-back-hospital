package com.hospitalajea14019.projecthospitalspring.controller.base;

import com.hospitalajea14019.projecthospitalspring.model.base.Base;

import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public interface BaseController<E extends Base,ID extends Serializable,D> {

    public ResponseEntity<?> findAll();
    public ResponseEntity<?> findById(ID id);
    public ResponseEntity<?> save(D entity);
    public ResponseEntity<?> update(D entity);
    public ResponseEntity<?> delete(ID id);

}
