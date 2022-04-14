package com.hospitalajea14019.projecthospitalspring.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hospitalajea14019.projecthospitalspring.model.Odontologo;
import com.hospitalajea14019.projecthospitalspring.model.Paciente;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)

public class TurnoDto {

    private Integer id;
    @JsonIgnoreProperties(value = {"nombre","apellido", "dni", "fechaIngreso","domicilio_id","turnos"})
    private Paciente paciente_id;
    @JsonIgnoreProperties(value = {"nombre","apellido", "matricula", "turnos"})
    private Odontologo odontologo_id;
    private LocalDate fecha;
    private LocalTime hora;
}
