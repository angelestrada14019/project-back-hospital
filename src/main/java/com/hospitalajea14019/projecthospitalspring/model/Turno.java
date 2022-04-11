package com.hospitalajea14019.projecthospitalspring.model;


import com.hospitalajea14019.projecthospitalspring.model.base.Base;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "turno")
public class Turno extends Base {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id",nullable = false,updatable = false,referencedColumnName = "id")
    private Paciente paciente_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "odontologo_id",nullable = false,updatable = false,referencedColumnName = "id")
    private Odontologo odontologo_id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalTime hora;
    //YYYY-MM-DD hh:mm:ss[.nnnnnnn]

    public Integer getIdPaciente(){
        return paciente_id.getId();
    }
    public Integer getIdOdontologo(){
        return paciente_id.getId();
    }
}
