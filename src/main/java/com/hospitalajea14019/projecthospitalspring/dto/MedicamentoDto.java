package com.hospitalajea14019.projecthospitalspring.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicamentoDto {


    private String nombre;

    private String codigoNumerico;

    private String laboratorioProduccion;

    private Integer cantidad;

    private Double precio;
}
