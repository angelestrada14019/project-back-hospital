package com.hospitalajea14019.projecthospitalspring.dto.mongo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    private String email;
    private String clave;
}
