package com.hospitalajea14019.projecthospitalspring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioDto {
    private Integer id;

    private String calle;

    private String numero;

    private String localidad;

    private String provincia;

}
