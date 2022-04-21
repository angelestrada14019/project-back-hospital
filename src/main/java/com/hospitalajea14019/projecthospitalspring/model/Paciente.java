package com.hospitalajea14019.projecthospitalspring.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospitalajea14019.projecthospitalspring.model.base.Base;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "paciente")
public class Paciente extends Base {


    @Column(name = "apellido", length = 100)
    private String apellido;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "dni")
    private String dni;
    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

//    @ManyToOne
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "domicilio_id",nullable = false, updatable = false, referencedColumnName = "id", unique = true)
    private Domicilio domicilio_id;

    @OneToMany(mappedBy = "paciente_id", fetch = FetchType.LAZY)
    @JsonIgnore
    //@JsonBackReference
    private Set<Turno> turnos=new HashSet<>();

    public Paciente(Integer id) {
        super(id);
    }
}
