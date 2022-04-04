package com.hospitalajea14019.projecthospitalspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospitalajea14019.projecthospitalspring.model.base.Base;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "odontologo")
public class Odontologo extends Base {
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "matricula")
    private String matricula;

    @OneToMany(mappedBy = "odontologo_id")
    @JsonIgnore
    private Set<Turno> turnos=new HashSet<>();


}
