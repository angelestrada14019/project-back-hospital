package com.hospitalajea14019.projecthospitalspring.model;

import com.hospitalajea14019.projecthospitalspring.model.base.Base;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "medicamento")
public class Medicamento extends Base {

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "codigo_numerico")
    private String codigoNumerico;
    @Column(name = "laboratorio_produccion")
    private String laboratorioProduccion;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio")
    private Double precio;
}
