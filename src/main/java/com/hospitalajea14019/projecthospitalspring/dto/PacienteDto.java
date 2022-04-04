package com.hospitalajea14019.projecthospitalspring.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hospitalajea14019.projecthospitalspring.model.Domicilio;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

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

    private Domicilio domicilio_id;
}
