package com.hospitalajea14019.projecthospitalspring.dto.mongo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDto {

    private String id;
    @NotNull(message = "debe asignar un perfil")
    private Integer perfil_id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer odontologo_id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer paciente_id;
    @NotEmpty(message = "el email no debe ser vacio o nulo")
    @Size(min = 2,max = 100,message = "el email es muy largo o corto")
    private String email;
    @NotEmpty(message = "la clave no debe ser vacio o nulo")
    private String clave;
}
