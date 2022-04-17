package com.hospitalajea14019.projecthospitalspring.model.mongo;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "usuario")
public class Usuario {

    @Id
    private String id;
    @Field(name = "perfil_id")
    private Integer perfil_id;
    @Field(name = "odontologo_id")
    private Integer odontologo_id;
    @Field(name = "paciente_id")
    private Integer paciente_id;
    @Field(name = "email")
    @Indexed(unique = true)
    private String email;
    @Field(name = "clave")
    private String clave;


}
