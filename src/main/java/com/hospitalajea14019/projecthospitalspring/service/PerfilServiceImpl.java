package com.hospitalajea14019.projecthospitalspring.service;

import com.hospitalajea14019.projecthospitalspring.model.Perfil;
import com.hospitalajea14019.projecthospitalspring.repository.base.BaseRepository;
import com.hospitalajea14019.projecthospitalspring.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PerfilServiceImpl extends BaseServiceImpl<Perfil,Integer> {
    public PerfilServiceImpl(BaseRepository<Perfil, Integer> baseRepository) {
        super(baseRepository);
    }
}
