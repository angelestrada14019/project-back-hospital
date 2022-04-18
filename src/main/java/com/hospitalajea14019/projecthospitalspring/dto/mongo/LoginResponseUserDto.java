package com.hospitalajea14019.projecthospitalspring.dto.mongo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseUserDto {
    private UsuarioDto usuarioDto;
    private String token;
}
