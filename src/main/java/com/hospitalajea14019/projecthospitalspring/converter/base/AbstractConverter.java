package com.hospitalajea14019.projecthospitalspring.converter.base;



import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<E,D> {



    public abstract D fromEntity(E entity);
    public abstract E fromDto(D dto);

    public List<D> fromEntity(List<E> entitys){
        return entitys.stream().map(e -> fromEntity(e)).collect(Collectors.toList());
    }
    public List<E> fromDto(List<D> dto){
        return dto.stream().map(e -> fromDto(e)).collect(Collectors.toList());
    }
}
