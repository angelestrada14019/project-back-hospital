package com.hospitalajea14019.projecthospitalspring.utils;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("password"));
    }
}
