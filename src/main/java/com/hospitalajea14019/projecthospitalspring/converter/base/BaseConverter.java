package com.hospitalajea14019.projecthospitalspring.converter.base;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.hospitalajea14019.projecthospitalspring.model.base.Base;

import java.lang.reflect.ParameterizedType;


public class BaseConverter<E extends Base, D>  extends AbstractConverter<E,D>{
    private ObjectMapper mapper=new ObjectMapper();

    private  Class<D> d;
    private Class<E> e;

    public BaseConverter() {
        this.d= (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.e= (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    @Override
    public D fromEntity(E entity) {

        return  mapper.convertValue(entity,d);
    }

    @Override
    public E fromDto(D dto) {
        return mapper.convertValue(dto, e);
    }
}
