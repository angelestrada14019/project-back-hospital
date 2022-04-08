package com.hospitalajea14019.projecthospitalspring.service;

import com.hospitalajea14019.projecthospitalspring.model.Medicamento;
import com.hospitalajea14019.projecthospitalspring.model.Odontologo;
import com.hospitalajea14019.projecthospitalspring.repository.base.BaseRepository;
import com.hospitalajea14019.projecthospitalspring.service.base.BaseServiceImpl;
import com.hospitalajea14019.projecthospitalspring.validator.MedicamentoValidator;
import com.hospitalajea14019.projecthospitalspring.validator.OdontologoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MedicamentoServiceImpl extends BaseServiceImpl<Medicamento,Integer, MedicamentoValidator> implements MedicamentoService{
    public MedicamentoServiceImpl(BaseRepository<Medicamento, Integer> baseRepository) {
        super(baseRepository);
    }
}
