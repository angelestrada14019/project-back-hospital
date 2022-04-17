package com.hospitalajea14019.projecthospitalspring.dto.mongo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDto {

    private String id;
    private Integer perfil_id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer odontologo_id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer paciente_id;
    private String email;
    private String clave;
}
