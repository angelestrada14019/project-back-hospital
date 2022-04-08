package com.hospitalajea14019.projecthospitalspring.validator;

import com.hospitalajea14019.projecthospitalspring.model.base.Base;

public abstract class BaseValidator<E extends Base> {
    public abstract void validar(E entity);
}
