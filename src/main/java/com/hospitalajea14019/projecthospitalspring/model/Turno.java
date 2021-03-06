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

    @ManyToOne
    @JoinColumn(name = "paciente_id",referencedColumnName = "id")
    private Paciente paciente_id;

    @ManyToOne
    @JoinColumn(name = "odontologo_id",referencedColumnName = "id")
    private Odontologo odontologo_id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalTime hora;

    //YYYY-MM-DD hh:mm:ss[.nnnnnnn]


}
