package com.hospitalajea14019.projecthospitalspring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hospitalajea14019.projecthospitalspring.model.Turno;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDto{

    private Integer id;
    private String nombre;
    private String apellido;
    private String matricula;
    private Set<Turno> turnos;

}
