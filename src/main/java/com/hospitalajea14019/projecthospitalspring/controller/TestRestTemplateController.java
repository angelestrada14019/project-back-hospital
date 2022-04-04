package com.hospitalajea14019.projecthospitalspring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospitalajea14019.projecthospitalspring.dto.TestRestTemplateDto;

import com.hospitalajea14019.projecthospitalspring.utils.WrapperResponse;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@RestController
@RequestMapping("/test")
@Slf4j
public class TestRestTemplateController {



    @GetMapping("/{code}")
    public ResponseEntity<WrapperResponse<TestRestTemplateDto[]>> buscar(@PathVariable String code){

        RestTemplate restTemplate=new RestTemplate();
        TestRestTemplateDto[] testRestTemplateDto =restTemplate.getForObject(
                ("https://restcountries.com/v3.1/alpha/"+code),
                TestRestTemplateDto[].class);
//                HttpResponse<String> jsonResponse=null;
//        TestRestTemplateDto[] testRestTemplateDto=null;
        // try{
//            jsonResponse= Unirest.get("https://restcountries.com/v3.1/alpha/"+code).asString();
//            System.out.println(jsonResponse.getBody());
//            ObjectMapper mapper = new ObjectMapper();
//            testRestTemplateDto= mapper.readValue(jsonResponse.getBody(),  TestRestTemplateDto[].class );
//            }catch(IOException ex){
//                  ex.printStackTrace();
//            }
        return new WrapperResponse<>(true, "Succes", testRestTemplateDto).createResponse(HttpStatus.OK);
    }
}
