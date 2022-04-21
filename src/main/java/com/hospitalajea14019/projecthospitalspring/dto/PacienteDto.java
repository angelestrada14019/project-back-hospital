package com.hospitalajea14019.projecthospitalspring.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hospitalajea14019.projecthospitalspring.model.Domicilio;
import com.hospitalajea14019.projecthospitalspring.model.Turno;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDto {

    private Integer id;
    private String apellido;
    private String nombre;
    private String dni;
    private LocalDate fechaIngreso;

    @JsonIgnore
    private Set<Turno> turnos;
    @JsonIgnoreProperties(value = {"calle","numero", "localidad", "provincia"})
    private Domicilio domicilio_id;
}
