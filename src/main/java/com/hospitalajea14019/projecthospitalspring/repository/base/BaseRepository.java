package com.hospitalajea14019.projecthospitalspring.repository.base;

import com.hospitalajea14019.projecthospitalspring.model.base.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<E extends Base,ID extends Serializable> extends JpaRepository<E,ID> {
}
