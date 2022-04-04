package com.hospitalajea14019.projecthospitalspring.model;

import com.hospitalajea14019.projecthospitalspring.model.base.Base;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "perfil")
public class Perfil extends Base {

    @Column(name = "nombre")
    private String nombre;
}
