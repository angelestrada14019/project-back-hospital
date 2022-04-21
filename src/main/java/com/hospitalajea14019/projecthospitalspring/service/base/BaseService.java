package com.hospitalajea14019.projecthospitalspring.service.base;


import com.hospitalajea14019.projecthospitalspring.model.base.Base;

import java.io.Serializable;
import java.util.List;

public interface BaseService <E extends Base,ID extends Serializable>{

    public List<E> findAll();
    public E findById(ID id);
    public E save(E entity);
    public E update(E entity);
    public Boolean delete(ID id);

}
