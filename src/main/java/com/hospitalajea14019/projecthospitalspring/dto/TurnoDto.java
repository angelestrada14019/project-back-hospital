package com.hospitalajea14019.projecthospitalspring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hospitalajea14019.projecthospitalspring.model.Odontologo;
import com.hospitalajea14019.projecthospitalspring.model.Paciente;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.criteria.CriteriaBuilder;
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
    private Integer paciente_id;
    private Integer odontologo_id;
    private LocalDate fecha;
    private LocalTime hora;
}
